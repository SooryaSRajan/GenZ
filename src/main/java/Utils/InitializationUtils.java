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
                case "noob" -> "V";
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
                case "noob" -> "void";
                default -> type;
            };

        }

        return type;
    }

    public static Types getParameterType(GenzParser.ParameterContext ctx){

        Types type = new Types();
        String baseType = getType(ctx.typesWithArray().types().getText(), true);
        type.setDataType(baseType);
        boolean isHighKeyType = ctx.typesWithArray().arrayChoice() != null && ctx.typesWithArray().arrayChoice().ARRAY() != null;
        type.setArraySize(0);
        type.setArray(isHighKeyType);
        return type;

    }

    public static Types getTypeData(GenzParser.TypesWithArrayContext ctx){

        Types type = new Types();
        String baseType = getType(ctx.types().getText(), true);
        type.setDataType(baseType);
        boolean isHighKeyType = ctx.arrayChoice() != null && ctx.arrayChoice().ARRAY() != null;

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

    //Variable declaration:
    public static String getVariableDeclaration(String variableName, String variableValue, Types type) {
        if (variableValue == null || variableValue.equals("")) {
            if(type.isArray()){
                return type.getDataType() + "[] " + variableName + " = new " + type.getDataType() + "[" + type.getArraySize() + "];";
            }
            else
                return type.getDataType() + " " + variableName + ";";
        }
        if(type.isArray())
            return type.getDataType() + "[] " + variableName + " = " + variableValue + ";";
        else
            return type.getDataType() + " " + variableName + " = " + variableValue + ";";
    }

    //global
    public static void createVariableGlobal(String variableName, String variableValue, CtClass cc, boolean isFinal, Types types) throws CannotCompileException {
        CtField f2 = CtField.make(getVariableDeclaration(variableName, variableValue, types), cc);
        int flags = Modifier.PUBLIC | Modifier.STATIC;
        if(isFinal)
            flags |= Modifier.FINAL;

        f2.setModifiers(flags);

        cc.addField(f2);
    }

    public static String createVariableLocal(String variableName, String variableValue, CtClass cc, boolean isFinal, Types types){
        return getVariableDeclaration(variableName, variableValue, types);
    }



}
