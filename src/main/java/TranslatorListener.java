public class TranslatorListener extends Fortran77ParserBaseListener {
    @Override
    public void enterProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("enterProgram");
    }
    @Override public void exitProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("exitProgram");

    }

    @Override
    public void enterProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("enterProgramStatement");
    }
    @Override public void exitProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("exitProgramStatement");

    }
    @Override
    public void enterPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
        System.out.println("enterPrintStatement");
    }
    @Override public void exitPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
        System.out.println("exitPrintStatement");

    }
    @Override
    public void enterEndStatement(Fortran77Parser.EndStatementContext ctx) {
        System.out.println("enterEndStatement");

    }
    @Override
    public void exitEndStatement(Fortran77Parser.EndStatementContext ctx) {
        System.out.println("exitEndStatement");

    }
    @Override
    public void enterExpression(Fortran77Parser.ExpressionContext ctx) {
        System.out.println("enterExpression");

    }
    @Override
    public void exitExpression(Fortran77Parser.ExpressionContext ctx) {
        System.out.println("exitExpression");

    }

    @Override
    public void enterExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {
        System.out.println("enterExecutableStatement");

    }
    @Override
    public void exitExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {
        System.out.println("exitExecutableStatement");

    }
    @Override
    public void enterExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {
        System.out.println("enterExecutableUnit");

    }
    @Override
    public void exitExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {
        System.out.println("exitExecutableUnit");

    }
    @Override
    public void enterMainProgram(Fortran77Parser.MainProgramContext ctx) {
        System.out.println("enterMainProgram");

    }
    @Override
    public void exitMainProgram(Fortran77Parser.MainProgramContext ctx) {
        System.out.println("exitMainProgram");

    }
    @Override
    public void enterSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        System.out.println("enterSubprogramBody");

    }
    @Override
    public void exitSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        System.out.println("exitSubprogramBody");

    }
    @Override
    public void enterWholeStatement(Fortran77Parser.WholeStatementContext ctx) {
        System.out.println("enterWholeStatement");

    }

    @Override
    public void exitWholeStatement(Fortran77Parser.WholeStatementContext ctx) {
        System.out.println("exitWholeStatement");

    }
    @Override
    public void enterStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("enterStatement");

    }

    @Override
    public void exitStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("exitStatement");

    }

    @Override public void enterAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println(ctx.SCON());

    }

    @Override public void exitAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println("exitAexpr4");

    }











}
