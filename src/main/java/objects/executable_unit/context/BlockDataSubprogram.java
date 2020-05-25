package objects.executable_unit.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import objects.executable_unit.AbstractUnitContext;
@Getter
@Setter
@NoArgsConstructor

public class BlockDataSubprogram extends AbstractUnitContext {
    @Override
    public String toLLVM() {
        return null;
    }
}
