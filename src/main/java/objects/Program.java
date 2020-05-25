package objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import objects.executable_unit.ExecutableUnit;

@Getter
@Setter
@NoArgsConstructor
public class Program {

    private ExecutableUnit unit;

    public String toLLVM(){
        return unit.toLLVM();
    }
}
