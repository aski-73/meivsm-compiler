package net.aveyon.meivsm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.aveyon.meivsm.parser.PlantUmlBaseListener;
import net.aveyon.meivsm.parser.PlantUmlParser.*;
import net.aveyon.intermediate_solidity.*;
import net.aveyon.intermediate_solidity.impl.*;
import net.aveyon.intermediate_solidity.util.Pair;

/**
 * Main listener that gets called during the {@link org.antlr.v4.runtime.tree.ParseTree} walking.
 * Contains legacy code (direct code generation) and the updated version of creating first a {@link SmartContractModel}
 * instance that represents the Solidity file that can be extracted a code extractor / code generator.
 */
public class MainListener extends PlantUmlBaseListener {

    /**
     * Concrete instance of the Solidity meta model 'Intermediate Solidity'. Can be used by codde generators.
     */
    private SmartContractModel model;

    private SmartContract currentGeneratedSmartContract;

    /**
     * Main function handling all the interactions with the contract.
     */
    private Function handleFunction;

    /**
     * Main If Statement of the handle function. Controls the flow of the smart contract.
     */
    private ExpressionIf handleFunctionIf;

    /**
     * Every contract has a constructor, which contains the entry activities of the target states whose tranisiton
     * originated from the initial state.
     */
    private final Constructor constructor = new ConstructorImpl();

    /**
     * Contains the actual constructor logic.
     */
    private final Function constructorInit = new FunctionImpl("init");

    private String pragma = "<0.9.0";
    private String license = "GPL-3.0";

    private StringBuilder smartContract;
    private List<ParamContext> preFetchedAttributes;
    private Map<String, List<StatementContext>> stateDefEntryActivitiesMap;
    private Map<String, List<StatementContext>> stateDefExitActivitiesMap;
    private boolean payStar;

    private MetaInformation metaInformation = new MetaInformation();

    /**
     * Name des Contracts
     */
    private String smartContractName;

    /**
     * Gibt an, ob bereits eine Transition bereits bearbeitet wurde. Bei
     * Transitionen werden "If"- Bedingungen erstellt. Bei mehreren müssen
     * "else-if"-Bedingungen erstellt werden. Diese Variable gibt an, ob eine
     * "else-if"-Bedingung erstellt werden soll.
     */
    boolean transitioned;

    public MainListener(List<ParamContext> attributeList, Map<String, List<StatementContext>> stateDefMap,
                        Map<String, List<StatementContext>> stateDefExitActivitiesMap, boolean payStar) {
        smartContract = new StringBuilder();
        preFetchedAttributes = attributeList;
        this.stateDefEntryActivitiesMap = stateDefMap;
        this.stateDefExitActivitiesMap = stateDefExitActivitiesMap;
        this.payStar = payStar;
    }

