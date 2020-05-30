import listener.Parser;
import lombok.Getter;
import listener.objects.F_Type;
import listener.objects.FunctionStatement;
import listener.objects.Program;
import listener.objects.SubprogramBody;
import listener.objects.executable_unit.AbstractUnitContext;
import listener.objects.executable_unit.ExecutableUnit;
import listener.objects.executable_unit.context.FunctionSubprogram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;


public class ListenerOrientedParser implements Parser {


    @Override
    public Program parse(CharStream charStream) {

        Fortran77Lexer lexer = new Fortran77Lexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        Fortran77Parser parser = new Fortran77Parser(tokens);

        ProgramListener listener = new ProgramListener();
        parser.program().enterRule(listener);
        return listener.getProgram();
    }

    class ProgramListener extends Fortran77ParserBaseListener {

        private Program program;

        public Program getProgram() {
            return program;
        }

        @Override
        public void enterProgram(Fortran77Parser.ProgramContext ctx) {
            program = new Program();

//            program
//            : executableUnit + EOL*
//            ;
//            Program has only executableUnit child.

            ExecutableUnitListener executableUnitListener = new ExecutableUnitListener();
            ctx.executableUnit().forEach(
                    unit -> unit.enterRule(executableUnitListener)
            );
            ExecutableUnit unit = executableUnitListener.getUnit();
            program.setUnit(unit);

        }

    }

    @Getter
    class ExecutableUnitListener extends Fortran77ParserBaseListener {
        private ExecutableUnit unit;

        @Override
        public void enterExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {

//            executableUnit
//            : functionSubprogram
//                    | mainProgram
//                    | subroutineSubprogram
//                    | blockdataSubprogram
//            ;

            unit = new ExecutableUnit();
            AbstractUnitContext abstractUnitContext = null;

            if (ctx.functionSubprogram() != null) {
                FunctionSubprogramListener listener = new FunctionSubprogramListener();
                ctx.functionSubprogram().enterRule(listener);
                abstractUnitContext = listener.getFunctionSubprogram();

            } else if (ctx.mainProgram() != null) {
//                ctx.mainProgram().enterRule();

            } else if (ctx.subroutineSubprogram() != null) {
//                ctx.subroutineSubprogram().enterRule();

            } else if (ctx.blockdataSubprogram() != null) {
//                ctx.blockdataSubprogram().enterRule();
            }

            unit.setContext(abstractUnitContext);
        }
    }

    @Getter
    class FunctionSubprogramListener extends Fortran77ParserBaseListener {
        private FunctionSubprogram functionSubprogram;

        @Override
        public void enterFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {

            functionSubprogram = new FunctionSubprogram();

//            TEMPORARY, make listeners for this entities
            functionSubprogram.setFunctionStatement(new FunctionStatement(F_Type.INTEGER, "fun"));
            functionSubprogram.setSubprogramBody(new SubprogramBody());
//                    ==============

        }
    }
}