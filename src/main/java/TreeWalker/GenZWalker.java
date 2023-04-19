package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import Models.Types;
import Utils.InitializationUtils;
import javassist.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class GenZWalker extends GenzBaseListener {

    String className;
    String directory;
    ClassPool pool;
    CtClass cc;

    boolean isGlobalScope = false;

    String currentMethodCode = "";

    public GenZWalker(String className, String directory) {
        this.className = className;
        this.directory = directory;
        this.pool = ClassPool.getDefault();
        this.cc = pool.makeClass(className);
    }

    @Override
    public void enterCodeEntry(GenzParser.CodeEntryContext ctx) {
        super.enterCodeEntry(ctx);
        System.out.println("Starting compilation of " + className + "");
    }

    @Override
    public void exitCodeEntry(GenzParser.CodeEntryContext ctx) {
        super.exitCodeEntry(ctx);
        try {
            cc.writeFile(directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterGenz(GenzParser.GenzContext ctx) {
        super.enterGenz(ctx);
        currentMethodCode = "public static void main(String[] args) {";
    }

    @Override
    public void exitGenz(GenzParser.GenzContext ctx) {
        super.exitGenz(ctx);
        currentMethodCode += "}";
        try {
            CtMethod method = CtNewMethod.make(currentMethodCode, cc);
            cc.addMethod(method);
            currentMethodCode = "";
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterMethodBody(GenzParser.MethodBodyContext ctx) {
        super.enterMethodBody(ctx);

        isGlobalScope = false;
        String methodReturnType = ctx.typesWithVoid().getText();
        methodReturnType = InitializationUtils.getType(methodReturnType, true);

        String methodName = ctx.ID().getText();

        GenzParser.ParameterListContext parameterList = ctx.parameterList();

        LinkedHashMap<String, Types> variableTypeMap = new LinkedHashMap<>();

        if (parameterList != null) {

            if (parameterList.parameter() != null) {

                Types type = InitializationUtils.getParameterType(parameterList.parameter());
                String variableName = parameterList.parameter().ID().getText();

                variableTypeMap.put(variableName, type);

                GenzParser.ParameterListChoiceContext choiceContext = parameterList.parameterListChoice();
                while (choiceContext != null && choiceContext.parameter() != null) {
                    type = InitializationUtils.getParameterType(choiceContext.parameter());
                    variableName = choiceContext.parameter().ID().getText();

                    variableTypeMap.put(variableName, type);

                    choiceContext = choiceContext.parameterListChoice();
                }


            }

        }

        StringBuilder parameterString = new StringBuilder();
        for (String variableName : variableTypeMap.keySet()) {
            Types variableType = variableTypeMap.get(variableName);
            if (variableType.isArray()) {
                parameterString.append(variableType.getDataType()).append("[] ").append(variableName).append(", ");
            } else {
                parameterString.append(variableType.getDataType()).append(" ").append(variableName).append(", ");
            }
        }

        if (parameterString.length() > 0) {
            parameterString.delete(parameterString.length() - 2, parameterString.length());
        }

        currentMethodCode = "public static " + methodReturnType + " " + methodName + "(" + parameterString + ") {";

    }

    //method call, no assignment here.
    //methodCall


    @Override
    public void enterMethodCall(GenzParser.MethodCallContext ctx) {
        super.enterMethodCall(ctx);

        String methodName = ctx.ID().getText();
        StringBuilder methodCall = new StringBuilder(methodName + "(");

        GenzParser.ParameterCallListContext parameterList = ctx.parameterCallList();
        if (parameterList != null) {
            if (parameterList.expressionGrammar() != null) {
                ParseTreeWalker walker = new ParseTreeWalker();
                ExpressionWalker expressionWalker = new ExpressionWalker();
                walker.walk(expressionWalker, parameterList.expressionGrammar());
                methodCall.append(expressionWalker.getExpression());

                GenzParser.ParameterCallListChoiceContext choiceContext = parameterList.parameterCallListChoice();
                while (choiceContext != null && choiceContext.expressionGrammar() != null) {
                    walker = new ParseTreeWalker();
                    expressionWalker = new ExpressionWalker();
                    walker.walk(expressionWalker, choiceContext.expressionGrammar());
                    methodCall.append(", ").append(expressionWalker.getExpression());
                    choiceContext = choiceContext.parameterCallListChoice();
                }

            }
        }

        methodCall.append(");");
        currentMethodCode += methodCall.toString();

    }

    @Override
    public void exitMethodBody(GenzParser.MethodBodyContext ctx) {
        super.exitMethodBody(ctx);
        isGlobalScope = true;
        currentMethodCode += "}";
        try {
            System.out.println(currentMethodCode);
            CtMethod method = CtNewMethod.make(currentMethodCode, cc);
            cc.addMethod(method);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterReturnStatement(GenzParser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx);
        String returnStatement = "return ";
        if (ctx.returnValue() != null) {

            if (ctx.returnValue().expressionGrammar() != null) {
                ParseTreeWalker walker = new ParseTreeWalker();
                ExpressionWalker expressionWalker = new ExpressionWalker();
                walker.walk(expressionWalker, ctx.returnValue().expressionGrammar());
                returnStatement += expressionWalker.getExpression();
            } else if (ctx.returnValue().conditionalStatementEntry() != null) {
                ParseTreeWalker walker = new ParseTreeWalker();
                ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
                walker.walk(conditionalStatementWalker, ctx.returnValue().conditionalStatementEntry());
                returnStatement += conditionalStatementWalker.getConditionalStatement();
            }
        }
        returnStatement += ";";
        currentMethodCode += returnStatement;
    }

    @Override
    public void enterGlobalStatements(GenzParser.GlobalStatementsContext ctx) {
        super.enterGlobalStatements(ctx);
        isGlobalScope = true;
    }

    @Override
    public void exitGlobalStatements(GenzParser.GlobalStatementsContext ctx) {
        super.exitGlobalStatements(ctx);
        isGlobalScope = false;
    }

    @Override
    public void enterVariableDeclaration(GenzParser.VariableDeclarationContext ctx) {
        super.enterVariableDeclaration(ctx);

        GenzParser.VariableDeclarationSelectionContext variableDeclarationSelectionContext = ctx.variableDeclarationSelection();

        //variable name
        String variableName = variableDeclarationSelectionContext.ID().getText();
        GenzParser.InitializationOfVariableContext valuesContext =
                variableDeclarationSelectionContext
                        .initializationOfVariable();

        //if final
        boolean isForever = ctx.forever() != null && ctx.forever().FOREVER() != null;

        //final
        Types type = InitializationUtils.getTypeData(ctx.typesWithArray());


        //if not null, then there is an initialization
        if (valuesContext != null) {

            String value = "";

            if (valuesContext.values() != null) {
                if (valuesContext.values().valuesWithoutArray() != null) {

                    //not an array
                    value = valuesContext.values().valuesWithoutArray().getText();
                    //if boolean
                    if (type.getDataType().equals("boolean")) {
                        if (value.equals("fax")) {
                            value = "true";
                        } else if (value.equals("cap")) {
                            value = "false";
                        } else {
                            throw new RuntimeException("Invalid value for boolean");
                        }
                    }

                } else {
                    String arrayString = valuesContext.values().arrayValues().getText();
                    if (arrayString.contains("fax") || arrayString.contains("cap")) {

                        if (!type.getDataType().equals("boolean")) {
                            throw new RuntimeException("Cannot initialize array with boolean values");
                        }

                        arrayString = arrayString.replace("{", "");
                        arrayString = arrayString.replace("}", "");
                        String[] arrayValues = arrayString.split(",");
                        for (int i = 0; i < arrayValues.length; i++) {
                            if (arrayValues[i].equals("fax")) {
                                arrayValues[i] = "true";
                            } else if (arrayValues[i].equals("cap")) {
                                arrayValues[i] = "false";
                            } else {
                                throw new RuntimeException("Invalid value in boolean array");
                            }
                        }
                        value = Arrays.toString(arrayValues);
                        value = value.replace("[", "{");
                        value = value.replace("]", "}");
                        value = value.replace("\"", "");
                    } else {
                        value = arrayString;
                    }
                    value = "new " + type.getDataType() + "[] " + value;
                }
                //new <Type>[]

                if (isGlobalScope) {
                    //String variableName, String variableType, String variableValue, CtClass cc
                    try {
                        InitializationUtils.createVariableGlobal(variableName, value, cc, isForever, type);
                        return;
                    } catch (CannotCompileException e) {
                        System.out.println("Cannot compile global variable");
                        e.printStackTrace();
                    }
                } else {
                    currentMethodCode += InitializationUtils.createVariableLocal(variableName, value, cc, isForever, type);
                    return;
                }
            }
        }

        if (isGlobalScope) {
            //String variableName, String variableType, String variableValue, CtClass cc
            try {
                InitializationUtils.createVariableGlobal(variableName, null, cc, isForever, type);
            } catch (CannotCompileException e) {
                System.out.println("Cannot compile global variable");
                e.printStackTrace();
            }
        } else {
            currentMethodCode += InitializationUtils.createVariableLocal(variableName, null, cc, isForever, type);
        }

    }

    @Override
    public void enterOutputStmt(GenzParser.OutputStmtContext ctx) {
        super.enterOutputStmt(ctx);

        currentMethodCode += "System.out.println(";
        if (ctx.outputChoices().expressionGrammar() != null) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ExpressionWalker expressionWalker = new ExpressionWalker();
            walker.walk(expressionWalker, ctx.outputChoices().expressionGrammar());
            currentMethodCode += expressionWalker.getExpression();
        } else if (ctx.outputChoices().conditionalStatement() != null) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
            walker.walk(conditionalStatementWalker, ctx.outputChoices().conditionalStatement());
            currentMethodCode += conditionalStatementWalker.getConditionalStatement();
        }

        currentMethodCode += ");";

    }

    @Override
    public void enterVariableAssignment(GenzParser.VariableAssignmentContext ctx) {
        super.enterVariableAssignment(ctx);

        String variableName = ctx.ID().getText();

        GenzParser.VariableAssignmentInnerContext variableAssignmentInnerContext = ctx.variableAssignmentInner();

        String value = null;

        if (variableAssignmentInnerContext.expressionGrammar() != null) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ExpressionWalker expressionGrammarWalker = new ExpressionWalker();
            walker.walk(expressionGrammarWalker, variableAssignmentInnerContext.expressionGrammar());
            value = expressionGrammarWalker.getExpression();

        } else if (variableAssignmentInnerContext.conditionalStatementEntry() != null) {
            System.out.println(variableAssignmentInnerContext.conditionalStatementEntry().getText());
            ParseTreeWalker walker = new ParseTreeWalker();
            ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
            walker.walk(conditionalStatementWalker, variableAssignmentInnerContext.conditionalStatementEntry());
            value = conditionalStatementWalker.getConditionalStatement();
        }

        if (value != null) {
            currentMethodCode += variableName + " = " + value + ";";
        }
    }

    @Override
    public void enterArrayAssignment(GenzParser.ArrayAssignmentContext ctx) {
        super.enterArrayAssignment(ctx);

        String arrayName = ctx.ID().getText();
        String index = ctx.integerIDChoice().getText();

        String array = arrayName + "[" + index + "]";
        String value = null;

        if (ctx.variableAssignmentInner().expressionGrammar() != null) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ExpressionWalker expressionGrammarWalker = new ExpressionWalker();
            walker.walk(expressionGrammarWalker, ctx.variableAssignmentInner().expressionGrammar());
            value = expressionGrammarWalker.getExpression();
        } else if (ctx.variableAssignmentInner().conditionalStatementEntry() != null) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
            walker.walk(conditionalStatementWalker, ctx.variableAssignmentInner().conditionalStatementEntry());
            value = conditionalStatementWalker.getConditionalStatement();
        }

        if (value != null) {
            currentMethodCode += array + " = " + value + ";";
        }


    }

    //conditionalStatementEntry
    @Override
    public void enterIsThisBlock(GenzParser.IsThisBlockContext ctx) {
        super.enterIsThisBlock(ctx);
        ParseTreeWalker walker = new ParseTreeWalker();
        ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
        walker.walk(conditionalStatementWalker, ctx.conditionalStatementEntry());
        currentMethodCode += "if (" + conditionalStatementWalker.getConditionalStatement() + ") {";
    }

    @Override
    public void exitIsThisBlock(GenzParser.IsThisBlockContext ctx) {
        super.exitIsThisBlock(ctx);
        currentMethodCode += "}";
    }

    @Override
    public void enterOrIsThisBlock(GenzParser.OrIsThisBlockContext ctx) {
        super.enterOrIsThisBlock(ctx);
        ParseTreeWalker walker = new ParseTreeWalker();
        ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
        walker.walk(conditionalStatementWalker, ctx.conditionalStatementEntry());
        currentMethodCode += "else if (" + conditionalStatementWalker.getConditionalStatement() + ") {";
    }

    @Override
    public void exitOrIsThisBlock(GenzParser.OrIsThisBlockContext ctx) {
        super.exitOrIsThisBlock(ctx);
        currentMethodCode += "}";
    }

    @Override
    public void enterMehBlock(GenzParser.MehBlockContext ctx) {
        super.enterMehBlock(ctx);
        currentMethodCode += "else {";
    }

    @Override
    public void exitMehBlock(GenzParser.MehBlockContext ctx) {
        super.exitMehBlock(ctx);
        currentMethodCode += "}";
    }

    //loops
    //for loop
    @Override
    public void enterForLoop(GenzParser.ForLoopContext ctx) {
        super.enterForLoop(ctx);

        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionWalker expressionWalker = new ExpressionWalker();
        walker.walk(expressionWalker, ctx.expressionGrammar(0));
        String expressionOne = expressionWalker.getExpression();

        walker = new ParseTreeWalker();
        expressionWalker = new ExpressionWalker();
        walker.walk(expressionWalker, ctx.expressionGrammar(1));
        String expressionTwo = expressionWalker.getExpression();

        String variableName = ctx.loopVairable().ID().getText();

        if (ctx.forLoopDirection() != null && ctx.forLoopDirection().CHEUGY() != null) {
            currentMethodCode += "for(int " + variableName + " = " + expressionTwo + "; " + variableName + " >= " + expressionOne + "; " + variableName + "--){";
        } else {
            currentMethodCode += "for(int " + variableName + " = " + expressionOne + "; " + variableName + " <= " + expressionTwo + "; " + variableName + "++){";
        }


    }

    @Override
    public void exitForLoop(GenzParser.ForLoopContext ctx) {
        super.exitForLoop(ctx);
        currentMethodCode += "}";
    }

    @Override
    public void enterWhileLoop(GenzParser.WhileLoopContext ctx) {
        super.enterWhileLoop(ctx);

        ParseTreeWalker walker = new ParseTreeWalker();
        ConditionalStatementWalker conditionalStatementWalker = new ConditionalStatementWalker();
        walker.walk(conditionalStatementWalker, ctx.conditionalStatement());
        currentMethodCode += "while (" + conditionalStatementWalker.getConditionalStatement() + ") {";

    }

    @Override
    public void exitWhileLoop(GenzParser.WhileLoopContext ctx) {
        super.exitWhileLoop(ctx);
        currentMethodCode += "}";
    }

    @Override
    public void enterYeetStatement(GenzParser.YeetStatementContext ctx) {
        super.enterYeetStatement(ctx);
        currentMethodCode += "break;";
    }
}
