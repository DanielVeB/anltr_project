package listener.objects;

import listener.objects.executable_unit.context.FunctionSubprogram;
import org.junit.Test;

public class FunctionSubprogramTest {

    FunctionStatement functionStatement =
            new FunctionStatement(F_Type.INTEGER, "function");
    SubprogramBody subprogramBody =
            new SubprogramBody();

    private FunctionSubprogram subprogram =
            new FunctionSubprogram();

    @Test
    public void shouldReturnCorrectFunctionDefinition() {
        subprogram.setSubprogramBody(subprogramBody);
        subprogram.setFunctionStatement(functionStatement);

        System.out.println(subprogram.toLLVM());
    }
}