package com.aveyon.meivsm;

import java.util.List;
import java.util.Map;

import com.aveyon.meivsm.parser.PlantUmlBaseListener;
import com.aveyon.meivsm.parser.PlantUmlParser.AssignmentContext;
import com.aveyon.meivsm.parser.PlantUmlParser.CompOperationContext;
import com.aveyon.meivsm.parser.PlantUmlParser.CondExprContext;
import com.aveyon.meivsm.parser.PlantUmlParser.EmptyTransContext;
import com.aveyon.meivsm.parser.PlantUmlParser.ExpressionContext;
import com.aveyon.meivsm.parser.PlantUmlParser.ExpressionStatementContext;
import com.aveyon.meivsm.parser.PlantUmlParser.FieldDeclrAndAssignmentContext;
import com.aveyon.meivsm.parser.PlantUmlParser.FieldDeclrAndExprAssignmentContext;
import com.aveyon.meivsm.parser.PlantUmlParser.JustAConstantContext;
import com.aveyon.meivsm.parser.PlantUmlParser.JustAVariableContext;
import com.aveyon.meivsm.parser.PlantUmlParser.MathOperationContext;
import com.aveyon.meivsm.parser.PlantUmlParser.MethodCallContext;
import com.aveyon.meivsm.parser.PlantUmlParser.NoParamMethContext;
import com.aveyon.meivsm.parser.PlantUmlParser.ParamContext;
import com.aveyon.meivsm.parser.PlantUmlParser.ParamMethContext;
import com.aveyon.meivsm.parser.PlantUmlParser.PlantUmlContext;
import com.aveyon.meivsm.parser.PlantUmlParser.SentFromExprContext;
import com.aveyon.meivsm.parser.PlantUmlParser.StatementContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransCondContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransPayCondContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransPayContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransPayStarCondContext;

public class MyListener extends PlantUmlBaseListener {

    private StringBuilder smartContract;
    private List<ParamContext> preFetchedAttributes;
    private Map<String, List<StatementContext>> stateDefEntryActivitiesMap;
    private Map<String, List<StatementContext>> stateDefExitActivitiesMap;
    private boolean payStar;

    /** Name des Contracts */
    private String smartContractName;

    /**
     * Gibt an, ob bereits eine Transition bereits bearbeitet wurde. Bei
     * Transitionen werden "If"- Bedingungen erstellt. Bei mehreren müssen
     * "else-if"-Bedingungen erstellt werden. Diese Variable gibt an, ob eine
     * "else-if"-Bedingung erstellt werden soll.
     */
    boolean transitioned;

    public MyListener(List<ParamContext> attributeList, Map<String, List<StatementContext>> stateDefMap,
            Map<String, List<StatementContext>> stateDefExitActivitiesMap, boolean payStar) {
        smartContract = new StringBuilder();
        preFetchedAttributes = attributeList;
        this.stateDefEntryActivitiesMap = stateDefMap;
        this.stateDefExitActivitiesMap = stateDefExitActivitiesMap;
        this.payStar = payStar;
    }

    @Override
    public void enterPlantUml(PlantUmlContext ctx) {
        smartContractName = ctx.IDENTIFIER().toString();
        smartContract.append("pragma solidity >=0.5.0 <0.7.0;\n\n");
        smartContract.append(String.format("contract %s {\n", smartContractName));
        smartContract.append("\tstring public state = \"START\";\n");

        // Wenn das Diagramm eine pay*-Transaktion beinhaltet, werden eine Map und Array
        // für alle
        // Sender erzeugt
        if (payStar) {
            smartContract.append("\tstruct Sender {\n" + "\t\taddress payable addr;\n" + "\t\tuint date;\n"
                    + "\t\tuint val;\n" + "\t}\n");
            smartContract.append("\tSender[] public senders;\n");
            smartContract.append("\tmapping(address => Sender) public senderMap;\n");
        }

        // Attribute / Fields Deklarationen
        for (ParamContext attrCtx : preFetchedAttributes) {
            // Field/Attribut Deklaration
            if (attrCtx.t.getText().equals("address")) {
                smartContract
                        .append(String.format("\t%s payable public %s;\n", attrCtx.t.getText(), attrCtx.id.getText()));
            } else {
                smartContract.append(String.format("\t%s public %s;\n", attrCtx.t.getText(), attrCtx.id.getText()));
            }
        }

        // Fallback Function (sinnvolle Implementierung finden)
        // smartContract.append("\tfunction() external {}\n\n");

        // Hauptmethode
        smartContract.append("\tfunction handle(string memory input) public payable {\n");
    }

