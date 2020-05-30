package object;

public enum FortranType {

    VOID("void",0),
    INTEGER("i32",4),
    REAL("float",4),
    DOUBLE_PRECISION("double", 8),
    LOGICAL("i1",1);

    private String llvmVal;
    private int bytes;

    public static FortranType getType(String type){
        switch (type.toUpperCase()){
            case "DOUBLEPRECISION":
                return FortranType.DOUBLE_PRECISION;
            case "REAL":
                return FortranType.REAL;
            case "INTEGER":
                return FortranType.INTEGER;
            case "LOGICAL":
                return FortranType.LOGICAL;
        }
        return null;
    }

    FortranType(String val, int bytes) {

        this.llvmVal = val;
        this.bytes = bytes;
    }

    public String getLlvmVal() {
        return llvmVal;
    }
    public int getBytes() {
        return bytes;
    }

}
