package objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FunctionStatement {

    private F_Type type;
    private String functionName;


    public FunctionStatement(F_Type type, String functionName) {
        this.type = type;
        this.functionName = functionName;
    }

    public String getFunctionNameToLLVM(){
        return "@"+functionName;
    }

    public String getTypeToLLVM(){
        return type.getLlvmVal();
    }


}
