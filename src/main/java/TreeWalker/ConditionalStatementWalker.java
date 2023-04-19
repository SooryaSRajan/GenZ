package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;

public class ConditionalStatementWalker extends GenzBaseListener {

    String conditionalStatement = "";

    public ConditionalStatementWalker() {
    }

    public String getConditionalStatement() {
        return conditionalStatement;
    }

    @Override
    public void enterNotOperand(GenzParser.NotOperandContext ctx) {
        super.enterNotOperand(ctx);
        conditionalStatement += " ! ";
    }

    @Override
    public void enterBinaryOperands(GenzParser.BinaryOperandsContext ctx) {
        super.enterBinaryOperands(ctx);
        conditionalStatement += " " + ctx.getText() + " ";
    }

    @Override
    public void enterConditionalOperations(GenzParser.ConditionalOperationsContext ctx) {
        super.enterConditionalOperations(ctx);

        String operator = ctx.getText();
        if(operator.equals("=")){
            operator = " == ";
        }
        else if(operator.equals("<>")){
            operator = " != ";
        }

        conditionalStatement += " " + operator + " ";
    }

    @Override
    public void enterAdd(GenzParser.AddContext ctx) {
        super.enterAdd(ctx);
        conditionalStatement += " + ";
    }

    @Override
    public void enterSub(GenzParser.SubContext ctx) {
        super.enterSub(ctx);
        conditionalStatement += " - ";
    }

    @Override
    public void enterMul(GenzParser.MulContext ctx) {
        super.enterMul(ctx);
        conditionalStatement += " * ";
    }

    @Override
    public void enterDiv(GenzParser.DivContext ctx) {
        super.enterDiv(ctx);
        conditionalStatement += " / ";
    }

    @Override
    public void enterMod(GenzParser.ModContext ctx) {
        super.enterMod(ctx);
        conditionalStatement += " % ";
    }

    @Override
    public void enterValuesWithoutArray(GenzParser.ValuesWithoutArrayContext ctx) {
        super.enterValuesWithoutArray(ctx);
        conditionalStatement += ctx.getText();
    }

    @Override
    public void enterLp(GenzParser.LpContext ctx) {
        super.enterLp(ctx);
        conditionalStatement += "(";
    }

    @Override
    public void enterRp(GenzParser.RpContext ctx) {
        super.enterRp(ctx);
        conditionalStatement += ")";
    }

    @Override
    public void enterGetExpressionID(GenzParser.GetExpressionIDContext ctx) {
        super.enterGetExpressionID(ctx);
        conditionalStatement += ctx.getText();
    }

    @Override
    public void enterArrayIndexing(GenzParser.ArrayIndexingContext ctx) {
        super.enterArrayIndexing(ctx);

        String ID = ctx.ID().getText();
        String index = ctx.integerIDChoice().getText();

        conditionalStatement += " " + ID + "[" + index + "] ";

    }

    @Override
    public void enterMethodCall(GenzParser.MethodCallContext ctx) {
        super.enterMethodCall(ctx);

        String ID = ctx.ID().getText();
        conditionalStatement += ID + "(";

    }

    @Override
    public void exitMethodCall(GenzParser.MethodCallContext ctx) {
        super.enterMethodCall(ctx);
        conditionalStatement += ") ";
    }

    @Override
    public void enterCommaBlock(GenzParser.CommaBlockContext ctx) {
        super.enterCommaBlock(ctx);
        conditionalStatement += ", ";
    }

}