    @Override
    public void exitPlantUml(PlantUmlContext ctx) {
        // Ende der Hauptmethode
        smartContract.append("\t}\n\n");

        // Hilfsfunktionen
        smartContract.append("\tfunction isEqual(string memory a, string memory b) public pure" + " returns (bool) {\n"
                + "\t\treturn (keccak256(abi.encodePacked((a))) == keccak256(abi.encodePacked((b))));\n\t}\n\n");

        smartContract.append("\tfunction transfer(uint amount, address payable receiver) private {\n"
                + "\t\taddress self = address(this);\n"
                + "\t\tuint256 balance = self.balance;\n"
                + "\t\tif (balance >= amount)\n" + "\t\t\treceiver.transfer(amount);\n\t}\n");

        if (payStar) {
            smartContract.append("\tfunction returnPayments() private {\n");
            smartContract.append("\t\tfor (uint i = 0; i < senders.length; i++)\n");
            smartContract.append("\t\t\ttransfer(senderMap[senders[i].addr].val, senders[i].addr);\n");
            smartContract.append("\t}\n");

            smartContract.append("\tfunction addSender(Sender memory s) private {\n");
            smartContract.append("\t\tif (senderMap[s.addr].addr == address(0)) {\n");
            smartContract.append("\t\t\tsenders.push(s);\n");
            smartContract.append("\t\t\tsenderMap[s.addr] = s;\n");
            smartContract.append("\t\t} else {\n");
            smartContract.append("\t\t\tsenderMap[s.addr].val += s.val;\n");
            smartContract.append("\t\t}\n");
            smartContract.append("\t}\n");
        }

        // Ende des Smart Contracts
        smartContract.append("}\n");
    }

