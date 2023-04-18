// Generated from java-escape by ANTLR 4.11.1
package GenzModule;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GenzParser}.
 */
public interface GenzListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GenzParser#codeEntry}.
	 * @param ctx the parse tree
	 */
	void enterCodeEntry(GenzParser.CodeEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#codeEntry}.
	 * @param ctx the parse tree
	 */
	void exitCodeEntry(GenzParser.CodeEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#genz}.
	 * @param ctx the parse tree
	 */
	void enterGenz(GenzParser.GenzContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#genz}.
	 * @param ctx the parse tree
	 */
	void exitGenz(GenzParser.GenzContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#statementRecursive}.
	 * @param ctx the parse tree
	 */
	void enterStatementRecursive(GenzParser.StatementRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#statementRecursive}.
	 * @param ctx the parse tree
	 */
	void exitStatementRecursive(GenzParser.StatementRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GenzParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GenzParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#globalStatementsRecursive}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatementsRecursive(GenzParser.GlobalStatementsRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#globalStatementsRecursive}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatementsRecursive(GenzParser.GlobalStatementsRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#globalStatements}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatements(GenzParser.GlobalStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#globalStatements}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatements(GenzParser.GlobalStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(GenzParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(GenzParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#valuesWithoutArray}.
	 * @param ctx the parse tree
	 */
	void enterValuesWithoutArray(GenzParser.ValuesWithoutArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#valuesWithoutArray}.
	 * @param ctx the parse tree
	 */
	void exitValuesWithoutArray(GenzParser.ValuesWithoutArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#arrayValues}.
	 * @param ctx the parse tree
	 */
	void enterArrayValues(GenzParser.ArrayValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#arrayValues}.
	 * @param ctx the parse tree
	 */
	void exitArrayValues(GenzParser.ArrayValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#arrayValuesRecursive}.
	 * @param ctx the parse tree
	 */
	void enterArrayValuesRecursive(GenzParser.ArrayValuesRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#arrayValuesRecursive}.
	 * @param ctx the parse tree
	 */
	void exitArrayValuesRecursive(GenzParser.ArrayValuesRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(GenzParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(GenzParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#variableDeclarationSelection}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationSelection(GenzParser.VariableDeclarationSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#variableDeclarationSelection}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationSelection(GenzParser.VariableDeclarationSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#initializationOfVariable}.
	 * @param ctx the parse tree
	 */
	void enterInitializationOfVariable(GenzParser.InitializationOfVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#initializationOfVariable}.
	 * @param ctx the parse tree
	 */
	void exitInitializationOfVariable(GenzParser.InitializationOfVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#forever}.
	 * @param ctx the parse tree
	 */
	void enterForever(GenzParser.ForeverContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#forever}.
	 * @param ctx the parse tree
	 */
	void exitForever(GenzParser.ForeverContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#typesWithArray}.
	 * @param ctx the parse tree
	 */
	void enterTypesWithArray(GenzParser.TypesWithArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#typesWithArray}.
	 * @param ctx the parse tree
	 */
	void exitTypesWithArray(GenzParser.TypesWithArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#arrayChoice}.
	 * @param ctx the parse tree
	 */
	void enterArrayChoice(GenzParser.ArrayChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#arrayChoice}.
	 * @param ctx the parse tree
	 */
	void exitArrayChoice(GenzParser.ArrayChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#arraySize}.
	 * @param ctx the parse tree
	 */
	void enterArraySize(GenzParser.ArraySizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#arraySize}.
	 * @param ctx the parse tree
	 */
	void exitArraySize(GenzParser.ArraySizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(GenzParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(GenzParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexing(GenzParser.ArrayIndexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexing(GenzParser.ArrayIndexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#integerIDChoice}.
	 * @param ctx the parse tree
	 */
	void enterIntegerIDChoice(GenzParser.IntegerIDChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#integerIDChoice}.
	 * @param ctx the parse tree
	 */
	void exitIntegerIDChoice(GenzParser.IntegerIDChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(GenzParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(GenzParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#variableAssignmentInner}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignmentInner(GenzParser.VariableAssignmentInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#variableAssignmentInner}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignmentInner(GenzParser.VariableAssignmentInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(GenzParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(GenzParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#parameterListChoice}.
	 * @param ctx the parse tree
	 */
	void enterParameterListChoice(GenzParser.ParameterListChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#parameterListChoice}.
	 * @param ctx the parse tree
	 */
	void exitParameterListChoice(GenzParser.ParameterListChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(GenzParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(GenzParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(GenzParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(GenzParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#typesWithVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypesWithVoid(GenzParser.TypesWithVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#typesWithVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypesWithVoid(GenzParser.TypesWithVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(GenzParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(GenzParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#loopVairable}.
	 * @param ctx the parse tree
	 */
	void enterLoopVairable(GenzParser.LoopVairableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#loopVairable}.
	 * @param ctx the parse tree
	 */
	void exitLoopVairable(GenzParser.LoopVairableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void enterOutputStmt(GenzParser.OutputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void exitOutputStmt(GenzParser.OutputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void enterInputStmt(GenzParser.InputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void exitInputStmt(GenzParser.InputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GenzParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GenzParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#expressionInner}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInner(GenzParser.ExpressionInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#expressionInner}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInner(GenzParser.ExpressionInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GenzParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GenzParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 */
	void enterTermMultDivFactor(GenzParser.TermMultDivFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#termMultDivFactor}.
	 * @param ctx the parse tree
	 */
	void exitTermMultDivFactor(GenzParser.TermMultDivFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GenzParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GenzParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#isThisBlock}.
	 * @param ctx the parse tree
	 */
	void enterIsThisBlock(GenzParser.IsThisBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#isThisBlock}.
	 * @param ctx the parse tree
	 */
	void exitIsThisBlock(GenzParser.IsThisBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#orIsThisMehBlock}.
	 * @param ctx the parse tree
	 */
	void enterOrIsThisMehBlock(GenzParser.OrIsThisMehBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#orIsThisMehBlock}.
	 * @param ctx the parse tree
	 */
	void exitOrIsThisMehBlock(GenzParser.OrIsThisMehBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#orIsThisBlock}.
	 * @param ctx the parse tree
	 */
	void enterOrIsThisBlock(GenzParser.OrIsThisBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#orIsThisBlock}.
	 * @param ctx the parse tree
	 */
	void exitOrIsThisBlock(GenzParser.OrIsThisBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#mehBlock}.
	 * @param ctx the parse tree
	 */
	void enterMehBlock(GenzParser.MehBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#mehBlock}.
	 * @param ctx the parse tree
	 */
	void exitMehBlock(GenzParser.MehBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(GenzParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(GenzParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#parameterCallList}.
	 * @param ctx the parse tree
	 */
	void enterParameterCallList(GenzParser.ParameterCallListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#parameterCallList}.
	 * @param ctx the parse tree
	 */
	void exitParameterCallList(GenzParser.ParameterCallListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#parameterCallListChoice}.
	 * @param ctx the parse tree
	 */
	void enterParameterCallListChoice(GenzParser.ParameterCallListChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#parameterCallListChoice}.
	 * @param ctx the parse tree
	 */
	void exitParameterCallListChoice(GenzParser.ParameterCallListChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(GenzParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(GenzParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#conditionBooleans}.
	 * @param ctx the parse tree
	 */
	void enterConditionBooleans(GenzParser.ConditionBooleansContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#conditionBooleans}.
	 * @param ctx the parse tree
	 */
	void exitConditionBooleans(GenzParser.ConditionBooleansContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(GenzParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(GenzParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#conditionalChoice}.
	 * @param ctx the parse tree
	 */
	void enterConditionalChoice(GenzParser.ConditionalChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#conditionalChoice}.
	 * @param ctx the parse tree
	 */
	void exitConditionalChoice(GenzParser.ConditionalChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#conditionalOperations}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOperations(GenzParser.ConditionalOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#conditionalOperations}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOperations(GenzParser.ConditionalOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#lp}.
	 * @param ctx the parse tree
	 */
	void enterLp(GenzParser.LpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#lp}.
	 * @param ctx the parse tree
	 */
	void exitLp(GenzParser.LpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(GenzParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(GenzParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(GenzParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(GenzParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(GenzParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(GenzParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(GenzParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(GenzParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenzParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(GenzParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenzParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(GenzParser.DivContext ctx);
}