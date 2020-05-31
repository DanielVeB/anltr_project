package object;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Variable {


    private String name;

    private int number;

    private FortranType type;    // CHANGED to ENUM

    private final List<Character> intStartsLetter = new LinkedList<>(
            Arrays.asList('I', 'J', 'K', 'L', 'M', 'N')
    );

    public Variable(String name) {
        this.name = name;
        if (intStartsLetter.contains(name.toUpperCase().charAt(0))) {
            type = FortranType.INTEGER;
        } else {
            type = FortranType.REAL;
        }
    }

    public Variable(String name, int num) {
        this(name);
        this.number = num;
    }

    public String getLLVMType() { return type.getLlvmVal();}

    public String getVariableName() {
        return "%" + name;
    }

    public String getVariableNameType() {
        return type.getLlvmVal() + " %" + name;
    }

    public String getVariableNumber() {
        return "%" + number;
    }

    public String getVariableNumberType() {
        return type.getLlvmVal() + " %" + number;
    }

    public String getVariableFunctionNameType() {
        return type.getLlvmVal() + " @function_" + name;
    }

}
