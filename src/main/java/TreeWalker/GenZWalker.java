package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.util.Arrays;

public class GenZWalker extends GenzBaseListener {

    String className;
    String directory;
    ClassPool pool;
    CtClass cc;

    boolean isGlobalScope = false;

    CtMethod currentMethod = null;
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
        //create
    }

    @Override
    public void exitCodeEntry(GenzParser.CodeEntryContext ctx) {
        super.exitCodeEntry(ctx);
        //write file
        try {
            cc.writeFile(directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterGenz(GenzParser.GenzContext ctx) {
        super.enterGenz(ctx);
    }

    @Override
    public void exitGenz(GenzParser.GenzContext ctx) {
        super.exitGenz(ctx);
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

        String variableName = variableDeclarationSelectionContext.ID().getText();
        GenzParser.InitializationOfVariableContext valuesContext =
                variableDeclarationSelectionContext
                        .initializationOfVariable();

        String type = ctx.typesWithArray().types().getText();
        boolean isArray = ctx.typesWithArray().arrayChoice() != null;
        int arraySize = -1;
        if (isArray) {
            GenzParser.ArraySizeContext arraySizeContext = ctx.typesWithArray().arrayChoice().arraySize();
            if (arraySizeContext != null) {
                GenzParser.IntegerIDChoiceContext arraySizeString = arraySizeContext.integerIDChoice();
                if (arraySizeString != null) {
                    arraySize = Integer.parseInt(arraySizeString.getText());
                } else {
                    arraySize = 0;
                }
            }
        }

        type = switch (type) {
            case "string" -> "java/lang/String";
            case "integer" -> "I";
            case "float" -> "F";
            case "double" -> "D";
            case "character" -> "C";
            case "boolean" -> "Z";
            default -> type;
        };

        //if not null, then there is an initialization
        if (valuesContext != null) {

            System.out.println(valuesContext.getText());
            System.out.println(valuesContext.values() + " asdass");

            if (valuesContext.values() != null) {
                if (valuesContext.values().valuesWithoutArray() != null) {
                    String value = valuesContext.values().valuesWithoutArray().getText();

                    //parse value accordingly and
                    Object parsedValue = switch (type) {
                        case "java/lang/String" -> value;
                        case "I" -> Integer.parseInt(value);
                        case "F" -> Float.parseFloat(value);
                        case "D" -> Double.parseDouble(value);
                        case "C" -> value.charAt(0);
                        case "Z" -> Boolean.parseBoolean(value);
                        default -> null;
                    };

                    //create variable with value
                    if (isGlobalScope) {
                    } else {
                    }


                } else {
                    //TODO: Initialize array
                    System.out.println("ARRAY");
                    String arrayString = valuesContext.values().arrayValues().getText();
                    //remove brackets and split by comma and parse accordingly
                    String[] arrayValues = arrayString.substring(1, arrayString.length() - 1).split(",");
                    System.out.println(Arrays.toString(arrayValues));
                    //create array
                    if (isGlobalScope) {

                    } else {

                    }

                }
            }

        }

    }

}