    @Override
    public void enterPlantUml(PlantUmlContext ctx) {
        model = new SmartContractModelImpl(license, pragma);

        smartContractName = ctx.IDENTIFIER().toString();
        smartContract.append("// SPDX-License-Identifier: " + license);
        smartContract.append("pragma solidity " + pragma + ";\n\n");
        smartContract.append(String.format("contract %s {\n", smartContractName));
        smartContract.append("\tstring public state = \"START\";\n");
        Field stateField = new FieldImpl("state");
        stateField.setValue("\"START\"");
        stateField.setType("string");

        currentGeneratedSmartContract = new SmartContractImpl(smartContractName);
        model.getDefinitions().getContracts().add(currentGeneratedSmartContract);
        currentGeneratedSmartContract.getFields().add(stateField);

        // Wenn das Diagramm eine pay*-Transaktion beinhaltet, werden eine Map und Array
        // für alle Sender erzeugt
        if (payStar) {
            smartContract.append("\tstruct Sender {\n" + "\t\taddress payable addr;\n" + "\t\tuint date;\n"
                + "\t\tuint val;\n" + "\t}\n");
            smartContract.append("\tSender[] public senders;\n");
            smartContract.append("\tmapping(address => Sender) public senderMap;\n");
        }

        // Attribute / Fields Deklarationen
        for (ParamContext attrCtx : preFetchedAttributes) {
            // Field/Attribut Deklaration
            Field f = new FieldImpl(attrCtx.id.getText());
            f.setType(attrCtx.t.getText());
            f.setVisibility(Visibility.PUBLIC);

            if (attrCtx.t.getText().equals("address")) {
                smartContract
                    .append(String.format("\t%s payable public %s;\n", attrCtx.t.getText(), attrCtx.id.getText()));

                f.setPayable(true);
            } else {
                smartContract.append(String.format("\t%s public %s;\n", attrCtx.t.getText(), attrCtx.id.getText()));
            }

            currentGeneratedSmartContract.getFields().add(f);
        }

        // Fallback Function (sinnvolle Implementierung finden)
        // smartContract.append("\tfunction() external {}\n\n");

        // Init Funktion
        constructorInit.setVisibility(Visibility.INTERNAL);
        currentGeneratedSmartContract.getDefinitions().getFunctions().add(constructorInit);

        // Konstruktor
        currentGeneratedSmartContract.getDefinitions().setConstructor(constructor);
        constructor.getExpressions().add(new ExpressionStringImpl("init()"));

        // Hauptmethode
        handleFunction = new FunctionImpl("handle");
        handleFunction.setPayable(true);
        handleFunction.setVisibility(Visibility.PUBLIC);
        FunctionParameter param = new FunctionParameterImpl("input");
        param.setType("string");
        param.setDataLocation(DataLocation.MEMORY);
        handleFunction.getParameters().add(param);
        handleFunctionIf = new ExpressionIfImpl();
        handleFunction.getExpressions().add(handleFunctionIf);
        currentGeneratedSmartContract.getDefinitions().getFunctions().add(handleFunction);

        smartContract.append("\tfunction handle(string memory input) public payable {\n");
    }

