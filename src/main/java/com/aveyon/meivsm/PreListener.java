package com.aveyon.meivsm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.aveyon.meivsm.parser.PlantUmlBaseListener;
import com.aveyon.meivsm.parser.PlantUmlParser.ParamContext;
import com.aveyon.meivsm.parser.PlantUmlParser.StateDefContext;
import com.aveyon.meivsm.parser.PlantUmlParser.StatementContext;
import com.aveyon.meivsm.parser.PlantUmlParser.TransPayStarCondContext;

public class PreListener extends PlantUmlBaseListener {

    private List<ParamContext> attributesList;

    /**
     * Key: Zustandsname Value: Liste der Statements, die im Zustand ausgeführt
     * werden sollen
     */
    private Map<String, List<StatementContext>> stateDefEntryActivitiesMap;

    private Map<String, List<StatementContext>> stateDefExitActivitiesMap;

    private boolean payStar;

    /**
     * Key: Zielzustand Value: Key: {"Meth" | "Condition" | "Statement"} Value:
     * Entsprechende Context Objekte
     */
    // private Map<StateContext, Map<String, ParserRuleContext>> methodMap;

    public PreListener() {
        stateDefEntryActivitiesMap = new HashMap<>();
        stateDefExitActivitiesMap = new HashMap<>();
        attributesList = new LinkedList<>();
    }

    @Override
    public void enterStateDef(StateDefContext ctx) {
        String state = ctx.state().getText().toUpperCase();

        if (ctx.ACTIVITY().getText().equals("entry/")) {
            // es existiert noch kein Value => keine Liste

            if (stateDefEntryActivitiesMap.get(state) == null) {
                stateDefEntryActivitiesMap.put(state, new LinkedList<>());
            }

            stateDefEntryActivitiesMap.get(state).add(ctx.statement());
            System.out.println(ctx.statement().getText());
        }

        if (ctx.ACTIVITY().getText().equals("exit/")) {
            if (stateDefExitActivitiesMap.get(state) == null) {
                stateDefExitActivitiesMap.put(state, new LinkedList<>());
            }

            stateDefExitActivitiesMap.get(state).add(ctx.statement());
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStateDef(StateDefContext ctx) {
    }

    @Override
    public void enterParam(ParamContext ctx) {
        attributesList.add(ctx);
    }

    @Override
    public void enterTransPayStarCond(TransPayStarCondContext ctx) {
        payStar = true;
    }

    /**
     * @return the attributes
     */
    public List<ParamContext> getAttributesList() {
        return attributesList;
    }

    /**
     * @return the stateDefEntryActivitiesMap
     */
    public Map<String, List<StatementContext>> getStateDefEntryActivitiesMap() {
        return stateDefEntryActivitiesMap;
    }

    /**
     * @param stateDefEntryActivitiesMap the stateDefEntryActivitiesMap to set
     */
    public void setStateDefEntryActivitiesMap(Map<String, List<StatementContext>> stateDefEntryActivitiesMap) {
        this.stateDefEntryActivitiesMap = stateDefEntryActivitiesMap;
    }

    /**
     * @return the stateDefExitActivitiesMap
     */
    public Map<String, List<StatementContext>> getStateDefExitActivitiesMap() {
        return stateDefExitActivitiesMap;
    }

    /**
     * @param stateDefExitActivitiesMap the stateDefExitActivitiesMap to set
     */
    public void setStateDefExitActivitiesMap(Map<String, List<StatementContext>> stateDefExitActivitiesMap) {
        this.stateDefExitActivitiesMap = stateDefExitActivitiesMap;
    }

    public boolean isPayStar() {
        return payStar;
    }
}
