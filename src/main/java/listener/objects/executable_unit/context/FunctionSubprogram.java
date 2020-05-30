package listener.objects.executable_unit.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import listener.objects.FunctionStatement;
import listener.objects.SubprogramBody;
import listener.objects.executable_unit.AbstractUnitContext;

@Getter @Setter @NoArgsConstructor
public class FunctionSubprogram extends AbstractUnitContext {

    private FunctionStatement functionStatement;
    private SubprogramBody subprogramBody;


    @Override
    public String toLLVM() {
        return "define "+
                functionStatement.getTypeToLLVM() +" "+
                functionStatement.getFunctionNameToLLVM() +
                " local_unnamed_addr #0 { \n" +
                subprogramBody.toLLVM() +
                "}\n";
    }
}