    @Override
    public void exitPlantUml(PlantUmlContext ctx) {
        // Ende der Hauptmethode
        smartContract.append("\t}\n\n");

        // Hilfsfunktionen
        Function isEqual = new FunctionImpl("isEqual");
        isEqual.setVisibility(Visibility.INTERNAL);
        isEqual.setPure(true);
        isEqual.getReturns().add("bool");
        currentGeneratedSmartContract.getDefinitions().getFunctions().add(isEqual);
        FunctionParameter paramA = new FunctionParameterImpl("a");
        paramA.setType("string");
        paramA.setDataLocation(DataLocation.MEMORY);
        FunctionParameter paramB = new FunctionParameterImpl((paramA));
        paramB.setName("b");
        isEqual.getParameters().add(paramA);
        isEqual.getParameters().add(paramB);
        isEqual.getExpressions().add(
            new ExpressionStringImpl("return (keccak256(abi.encodePacked((a))) == keccak256(abi.encodePacked((b))))")
        );

        smartContract.append("\tfunction isEqual(string memory a, string memory b) internal pure" + " returns (bool) {\n"
            + "\t\treturn (keccak256(abi.encodePacked((a))) == keccak256(abi.encodePacked((b))));\n\t}\n\n");

        Function transfer = new FunctionImpl("transfer");
        transfer.setVisibility(Visibility.INTERNAL);
        currentGeneratedSmartContract.getDefinitions().getFunctions().add(transfer);
        FunctionParameter paramAmount = new FunctionParameterImpl("amount");
        paramAmount.setType("uint");
        paramAmount.setDataLocation(DataLocation.MEMORY);
        FunctionParameter paramReceiver = new FunctionParameterImpl("receiver");
        paramReceiver.setType("address");
        paramReceiver.setPayable(true);
        transfer.getParameters().add(paramAmount);
        transfer.getParameters().add(paramReceiver);
        transfer.getExpressions().add(new ExpressionStringImpl("address self = address(this)"));
        transfer.getExpressions().add(new ExpressionStringImpl("uint256 balance = self.balance"));
        ExpressionIf transferIf = new ExpressionIfImpl();
        transferIf.getConditions().add(new Pair<>("if (balance >= amount)", new LinkedList<>()));
        transferIf.getConditions().get(0).getSecond().add(new ExpressionStringImpl("receiver.transfer(amount)"));
        transfer.getExpressions().add(transferIf);

        smartContract.append("\tfunction transfer(uint amount, address payable receiver) internal {\n"
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
        // Linken Zustand befindet und das Eingabewort gleich dem im Diagramm definierten Wort ist
        String ifStmtTrimmed = String.format("%s (isEqual(state, \"%s\") && isEqual(input, \"%s\"))",
            transitioned ? "else if" : "if", state, ctx.i.getText());

        addIfStatement(ifStmtTrimmed, state, ctx.r.getText().toUpperCase());

        addTransitionMapEntry(ctx.r.getText(), ctx);
    }

    @Override
    public void exitTrans(TransContext ctx) {
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

        String ifStmtTrimmed = String.format("%s (isEqual(state, \"%s\") && isEqual(input, \"%s\") && %s)",
            transitioned ? "else if" : "if", state, ctx.i.getText(), expression);
        addIfStatement(ifStmtTrimmed, state, ctx.r.getText().toUpperCase());

        addTransitionMapEntry(ctx.r.getText(), ctx);
    }

    @Override
    public void exitTransCond(TransCondContext ctx) {
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
        String ifStmtTrimmed = String.format(
            "%s (isEqual(state, \"%s\") && isEqual(input, \"pay\") && msg.value == %s %s)",
            transitioned ? "else if" : "if", state, ctx.v.getText(), ctx.u.getText());
        addIfStatement(ifStmtTrimmed, state, ctx.r.getText().toUpperCase());

        addTransitionMapEntry(ctx.r.getText(), ctx);
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
        String ifStmtTrimmed = String.format(
            "%s (isEqual(state, \"%s\") && isEqual(input, \"pay\") && msg.value == %s %s && %s)",
            transitioned ? "else if" : "if", state, ctx.v.getText(), ctx.u.getText(), expression);
        addIfStatement(ifStmtTrimmed, state, ctx.r.getText().toUpperCase());

        addTransitionMapEntry(ctx.r.getText(), ctx);
    }

    @Override
    public void exitTransPayCond(TransPayCondContext ctx) {
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

    @Override
    public void enterEmptyTrans(EmptyTransContext ctx) {
        String state = "START";
        if (!ctx.l.getText().equals("[*]")) {
            state = ctx.l.getText().toUpperCase();
        }

        String ifStmtTrimmed = String.format("%s (isEqual(state, \"%s\"))", transitioned ? "else if" : "if", state);
        addIfStatement(ifStmtTrimmed, state, ctx.r.getText().toUpperCase());

        addTransitionMapEntry(ctx.r.getText(), ctx);
    }

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
                } else if (sCtx instanceof EmitStatementContext) {
                    statement.append(enterEmitStatementReturnsString((EmitStatementContext) sCtx));
                } else if (sCtx instanceof TransferStatementContext) {
                    statement.append(enterTransferStatementReturnsString((TransferStatementContext) sCtx));
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
                } else if (sCtx instanceof EmitStatementContext) {
                    statement.append(enterEmitStatementReturnsString((EmitStatementContext) sCtx));
                } else if (sCtx instanceof TransferStatementContext) {
                    statement.append(enterTransferStatementReturnsString((TransferStatementContext) sCtx));
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
     * Wird nur dann aufgerufen, wenn StateDef der Elternknoten ist => nur innerhalb
     * der handle()-Funktion.
     * <p>
     * Kümmert um das 'emit event()' Statements
     */
    public String enterEmitStatementReturnsString(EmitStatementContext ctx) {
        return String.format("\t\t\temit %s;\n", ctx.exp.getText());
    }

    /**
     * Wird nur dann aufgerufen, wenn StateDef der Elternknoten ist => nur innerhalb
     * der handle()-Funktion.
     * <p>
     * Kümmert um das 'transfer xx to yy ' Statements, indem es zu einem Aufruf der vordefinierten transfer() Methode
     * übersetzt wird
     */
    public String enterTransferStatementReturnsString(TransferStatementContext ctx) {
        return String.format("\t\t\ttransfer(%s, %s);\n", evalExpression(ctx.amount), ctx.receiver.getText());
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
            // "balance" is a shortcut for "this.balance"
            if (expression.equals("balance")) {
                expression = "address(this).balance";
            }
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
                // Komma als Separierung hinzufügen
                sb.append(", ");
            }
        }
        // Letztes Komma mit Leerzeichen entfernen
        sb.delete(sb.length() - 2, sb.length());

        sb.append(");\n");

        return sb.toString();
    }

