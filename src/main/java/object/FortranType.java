package object;

public enum  FortranType {
    VOID("void"),
    INTEGER("i32");

    private String llvmVal;

    FortranType(String val){
        this.llvmVal = val;
    }

    public String getLlvmVal(){
        return llvmVal;
    }
}
