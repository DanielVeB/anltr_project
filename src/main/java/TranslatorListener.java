import object.FortranType;
import object.Variable;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class TranslatorListener extends Fortran77ParserBaseListener {

    private static int counter = 0;

    private static int ifHoleCounter = 0;
    private final String IF_HOLE = "IF_HOLE";

    private final String ELSE_HOLE = "ELSE_HOLE";
    private boolean enableLabel = false;

    private void enableLabel() {
        enableLabel = true;
    }

    private void disableLabel() {
        enableLabel = false;
    }

    private boolean logicalExpressionEnabled = false;

    private int setCounter() {
        return counter++;
    }

    private Map<String, Variable> variableMap = new HashMap<>();

    private StringBuilder builder = new StringBuilder();

    private String currentReturnName = null;

    public String getLLVM() {

        String string = builder.toString();

        for (Variable v : variableMap.values()) {
            string = string.replace("{{" + v.getName() + ".functionNameType}}", v.getVariableFunctionNameType());
            string = string.replace("{{" + v.getName() + ".nameType}}", v.getVariableNameType());
            string = string.replace("{{" + v.getName() + ".name}}", v.getVariableName());
            string = string.replace("{{" + v.getName() + ".numberType}}", v.getVariableNumberType());
            string = string.replace("{{" + v.getName() + ".number}}", v.getVariableNumber());
        }

        return string;
    }

    @Override
    public void enterProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("enterProgram");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitProgram(Fortran77Parser.ProgramContext ctx) {
        System.out.println("exitProgram");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("enterProgramStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {
        System.out.println("exitProgramStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
        System.out.println("enterPrintStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitPrintStatement(Fortran77Parser.PrintStatementContext ctx) {
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

    }

    @Override
    public void exitExecutableUnit(Fortran77Parser.ExecutableUnitContext ctx) {
        builder.append("\n");

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
    public void enterStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("enterStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitStatement(Fortran77Parser.StatementContext ctx) {
        System.out.println("exitStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println(ctx.SCON());
        System.out.println(ctx.getText());

    }

    @Override
    public void exitAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println("exitAexpr4");
        System.out.println(ctx.getText());

    }


    @Override
    public void enterAexpr0(Fortran77Parser.Aexpr0Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitAexpr0(Fortran77Parser.Aexpr0Context ctx) {
        System.out.println("exitAexpr0");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterAexpr1(Fortran77Parser.Aexpr1Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitAexpr1(Fortran77Parser.Aexpr1Context ctx) {
        System.out.println("exitAexpr1");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterAexpr2(Fortran77Parser.Aexpr2Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitAexpr2(Fortran77Parser.Aexpr2Context ctx) {
        System.out.println("exitAexpr2");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterAexpr3(Fortran77Parser.Aexpr3Context ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitAexpr3(Fortran77Parser.Aexpr3Context ctx) {
        System.out.println("exitAexpr3");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitFunctionStatement(Fortran77Parser.FunctionStatementContext ctx) {
        System.out.println("exitFunctionStatement");

    }

    @Override
    public void exitTypeStatement(Fortran77Parser.TypeStatementContext ctx) {
        System.out.println("exitTypeStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {

    }

//    FUNCTION

    @Override
    public void enterFunctionStatement(Fortran77Parser.FunctionStatementContext ctx) {

        // DEFINE

        builder.append("define dso_local ");

        // FUNCTION NAME

        String functionName = null;

        // without type
        if (ctx.children.get(0).getText().equals("FUNCTION")) {
            functionName = ctx.children.get(1).getText();
            currentReturnName = functionName;
//            variableList.add(new Variable(functionName));
            variableMap.put(functionName, new Variable(functionName, setCounter())); //changed to map
            builder.append("{{" + functionName + ".functionNameType}} ");

        }
        // with type
        else {
            functionName = ctx.children.get(2).getText();
            currentReturnName = functionName;
            Variable functionVariable = new Variable(functionName, setCounter());
            functionVariable.setType(FortranType.getType(ctx.children.get(0).getText()));
//            variableList.add(functionVariable);
            variableMap.put(functionName, functionVariable);    //c
            builder.append("{{" + functionName + ".functionNameType}}");
        }

        // FUNCTION PARAMETERS

        int paramStartingPoint = 0;

        builder.append("(");

        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i).getText().equals("(")) paramStartingPoint = i;
        }

        if (!ctx.children.get(paramStartingPoint + 1).equals(")")) {
            String[] parameters = ctx.children.get(paramStartingPoint + 1).getText().split(",");

            for (int i = 0; i < parameters.length; i++) {
                Variable tmp = new Variable(parameters[i], setCounter());
//                variableList.add(tmp);
                variableMap.put(tmp.getName(), tmp); //changed to map
                builder.append("{{" + tmp.getName() + ".numberType}}");
                if (i + 1 < parameters.length)
                    builder.append(", ");
            }

        }

        builder.append(") local_unnamed_addr #0 { \n");

    }

    @Override
    public void exitSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        builder.append("} \n");

    }


    @Override
    public void enterTypeStatement(Fortran77Parser.TypeStatementContext ctx) {

        FortranType t = FortranType.getType(ctx.children.get(0).getText().toUpperCase());
        String[] parameters = ctx.children.get(1).getText().split(",");
        for (String parameter : parameters) {
            Variable variable = variableMap.get(parameter);
            if (variable == null) {
                variable = new Variable(parameter);
                variable.setNumber(setCounter());
                variable.setType(t);
                variableMap.put(parameter, variable);
            } else {
                variable.setType(t);
            }
            builder.append("%")
                    .append(variable.getNumber())
                    .append(" = alloca ")
                    .append(variable.getType().getLlvmVal())
                    .append(", align ")
                    .append(variable.getType().getBytes())
                    .append("\n");
        }

    }

    @Override
    public void enterAssignmentStatement(Fortran77Parser.AssignmentStatementContext ctx) {

        //        assignmentStatement ->
        //          varRef ASSIGN expression

        //        example
        //        A - %1 , B = %2
        //
        //        B = 2
        //        A = 2 + B
        //        store i32 2, i32* %2, allign 4        <- assign 2 to B
        //
        //        %3 = load i32, i32* %1, align 4
        //        %4 = add nsw i32 2, %3
        //        store i32 %4, i32* %1, align 4
        //

        Variable v = variableMap.get(ctx.children.get(0).getText());
        builder.append("store ")
                .append(v.getType().getLlvmVal())
                .append(" ")
                .append(v.getVariableNumber())

                .append(" " + ctx.children.get(1) + " ");

        ParseTree equation = ctx.children.get(2);

        while (equation.getChildCount() == 1) {
            equation = equation.getChild(0);
        }


        builder.append("\n");

    }


    @Override
    public void enterReturnStatement(Fortran77Parser.ReturnStatementContext ctx) {
        builder.append("ret {{" + currentReturnName + ".numberType}}\n");

    }


    @Override
    public void exitFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {
        builder.append("\n");
    }

    @Override
    public void exitExpression(Fortran77Parser.ExpressionContext ctx) {


    }


    //  LOGICAL EXPRESSION
    @Override
    public void enterLogicalExpression(Fortran77Parser.LogicalExpressionContext ctx) {
//        builder.append("enterLogicalExp").append("\n");
        logicalExpressionEnabled = true;
    }

    @Override
    public void exitLogicalExpression(Fortran77Parser.LogicalExpressionContext ctx) {
//        builder.append("exitLogicalExp").append("\n");

        builder.append("br i1 ")
                .append("%" + setCounter())
                .append(", label ")
                .append("%" + (counter))
                .append(", label ")
                .append("%" + IF_HOLE + (++ifHoleCounter))
                .append("\n\n");
    }

//    IF STATEMENT

    @Override
    public void enterIfStatement(Fortran77Parser.IfStatementContext ctx) {
        enableLabel();
    }

    @Override
    public void exitIfStatement(Fortran77Parser.IfStatementContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void enterBlockIfStatement(Fortran77Parser.BlockIfStatementContext ctx) {

    }

    @Override
    public void exitBlockIfStatement(Fortran77Parser.BlockIfStatementContext ctx) {

        System.out.println(ctx.getText());
    }

    @Override
    public void enterFirstIfBlock(Fortran77Parser.FirstIfBlockContext ctx) {
        enableLabel();
    }

    @Override
    public void exitFirstIfBlock(Fortran77Parser.FirstIfBlockContext ctx) {
    }

    @Override
    public void enterElseIfStatement(Fortran77Parser.ElseIfStatementContext ctx) {
        String text = builder.toString();
        text = text.replaceAll(IF_HOLE + (ifHoleCounter), String.valueOf(counter));

        builder = new StringBuilder(text);

        builder.append("; <label>: ")
                .append(setCounter())
                .append(":\n");
    }

    @Override
    public void exitElseIfStatement(Fortran77Parser.ElseIfStatementContext ctx) {

        System.out.println(ctx.getText());
    }

    @Override
    public void enterElseStatement(Fortran77Parser.ElseStatementContext ctx) {
        disableLabel();
        String text = builder.toString();
        text = text.replaceAll(IF_HOLE + (ifHoleCounter), String.valueOf(counter));

        builder = new StringBuilder(text);

        builder.append("; <label>: ")
                .append(setCounter())
                .append(":\n");
    }

    @Override
    public void exitElseStatement(Fortran77Parser.ElseStatementContext ctx) {
        builder.append("br label %")
                .append(ELSE_HOLE)
                .append("\n\n");
    }

    @Override
    public void enterEndIfStatement(Fortran77Parser.EndIfStatementContext ctx) {
        String text = builder.toString();
        text = text.replaceAll(ELSE_HOLE, String.valueOf(counter));

        builder = new StringBuilder(text);

        builder.append("; <label>:")
                .append(setCounter())
                .append(":\n");
    }

    @Override
    public void exitEndIfStatement(Fortran77Parser.EndIfStatementContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void enterWholeStatement(Fortran77Parser.WholeStatementContext ctx) {
        if (enableLabel) {
            builder.append("; <label>:")
                    .append(setCounter())
                    .append(":\n");
        }

    }

    @Override
    public void exitWholeStatement(Fortran77Parser.WholeStatementContext ctx) {

        if (enableLabel) {
            builder.append("br label %")
                    .append(ELSE_HOLE)
                    .append("\n\n");
        }

    }

    @Override
    public void enterLexpr4(Fortran77Parser.Lexpr4Context ctx) {
//        builder.append("enterLexpr4").append("\n");
//        String obj1 = ctx.children.get(0).getText();
//        TerminalNode node = (TerminalNode) ctx.children.get(1);
//        String obj2 = ctx.children.get(2).getText();
        if (logicalExpressionEnabled) {

            String firstVarRef = "";
            String secondVarRef = "";

            String varName = ctx.children.get(0).getText();
            if (variableMap.containsKey(varName)) {
                getVariable(varName);
                firstVarRef = "%" + (counter - 1);
            } else {
                firstVarRef = varName;
            }

            String var2Name = ctx.children.get(2).getText();
            if (variableMap.containsKey(var2Name)) {
                getVariable(var2Name);
                secondVarRef = "%" + (counter - 1);
            } else {
                secondVarRef = var2Name;
            }

            builder.append("%" + counter)
                    .append(" = icmp ");
//                    .append("sgt" )
            switch (ctx.children.get(1).getText().toLowerCase()) {
                case ".le.":
                    builder.append(" slt");
                    break;
                case ".ge.":
                    builder.append(" sgt");
                    break;
                case ".eq.":
                    builder.append(" eq");
                    break;
                case ".neq.":
                    builder.append(" neq");
                    break;
            }

            builder.append(" i32 ") //need to be changed
                    .append(firstVarRef + ", ")
                    .append(secondVarRef)
                    .append("\n");


            logicalExpressionEnabled = false;
        }
    }

    private String getVariable(String varName) {
        Variable variable = variableMap.get(varName);
        builder.append("%" + setCounter())
                .append(" = load ")
                .append(variable.getType().getLlvmVal())
                .append(", " + variable.getType().getLlvmVal() + "* ")
                .append("%")
                .append(variable.getNumber())
                .append(", align ")
                .append(variable.getType().getBytes())
                .append("\n");

        return "%" + variable.getNumber();
    }

}
