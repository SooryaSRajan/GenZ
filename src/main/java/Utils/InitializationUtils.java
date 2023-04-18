package Utils;

import GenzModule.GenzParser;
import Models.Types;
import javassist.*;

public class InitializationUtils {

    public static String getType(String type, boolean isTypeJavaObject) {

        if (!isTypeJavaObject) {
            type = switch (type) {
                case "string" -> "java/lang/String";
                case "integer" -> "I";
                case "float" -> "F";
                case "double" -> "D";
                case "character" -> "C";
                case "boolean" -> "Z";
                case "sus" -> "V";
                default -> type;
            };
        }
        else{
            type = switch (type) {
                case "string" -> "String";
                case "integer" -> "int";
                case "float" -> "float";
                case "double" -> "double";
                case "character" -> "char";
                case "boolean" -> "boolean";
                case "sus" -> "Void";
                default -> type;
            };

        }

        return type;
    }

    public static Types getTypeData(GenzParser.TypesWithArrayContext ctx){

        Types type = new Types();
        String baseType = getType(ctx.types().getText(), true);
        type.setDataType(baseType);
        boolean isHighKeyType = ctx.arrayChoice() != null && ctx.arrayChoice().HIGHKEY() != null;

        if(isHighKeyType){
            if(ctx.arrayChoice().arraySize() != null && ctx.arrayChoice().arraySize().integerIDChoice() != null){
                type.setArray(true);
                type.setArraySize(Integer.parseInt(ctx.arrayChoice().arraySize().integerIDChoice().getText()));
            }
            else{
                type.setArray(true);
                type.setArraySize(0);
            }

        }
        else{
            type.setArray(false);
            type.setArraySize(0);
        }

        return type;

    }

    //Array declaration
    public static void createArrayPreInitializedGlobal(String arrayName, String arrayType, String arrayValues, CtClass cc) throws CannotCompileException {
        CtField f2 = CtField.make(generateArrayPreInitializedString(arrayName, arrayType, arrayValues), cc);
        f2.setModifiers(Modifier.PUBLIC | Modifier.STATIC);
        cc.addField(f2);
    }

    public static void createArrayWithSizeGlobal(String arrayName, String arrayType, String arraySize, CtClass cc) throws CannotCompileException {
        CtField f2 = CtField.make(getArrayWithSize(arrayName, arrayType, arraySize), cc);
        f2.setModifiers(Modifier.PUBLIC | Modifier.STATIC);
        cc.addField(f2);
    }

    public static String generateArrayPreInitializedString(String arrayName, String arrayType, String arrayValues) {
        String arrayDeclaration = arrayType + "[] " + arrayName + " = new " + arrayType + "[]{";
        arrayDeclaration += arrayValues + "};";
        return arrayDeclaration;
    }

    public static String getArrayWithSize(String arrayName, String arrayType, String arraySize) {
        return arrayType + "[] " + arrayName + " = new " + arrayType + "[" + arraySize + "];";
    }

    //Variable declaration:
    public static String getVariableDeclaration(String variableName, String variableType, String variableValue, boolean isArray) {
        if (variableValue == null || variableValue.equals("")) {
            variableValue = "null";
        }
        if(isArray)
            return variableType + "[] " + variableName + " = " + variableValue + ";";
        else
            return variableType + " " + variableName + " = " + variableValue + ";";
    }

    //global
    public static void createVariableGlobal(String variableName, String variableType, String variableValue, CtClass cc, boolean isFinal, boolean isArray) throws CannotCompileException {
        CtField f2 = CtField.make(getVariableDeclaration(variableName, variableType, variableValue, isArray), cc);
        int flags = Modifier.PUBLIC | Modifier.STATIC;
        if(isFinal)
            flags |= Modifier.FINAL;

        f2.setModifiers(flags);

        cc.addField(f2);
    }

    //function declaration
    public static String getFunctionDeclaration(String functionName, String functionType, String returnType) {
        return functionType + " " + functionName + "() { return " + returnType + "; }";
    }

    //global
    public static CtMethod createFunctionGlobal(String functionName, String functionType, String returnType, CtClass cc) throws CannotCompileException {
        CtMethod f2 = CtMethod.make(getFunctionDeclaration(functionName, functionType, returnType), cc);
        cc.addMethod(f2);
        return f2;
    }


}
