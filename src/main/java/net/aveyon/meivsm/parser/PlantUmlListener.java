// Generated from PlantUml.g4 by ANTLR 4.10.1
package net.aveyon.meivsm.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlantUmlParser}.
 */
public interface PlantUmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#skinParamCmds}.
	 * @param ctx the parse tree
	 */
	void enterSkinParamCmds(PlantUmlParser.SkinParamCmdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#skinParamCmds}.
	 * @param ctx the parse tree
	 */
	void exitSkinParamCmds(PlantUmlParser.SkinParamCmdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#plantUml}.
	 * @param ctx the parse tree
	 */
	void enterPlantUml(PlantUmlParser.PlantUmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#plantUml}.
	 * @param ctx the parse tree
	 */
	void exitPlantUml(PlantUmlParser.PlantUmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(PlantUmlParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(PlantUmlParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#stateDef}.
	 * @param ctx the parse tree
	 */
	void enterStateDef(PlantUmlParser.StateDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#stateDef}.
	 * @param ctx the parse tree
	 */
	void exitStateDef(PlantUmlParser.StateDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldDeclrAndExprAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclrAndExprAssignment(PlantUmlParser.FieldDeclrAndExprAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldDeclrAndExprAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclrAndExprAssignment(PlantUmlParser.FieldDeclrAndExprAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldDeclrAndAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclrAndAssignment(PlantUmlParser.FieldDeclrAndAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldDeclrAndAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclrAndAssignment(PlantUmlParser.FieldDeclrAndAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmitStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmitStatement(PlantUmlParser.EmitStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmitStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmitStatement(PlantUmlParser.EmitStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransferStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTransferStatement(PlantUmlParser.TransferStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransferStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTransferStatement(PlantUmlParser.TransferStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(PlantUmlParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(PlantUmlParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Trans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTrans(PlantUmlParser.TransContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Trans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTrans(PlantUmlParser.TransContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransCond(PlantUmlParser.TransCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransCond(PlantUmlParser.TransCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransPay}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransPay(PlantUmlParser.TransPayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransPay}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransPay(PlantUmlParser.TransPayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransPayCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransPayCond(PlantUmlParser.TransPayCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransPayCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransPayCond(PlantUmlParser.TransPayCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransPayStar}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransPayStar(PlantUmlParser.TransPayStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransPayStar}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransPayStar(PlantUmlParser.TransPayStarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransPayStarCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransPayStarCond(PlantUmlParser.TransPayStarCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransPayStarCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransPayStarCond(PlantUmlParser.TransPayStarCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyTrans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterEmptyTrans(PlantUmlParser.EmptyTransContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyTrans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitEmptyTrans(PlantUmlParser.EmptyTransContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PlantUmlParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PlantUmlParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#compOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompOperator(PlantUmlParser.CompOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#compOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompOperator(PlantUmlParser.CompOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(PlantUmlParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(PlantUmlParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PlantUmlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PlantUmlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(PlantUmlParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(PlantUmlParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void enterTimeUnit(PlantUmlParser.TimeUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void exitTimeUnit(PlantUmlParser.TimeUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(PlantUmlParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(PlantUmlParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PlantUmlParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PlantUmlParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PlantUmlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PlantUmlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PlantUmlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PlantUmlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SentFromExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSentFromExpr(PlantUmlParser.SentFromExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SentFromExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSentFromExpr(PlantUmlParser.SentFromExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JustAVariable}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJustAVariable(PlantUmlParser.JustAVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JustAVariable}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJustAVariable(PlantUmlParser.JustAVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondORExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCondORExpr(PlantUmlParser.CondORExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondORExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCondORExpr(PlantUmlParser.CondORExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMathOperation(PlantUmlParser.MathOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMathOperation(PlantUmlParser.MathOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompOperation(PlantUmlParser.CompOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompOperation(PlantUmlParser.CompOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(PlantUmlParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(PlantUmlParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(PlantUmlParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(PlantUmlParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JustAConstant}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJustAConstant(PlantUmlParser.JustAConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JustAConstant}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJustAConstant(PlantUmlParser.JustAConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PlantUmlParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PlantUmlParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 */
	void enterNoParamMeth(PlantUmlParser.NoParamMethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 */
	void exitNoParamMeth(PlantUmlParser.NoParamMethContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 */
	void enterParamMeth(PlantUmlParser.ParamMethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 */
	void exitParamMeth(PlantUmlParser.ParamMethContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantUmlParser#arrow}.
	 * @param ctx the parse tree
	 */
	void enterArrow(PlantUmlParser.ArrowContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantUmlParser#arrow}.
	 * @param ctx the parse tree
	 */
	void exitArrow(PlantUmlParser.ArrowContext ctx);
}