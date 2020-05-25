package objects.executable_unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ExecutableUnit {

    AbstractUnitContext context;

    public String toLLVM(){
        return context.toLLVM() + "\n";
    }
}
