package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import Models.Types;
import Utils.InitializationUtils;
import javassist.*;

import java.util.Arrays;

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
        String methodName = ctx.typesWithVoid().getText();

    }

    @Override
    public void exitMethodBody(GenzParser.MethodBodyContext ctx) {
        super.exitMethodBody(ctx);
        isGlobalScope = true;
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
        boolean isForever = ctx.forever() != null;

        //final
        Types type = InitializationUtils.getTypeData(ctx.typesWithArray());


        //if not null, then there is an initialization
        if (valuesContext != null) {

            System.out.println(valuesContext.getText());
            System.out.println(valuesContext.values() + " asdass");

            String value = "";

            if (valuesContext.values() != null) {
                if (valuesContext.values().valuesWithoutArray() != null) {

                    //not an array
                    value = valuesContext.values().valuesWithoutArray().getText();

                } else {
                    String arrayString = valuesContext.values().arrayValues().getText();
                    System.out.println(arrayString);
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
                        InitializationUtils.createVariableGlobal(variableName, type.getDataType(), value, cc, isForever, type.isArray());
                    } catch (CannotCompileException e) {
                        System.out.println("Cannot compile global variable");
                        e.printStackTrace();
                    }
                } else {
                }
            }

        }

    }

}
