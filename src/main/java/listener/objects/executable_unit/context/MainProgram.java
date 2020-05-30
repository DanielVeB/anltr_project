package listener.objects.executable_unit.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import listener.objects.executable_unit.AbstractUnitContext;

@Getter
@Setter
@NoArgsConstructor
public class MainProgram extends AbstractUnitContext {

    @Override
    public String toLLVM() {
        return null;
    }
}
