public class TranslatorListener extends Fortran77ParserBaseListener {

    @Override
    public void enterProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("enterProgram");
        System.out.println(ctx.getText());
    }

    @Override public void exitProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("exitProgram");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("enterProgramStatement");
        System.out.println(ctx.getText());

    }
    @Override public void exitProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("exitProgramStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
        System.out.println("enterPrintStatement");
        System.out.println(ctx.getText());

    }
    @Override public void exitPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
        System.out.println("exitPrintStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterEndStatement(Fortran77Parser.EndStatementContext ctx) {
        System.out.println("enterEndStatement");

    }
    @Override
    public void exitEndStatement(Fortran77Parser.EndStatementContext ctx) {
        System.out.println("exitEndStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterExpression(Fortran77Parser.ExpressionContext ctx) {
        System.out.println("enterExpression");
        System.out.println(ctx.getText());

    }
    @Override
    public void exitExpression(Fortran77Parser.ExpressionContext ctx) {
        System.out.println("exitExpression");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {
        System.out.println("enterExecutableStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void exitExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {
        System.out.println("exitExecutableStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {
        System.out.println("enterExecutableUnit");
        System.out.println(ctx.getText());

    }
    @Override
    public void exitExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {
        System.out.println("exitExecutableUnit");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterMainProgram(Fortran77Parser.MainProgramContext ctx) {
        System.out.println("enterMainProgram");
        System.out.println(ctx.getText());

    }
    @Override
    public void exitMainProgram(Fortran77Parser.MainProgramContext ctx) {
        System.out.println("exitMainProgram");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        System.out.println("enterSubprogramBody");
        System.out.println(ctx.getText());

    }
    @Override
    public void exitSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        System.out.println("exitSubprogramBody");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterWholeStatement(Fortran77Parser.WholeStatementContext ctx) {
        System.out.println("enterWholeStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitWholeStatement(Fortran77Parser.WholeStatementContext ctx) {
        System.out.println("exitWholeStatement");
        System.out.println(ctx.getText());

    }
    @Override
    public void enterStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("enterStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("exitStatement");
        System.out.println(ctx.getText());

    }

    @Override public void enterAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println(ctx.SCON());
        System.out.println(ctx.getText());

    }

    @Override public void exitAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println("exitAexpr4");
        System.out.println(ctx.getText());

    }


    @Override public void enterAssignmentStatement(Fortran77Parser.AssignmentStatementContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override public void enterAexpr0(Fortran77Parser.Aexpr0Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override public void exitAexpr0(Fortran77Parser.Aexpr0Context ctx) {
        System.out.println("exitAexpr0");
        System.out.println(ctx.getText());

    }
    @Override public void enterAexpr1(Fortran77Parser.Aexpr1Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override public void exitAexpr1(Fortran77Parser.Aexpr1Context ctx) {
        System.out.println("exitAexpr1");
        System.out.println(ctx.getText());
    }

    @Override public void enterAexpr2(Fortran77Parser.Aexpr2Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override public void exitAexpr2(Fortran77Parser.Aexpr2Context ctx) {
        System.out.println("exitAexpr2");
        System.out.println(ctx.getText());
    }

    @Override public void enterAexpr3(Fortran77Parser.Aexpr3Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override public void exitAexpr3(Fortran77Parser.Aexpr3Context ctx) {
        System.out.println("exitAexpr3");
        System.out.println(ctx.getText());
    }







}