    private void addIfStatement(String ifStmtTrimmed, String state, String newState) {
        // Zustand auf der rechten Seite. Smart Contract wechselt in den Zustand auf der
        // rechten Seite
        // Ist in PlantUML der rechte Zustand [*] bedeutet dies einen Endzustand
        if (newState.equals("[*]")) {
            newState = "END";
        }

        String stateTransition = String.format("state = \"%s\"", newState);
        Expression stateTransitionExpression = new ExpressionStringImpl(stateTransition);

        // Falls Aktivitäten in dem neuen Zustand existieren, diese anhängen
        String stateActivities = evalState(newState, state);

        if (state.equals("START")) {
            // Zustand auf der linken Seite ist der Startzustand => Alle Aktivitäten des Zielzustands
            // in den Konstruktor hinzufügen, anstatt als extra If-Bedingung in die handle Funktion.
            constructorInit.getExpressions().add(stateTransitionExpression);
            trimEvalState(stateActivities).forEach(e -> constructorInit.getExpressions().add(new ExpressionStringImpl(e)));
            // TODO add support for multiple outgoing transitions originating from the initial state
            // Those transitions need either a different 'Eingabewort' or different condition
        } else {
            String ifStmt = String.format("\t\t%s {\n", ifStmtTrimmed);
            smartContract.append(ifStmt);
            handleFunctionIf.getConditions().add(new Pair<>(ifStmtTrimmed, new LinkedList<>()));


            handleFunctionIf.getConditions().get(handleFunctionIf.getConditions().size() - 1).getSecond()
                .add(stateTransitionExpression);
            smartContract.append(String.format("\t\t\t%s;\n", stateTransition));
            smartContract.append(stateActivities);
            trimEvalStateValueAndAddToIfFunction(stateActivities);

            transitioned = true;
        }

    }

    /**
     * Adds entries to {@link MetaInformation#getIncomingTransitionMap()}.
     *
     * @param stateName Name of a state
     * @param t         the incoming transitions to the state
     */
    private void addTransitionMapEntry(String stateName, TransitionContext t) {
        if (!metaInformation.getIncomingTransitionMap().containsKey(stateName.toUpperCase())) {
            metaInformation.getIncomingTransitionMap().put(stateName.toUpperCase(), new LinkedList<>());
        }
        Function f;
        if (t instanceof TransContext) {
            f = new FunctionImpl(((TransContext) t).i.getText());
        } else if ((t instanceof TransCondContext)) {
            f = new FunctionImpl(((TransCondContext) t).i.getText());
        } else if ((t instanceof TransPayContext)) {
            f = new FunctionImpl(((TransPayContext) t).i.getText());
        } else if ((t instanceof TransPayCondContext)) {
            f = new FunctionImpl(((TransPayCondContext) t).i.getText());
        } else {
            f = null;
        }

        metaInformation.getIncomingTransitionMap().get(stateName.toUpperCase()).add(f);
    }

    /**
     * Helper function
     * Adds an output of {@link #evalState(String, String)} into the last element {@link #handleFunctionIf} List
     * in order to build the if command of the handle function.
     *
     * @param evalState output of {@link #evalState(String, String)}
     */
    private void trimEvalStateValueAndAddToIfFunction(String evalState) {
        trimEvalState(evalState)
            .forEach(it -> handleFunctionIf.getConditions().get(handleFunctionIf.getConditions().size() - 1).getSecond().add(new ExpressionStringImpl(it)));
    }

    /**
     * @param evalState output of {@link #evalState(String, String)}
     * @return evalState trimmed and split by \n
     */
    private List<String> trimEvalState(String evalState) {
        return Stream.of(evalState.trim().replaceAll("\\t", "").split("[;\\n]"))
            .filter(it -> it.length() > 0)
            .collect(Collectors.toList());
    }

    /**
     * @return the smartContract
     */
    public StringBuilder getSmartContract() {
        return smartContract;
    }

    public SmartContractModel getModel() {
        return model;
    }

    public MetaInformation getMetaInformation() {
        return metaInformation;
    }
}
