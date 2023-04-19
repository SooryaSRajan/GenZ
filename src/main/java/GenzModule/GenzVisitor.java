// Generated from java-escape by ANTLR 4.11.1
package GenzModule;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GenzParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GenzVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GenzParser#codeEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeEntry(GenzParser.CodeEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#genz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenz(GenzParser.GenzContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#statementRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementRecursive(GenzParser.StatementRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GenzParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#yeetStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYeetStatement(GenzParser.YeetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#globalStatementsRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatementsRecursive(GenzParser.GlobalStatementsRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#globalStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatements(GenzParser.GlobalStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(GenzParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#valuesWithoutArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesWithoutArray(GenzParser.ValuesWithoutArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arrayValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValues(GenzParser.ArrayValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arrayValuesRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValuesRecursive(GenzParser.ArrayValuesRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(GenzParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#variableDeclarationSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationSelection(GenzParser.VariableDeclarationSelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#initializationOfVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializationOfVariable(GenzParser.InitializationOfVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#forever}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForever(GenzParser.ForeverContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#typesWithArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesWithArray(GenzParser.TypesWithArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arrayChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayChoice(GenzParser.ArrayChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arraySize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySize(GenzParser.ArraySizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(GenzParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arrayIndexing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndexing(GenzParser.ArrayIndexingContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#getArraySize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetArraySize(GenzParser.GetArraySizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#integerIDChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerIDChoice(GenzParser.IntegerIDChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(GenzParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#variableAssignmentInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignmentInner(GenzParser.VariableAssignmentInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(GenzParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(GenzParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#parameterListChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListChoice(GenzParser.ParameterListChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(GenzParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(GenzParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#typesWithVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesWithVoid(GenzParser.TypesWithVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(GenzParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#forLoopDirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopDirection(GenzParser.ForLoopDirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#loopVairable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopVairable(GenzParser.LoopVairableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(GenzParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#outputStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStmt(GenzParser.OutputStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#outputChoices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputChoices(GenzParser.OutputChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#inputStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStmt(GenzParser.InputStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#inputForArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputForArray(GenzParser.InputForArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#expressionGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGrammar(GenzParser.ExpressionGrammarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GenzParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#expressionInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInner(GenzParser.ExpressionInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(GenzParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermMultDivFactor(GenzParser.TermMultDivFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(GenzParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#getExpressionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetExpressionID(GenzParser.GetExpressionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#ifElseIfElseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseIfElseBlock(GenzParser.IfElseIfElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#elseIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfBlock(GenzParser.ElseIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#isThisBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsThisBlock(GenzParser.IsThisBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#orIsThisBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrIsThisBlock(GenzParser.OrIsThisBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#mehBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMehBlock(GenzParser.MehBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(GenzParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#parameterCallList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterCallList(GenzParser.ParameterCallListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#parameterCallListChoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterCallListChoice(GenzParser.ParameterCallListChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#commaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaBlock(GenzParser.CommaBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(GenzParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#returnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(GenzParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#conditionalStatementEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatementEntry(GenzParser.ConditionalStatementEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(GenzParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#binaryOperands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperands(GenzParser.BinaryOperandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#notOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOperand(GenzParser.NotOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#conditionalOperations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOperations(GenzParser.ConditionalOperationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#lp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLp(GenzParser.LpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp(GenzParser.RpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(GenzParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(GenzParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(GenzParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(GenzParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link GenzParser#mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(GenzParser.ModContext ctx);
}