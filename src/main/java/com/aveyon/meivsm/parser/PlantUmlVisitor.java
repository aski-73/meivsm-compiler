// Generated from PlantUml.g4 by ANTLR 4.7.2
package com.aveyon.meivsm.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PlantUmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PlantUmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#skinParamCmds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkinParamCmds(PlantUmlParser.SkinParamCmdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#plantUml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlantUml(PlantUmlParser.PlantUmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(PlantUmlParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#stateDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDef(PlantUmlParser.StateDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldDeclrAndExprAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclrAndExprAssignment(PlantUmlParser.FieldDeclrAndExprAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldDeclrAndAssignment}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclrAndAssignment(PlantUmlParser.FieldDeclrAndAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link PlantUmlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(PlantUmlParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Trans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrans(PlantUmlParser.TransContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransCond(PlantUmlParser.TransCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransPay}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransPay(PlantUmlParser.TransPayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransPayCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransPayCond(PlantUmlParser.TransPayCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransPayStar}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransPayStar(PlantUmlParser.TransPayStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransPayStarCond}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransPayStarCond(PlantUmlParser.TransPayStarCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyTrans}
	 * labeled alternative in {@link PlantUmlParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyTrans(PlantUmlParser.EmptyTransContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PlantUmlParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#compOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOperator(PlantUmlParser.CompOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#mathOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathOperator(PlantUmlParser.MathOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PlantUmlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(PlantUmlParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#timeUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeUnit(PlantUmlParser.TimeUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PlantUmlParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PlantUmlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PlantUmlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentFromExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentFromExpr(PlantUmlParser.SentFromExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JustAVariable}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustAVariable(PlantUmlParser.JustAVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondORExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondORExpr(PlantUmlParser.CondORExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathOperation(PlantUmlParser.MathOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompOperation}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOperation(PlantUmlParser.CompOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCall}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(PlantUmlParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(PlantUmlParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JustAConstant}
	 * labeled alternative in {@link PlantUmlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustAConstant(PlantUmlParser.JustAConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PlantUmlParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoParamMeth(PlantUmlParser.NoParamMethContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamMeth}
	 * labeled alternative in {@link PlantUmlParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamMeth(PlantUmlParser.ParamMethContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlantUmlParser#arrow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrow(PlantUmlParser.ArrowContext ctx);
}