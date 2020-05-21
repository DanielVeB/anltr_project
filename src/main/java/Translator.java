public class Translator extends Fortran77ParserBaseVisitor<String>{

    @Override
    public String visitProgram(Fortran77Parser.ProgramContext ctx) {
        return ctx.getText();
    }

}
