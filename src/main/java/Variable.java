import lombok.Getter;
import lombok.Setter;

public class Variable {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int number;
    @Getter
    @Setter
    private String type;

    static int variableCounter = 0;

    public Variable(String name){
        this.name = name;

        if(name.startsWith("I") || name.startsWith("J") || name.startsWith("K") || name.startsWith("L") || name.startsWith("M") || name.startsWith("N")) type = "int32";
        else type = "float";

        number = variableCounter;
        variableCounter++;
    }

    public String getVariableName(){
        return "%"+name;
    }

    public String getVariableNameType(){
        return type+" %"+name;
    }

    public String getVariableNumber(){
        return "%"+number;
    }

    public String getVariableNumberType(){
        return type+" %"+number;
    }

    public String getVariableFunctionNameType(){
        return type+" @function_"+name;
    }

}