    /**
     * Verarbeiten eines einfachen Zustandsübergangs
     */
    @Override
    public void enterTrans(TransContext ctx) {
        // Zustand auf der linken Seite
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        // Eine Aktion kann erst dann ausgeführt werden, wenn Smart Contract sich im
        // Linken Zustand
        // befindet und das Eingabewort gleich dem im Diagramm definierten Wort ist
        String ifStmt = String.format("\t\t%s (isEqual(state, \"%s\") && isEqual(input, \"%s\")) {\n",
                transitioned ? "else if" : "if", state, ctx.i.getText());
        smartContract.append(ifStmt);

        // Zustand auf der rechten Seite. Smart Contract wechselt in den Zustand auf der
        // rechten
        // Seite
        String newState = ctx.r.getText().toUpperCase();

        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Override
    public void exitTrans(TransContext ctx) {
        smartContract.append("\t\t}\n");
    }

    /**
     * Verarbeiten einer Transaktion mit dem Eingabewort 'pay' und einem Geldbetrag
     * (pay 5 ether). Diese Transaktion vereinfacht das Schreiben einer Transaktion
     * mit benötigten Geldbetrag (pay [msg.value == 5 ether])
     */
    @Override
    public void enterTransPay(TransPayContext ctx) {
        // Zustand auf der linken Seite
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        // Erstellt pay Transaktion mit vom User angegebenen Geldbetrag. Smart Contract
        // muss sich aber zunächst im linken Zustand befinden
        String ifStmt = String.format(
                "\t\t%s (isEqual(state, \"%s\") && isEqual(input, \"pay\") && msg.value == %s %s) {\n",
                transitioned ? "else if" : "if", state, ctx.v.getText(), ctx.u.getText());
        smartContract.append(ifStmt);

        // Zustand auf der rechten Seite. Smart Contract wechselt in den Zustand auf der
        // rechten Seite
        String newState = ctx.r.getText().toUpperCase();

        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Override
    public void exitTransPay(TransPayContext ctx) {
        smartContract.append("\t\t}\n");
    }

    @Override
    public void enterTransPayCond(TransPayCondContext ctx) {
        // Zustand auf der linken Seite
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        // Vergleichsausdruck
        String expression = evalExpression(ctx.c.expression());

        // Erstellt pay Transaktion mit vom User angegebenen Geldbetrag. Smart Contract
        // muss sich aber zunächst im linken Zustand befinden
        String ifStmt = String.format(
                "\t\t%s (isEqual(state, \"%s\") && isEqual(input, \"pay\") && msg.value == %s %s && %s) {\n",
                transitioned ? "else if" : "if", state, ctx.v.getText(), ctx.u.getText(), expression);
        smartContract.append(ifStmt);

        // Zustand auf der rechten Seite. Smart Contract wechselt in den Zustand auf der
        // rechten Seite
        String newState = ctx.r.getText().toUpperCase();

        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Override
    public void exitTransPayCond(TransPayCondContext ctx) {
        smartContract.append("\t\t}\n");
    }

    @Override
    public void enterTransCond(TransCondContext ctx) {
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        // Vergleichsausdruck
        String expression = evalExpression(ctx.c.expression());

        smartContract.append(String.format("\t\t%s (isEqual(state, \"%s\") && isEqual(input, \"%s\") && %s) {\n",
                transitioned ? "else if" : "if", state, ctx.i.getText(), expression));

        String newState = ctx.r.getText().toUpperCase();

        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Override
    public void exitTransCond(TransCondContext ctx) {
        smartContract.append("\t\t}\n");
    }

    /**
     * Verarbeiten der Transitionen mit dem Eingabewort 'pay*' und zusätzlicher
     * Bedingung(en)
     */
    @Override
    public void enterTransPayStarCond(TransPayStarCondContext ctx) {
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        // Vergleichsausdruck
        String expression = evalExpression(ctx.c.expression());

        smartContract.append(String.format("\t\t%s (isEqual(state, \"%s\") && isEqual(input, \"%s\") && %s) {\n",
                transitioned ? "else if" : "if", state, ctx.i.getText(), expression));

        // Für pay* Transaktion jeden Sender als Struktur in einem Array und Map
        // speichern
        smartContract.append("\t\t\tSender memory s = Sender(msg.sender, now, msg.value);\n");
        smartContract.append("\t\t\taddSender(s);\n");

        String newState = ctx.r.getText().toUpperCase();

        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Override
    public void exitTransPayStarCond(TransPayStarCondContext ctx) {
        smartContract.append("\t\t}\n");
    }

    /**
     * Transitionen ohne Eingabewort sollen nicht existieren daher deprecated
     */
    @Deprecated
    @Override
    public void enterEmptyTrans(EmptyTransContext ctx) {
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        smartContract
                .append(String.format("\t\t%s (isEqual(state, \"%s\")) {\n", transitioned ? "else if" : "if", state));

        String newState = ctx.r.getText().toUpperCase();
        smartContract.append(String.format("\t\t\tstate = \"%s\";\n", newState));

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        smartContract.append(evalState(newState, state));

        transitioned = true;
    }

    @Deprecated()
    @Override
    public void exitEmptyTrans(EmptyTransContext ctx) {
        smartContract.append("\t\t}\n");
    }

    /**
     * Liefert die Aktivitäten innerhalb eines Zustands compiliert zurück
     *
     * @param state
     * @param oldState
     * @return
     */
    public String evalState(String state, String oldState) {
        StringBuilder statement = new StringBuilder();

        // Die Exit Activities des alten Zustands müssen als Code im neuen Zustand
        // gesetzt werden
        if (stateDefExitActivitiesMap.containsKey(oldState)) {
            statement.append("\t\t\t//Exit Activity of old State\n");
            for (StatementContext sCtx : stateDefExitActivitiesMap.get(oldState)) {
                if (sCtx instanceof FieldDeclrAndExprAssignmentContext) {
                    statement.append(
                            enterFieldDeclrAndExprAssignmentReturnsString((FieldDeclrAndExprAssignmentContext) sCtx));
                } else if (sCtx instanceof FieldDeclrAndAssignmentContext) {
                    statement.append(enterFieldDeclrAndAssignmentReturnsString((FieldDeclrAndAssignmentContext) sCtx));
                } else if (sCtx instanceof ExpressionStatementContext) {
                    statement.append(evalExpression(((ExpressionStatementContext) sCtx).expression()));
                }
            }
        }

        if (stateDefEntryActivitiesMap.containsKey(state)) {
            statement.append("\t\t\t//Entry Activity of new State\n");
            for (StatementContext sCtx : stateDefEntryActivitiesMap.get(state)) {
                if (sCtx instanceof FieldDeclrAndExprAssignmentContext) {
                    statement.append(
                            enterFieldDeclrAndExprAssignmentReturnsString((FieldDeclrAndExprAssignmentContext) sCtx));
                } else if (sCtx instanceof FieldDeclrAndAssignmentContext) {
                    statement.append(enterFieldDeclrAndAssignmentReturnsString((FieldDeclrAndAssignmentContext) sCtx));
                } else if (sCtx instanceof ExpressionStatementContext) {
                    statement.append(evalExpression(((ExpressionStatementContext) sCtx).expression()));
                }
            }
        }

        return statement.toString();
    }

    /**
     * Wird nur dann aufgerufen, wenn StateDef der Elternknoten ist => nur innerhalb
     * der handle()-Funktion
     */
    public String enterFieldDeclrAndExprAssignmentReturnsString(FieldDeclrAndExprAssignmentContext ctx) {
        String expression = evalExpression(ctx.r);

        return String.format("\t\t\t%s = %s;\n", ctx.p.id.getText(), expression);
    }

    /**
     * Wird nur dann aufgerufen, wenn StateDef der Elternknoten ist => nur innerhalb
     * der handle()-Funktion
     */
    public String enterFieldDeclrAndAssignmentReturnsString(FieldDeclrAndAssignmentContext ctx) {
        return String.format("\t\t\t%s = %s;\n", ctx.p.id.getText(), ctx.r.getText());
    }

    /**
     * Evaluiert/Kompiliert eine Expression (Ausdruck)
     *
     * @param ctx
     * @return
     */
    public String evalExpression(ExpressionContext ctx) {
        String expression = "";
        if (ctx instanceof MathOperationContext) {
            expression = enterMathOperationReturnsString((MathOperationContext) ctx);
        } else if (ctx instanceof CompOperationContext) {
            expression = enterCompOperationReturnsString((CompOperationContext) ctx);
        } else if (ctx instanceof AssignmentContext) {
            expression = enterAssignmentReturnsString((AssignmentContext) ctx);
        } else if (ctx instanceof SentFromExprContext) {
            expression = enterSentFromExprReturnsString((SentFromExprContext) ctx);
        } else if (ctx instanceof MethodCallContext) {
            expression = enterMethodCallReturnsString((MethodCallContext) ctx);
        } else if (ctx instanceof JustAVariableContext) {
            expression = enterJustAVariableReturnsString((JustAVariableContext) ctx);
        } else if (ctx instanceof JustAConstantContext) {
            expression = enterJustAConstantReturnsString((JustAConstantContext) ctx);
        } else if (ctx instanceof CondExprContext) {
            expression = enterCondExprReturnsString((CondExprContext) ctx);
        }
        return expression;
    }

    /**
     * Kompiliert (rekursiv) einen mathematischen Ausdruck. Rekursiv, wenn auf der
     * Rechten oder linken Seite des Ausdrucks wieder eine Expression (Ausdruck)
     * vorhanden ist
     *
     * @param ctx
     * @return
     */
    public String enterMathOperationReturnsString(MathOperationContext ctx) {
        String leftSide = evalExpression(ctx.lv);
        String rightSide = evalExpression(ctx.rv);
        return String.format("%s %s %s", leftSide, ctx.op.getText(), rightSide);
    }

    /**
     * Kompiliert (rekursiv) einen VergleichsAusdruck. Rekursiv, wenn auf der
     * Rechten oder Linken Seite des Ausdrucks wieder e ine Expression (Ausdruck)
     * vorhanden ist
     *
     * @param ctx
     * @return
     */
    public String enterCompOperationReturnsString(CompOperationContext ctx) {
        String leftSide = evalExpression(ctx.lv);
        String rightSide = evalExpression(ctx.rv);
        return String.format("%s %s %s", leftSide, ctx.op.getText(), rightSide);
    }

    /**
     * Kompiliert eine Zuweisung
     *
     * @param ctx
     * @return
     */
    public String enterAssignmentReturnsString(AssignmentContext ctx) {
        String rightSide = evalExpression(ctx.r);
        return String.format("\t\t\t%s = %s;\n", ctx.l.getText(), rightSide);
    }

    /**
     * Wertet einen 'sent from x' Ausdruck aus. 'sent from x' ist äquivalent zu
     * [msg.sender == x]
     */
    public String enterSentFromExprReturnsString(SentFromExprContext ctx) {
        return String.format("msg.sender == %s", ctx.variable().getText());
    }

    public String enterMethodCallReturnsString(MethodCallContext ctx) {
        if (ctx.method() instanceof NoParamMethContext) {
            return enterNoParamMethReturnsString((NoParamMethContext) ctx.method());
        } else { // ParamMeth
            return enterParamMethReturnsString((ParamMethContext) ctx.method());
        }
    }

    /**
     * Wertet verknüpfte Bedingungen (Wahrheitswerte, Bool) aus
     */
    public String enterCondExprReturnsString(CondExprContext ctx) {
        String op = ctx.op.getText().equals("&") ? "&&" : "||";
        return String.format("%s %s %s", evalExpression(ctx.l), op, evalExpression(ctx.r));
    }

    public String enterJustAVariableReturnsString(JustAVariableContext ctx) {
        return ctx.getText();
    }

    public String enterJustAConstantReturnsString(JustAConstantContext ctx) {
        if (ctx.constant().getChildCount() == 2) { // Konstante mit Einheit, z. B. 1 days oder 2 ether
            return ctx.constant().getChild(0).getText() + " " + ctx.constant().getChild(1).getText();
        } else {
            return ctx.getText();
        }
    }

    public String enterNoParamMethReturnsString(NoParamMethContext ctx) {
        return String.format("\t\t\t%s();\n", ctx.id.getText());
    }

    /**
     * Compiliert einen Methodenaufruf Beachtet dabei, dass ein beliebige Anzahl an
     * Parametern gesetzt sein kann
     *
     * @param ctx
     * @return
     */
    public String enterParamMethReturnsString(ParamMethContext ctx) {
        StringBuilder sb = new StringBuilder();
        // Methodenname
        sb.append(String.format("\t\t\t%s(", ctx.id.getText()));

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof ExpressionContext) {
                sb.append(evalExpression((ExpressionContext) ctx.getChild(i)));
                // Komma als Seperierung hinzufügen
                sb.append(", ");
            }
        }
        // Letztes Komma mit Leerzeichen entfernen
        sb.delete(sb.length() - 2, sb.length());

        sb.append(");\n");

        return sb.toString();
    }

    /**
     * @return the smartContract
     */
    public StringBuilder getSmartContract() {
        return smartContract;
    }

    public String getSmartContractName() {
        return smartContractName;
    }

    public void setSmartContractName(String smartContractName) {
        this.smartContractName = smartContractName;
    }
}
