package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ConditionalStatementWalker extends GenzBaseListener {

    String conditionalStatement = "";
    ConditionStatementCallback callback;

    public ConditionalStatementWalker() {
    }

    public ConditionalStatementWalker(ConditionStatementCallback callback) {
        this.callback = callback;
    }

    @Override
    public void exitConditionalStatementEntry(GenzParser.ConditionalStatementEntryContext ctx) {
        super.exitConditionalStatementEntry(ctx);
        System.out.println("Conditional Statement: " + conditionalStatement);
        if (callback != null) callback.onConditionStatement(conditionalStatement);
        conditionalStatement = "";
    }

    @Override
    public void enterLp(GenzParser.LpContext ctx) {
        super.enterLp(ctx);
        conditionalStatement += "( ";
    }

    @Override
    public void enterRp(GenzParser.RpContext ctx) {
        super.enterRp(ctx);
        conditionalStatement += " )";
    }

    @Override
    public void enterNotOperand(GenzParser.NotOperandContext ctx) {
        super.enterNotOperand(ctx);
        conditionalStatement += " !";
    }

    @Override
    public void enterBinaryOperands(GenzParser.BinaryOperandsContext ctx) {
        super.enterBinaryOperands(ctx);
        conditionalStatement += " " + ctx.getText() + " ";
    }

    @Override
    public void enterConditionalOperations(GenzParser.ConditionalOperationsContext ctx) {
        super.enterConditionalOperations(ctx);
        conditionalStatement += " " + ctx.getText() + " ";
    }

    @Override
    public void enterExpressionGrammar(GenzParser.ExpressionGrammarContext ctx) {
        super.enterExpressionGrammar(ctx);
        ParseTreeWalker walker = new ParseTreeWalker();
        System.out.println("Expression main: " + ctx.getText());
        ExpressionWalker expressionWalker = new ExpressionWalker((expression) -> {
            conditionalStatement += expression;
            System.out.println("Expression: " + expression);
        });
        walker.walk(expressionWalker, ctx);
    }

}
