package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExpressionWalker extends GenzBaseListener {

    String expression = "";
    ExpressionCallback callback;

    public ExpressionWalker() {
    }

    public ExpressionWalker(ExpressionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.getChildCount() == 0) {
            System.out.println("EVERY RULE: " + ctx.getText() + " " + ctx.getChildCount());
            if (callback != null) callback.onExpression(expression);
            expression = "";
        }
    }


    @Override
    public void enterAdd(GenzParser.AddContext ctx) {
        super.enterAdd(ctx);
        expression += " + ";
    }

    @Override
    public void enterSub(GenzParser.SubContext ctx) {
        super.enterSub(ctx);
        expression += " - ";
    }

    @Override
    public void enterMul(GenzParser.MulContext ctx) {
        super.enterMul(ctx);
        expression += " * ";
    }

    @Override
    public void enterDiv(GenzParser.DivContext ctx) {
        super.enterDiv(ctx);
        expression += " / ";
    }

    @Override
    public void enterMod(GenzParser.ModContext ctx) {
        super.enterMod(ctx);
        expression += " % ";
    }

    @Override
    public void enterValuesWithoutArray(GenzParser.ValuesWithoutArrayContext ctx) {
        super.enterValuesWithoutArray(ctx);
        expression += ctx.getText();
    }

    @Override
    public void enterLp(GenzParser.LpContext ctx) {
        super.enterLp(ctx);
        expression += "(";
    }

    @Override
    public void enterRp(GenzParser.RpContext ctx) {
        super.enterRp(ctx);
        expression += ")";
    }

    @Override
    public void enterGetExpressionID(GenzParser.GetExpressionIDContext ctx) {
        super.enterGetExpressionID(ctx);
        expression += ctx.getText();
    }

    @Override
    public void enterArrayIndexing(GenzParser.ArrayIndexingContext ctx) {
        super.enterArrayIndexing(ctx);

        String ID = ctx.ID().getText();
        String index = ctx.integerIDChoice().getText();

        expression += " " + ID + "[" + index + "] ";

    }

    @Override
    public void enterMethodCall(GenzParser.MethodCallContext ctx) {
        super.enterMethodCall(ctx);

        String ID = ctx.ID().getText();
        expression += ID + "(";

    }

    @Override
    public void exitMethodCall(GenzParser.MethodCallContext ctx) {
        super.enterMethodCall(ctx);
        expression += ") ";
    }

    @Override
    public void enterCommaBlock(GenzParser.CommaBlockContext ctx) {
        super.enterCommaBlock(ctx);
        expression += ", ";
    }
}
