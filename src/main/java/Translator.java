public class Translator extends Fortran77ParserBaseVisitor<String>{

    @Override
    public String visitProgram(Fortran77Parser.ProgramContext ctx) {
        return ctx.getText();
    }
    @Override
    public String visitProgramStatement(Fortran77Parser.ProgramStatementContext ctx) { return visitChildren(ctx); }

}
