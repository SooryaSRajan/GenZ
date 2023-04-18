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

    //TODO: Parse condition blocks, for loops, expressions -> includes array call and function call, conditional statements, input and output.


    @Override
    public void enterExpr(GenzParser.ExprContext ctx) {
        super.enterExpr(ctx);
        //TODO: Parse expression using walker in blocks where expressions is used.
        ExpressionWalker expressionWalker = new ExpressionWalker(expression -> {
            System.out.println("Expression: " + expression);
        });
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(expressionWalker, ctx);
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
        //append public static void main(String[] args) { to currentMethodCode
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

        //methodBody: BOOTYCALL FOR typesWithVoid BY ID BRACKET_OPEN parameterList BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;

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

}
