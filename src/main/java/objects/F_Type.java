package objects;

public enum  F_Type {

    VOID("void"),
    INTEGER("i32");

    private String llvmVal;

    F_Type(String val){
        this.llvmVal = val;
    }

    public String getLlvmVal(){
        return llvmVal;
    }
}
