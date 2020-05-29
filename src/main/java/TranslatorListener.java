import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TranslatorListener extends Fortran77ParserBaseListener {

    private List<Variable> variableList = new ArrayList<>();

    private StringBuilder builder = new StringBuilder();

    private String currentReturnName = null;


    enum Type{
        VOID("void"),
        INTEGER("i32");

        private String llvmVal;

        Type(String val){
            this.llvmVal = val;
        }

        public String getLlvmVal(){
            return llvmVal;
        }
    }

    public String getLLVM() {

        String string = builder.toString();

        for(Variable v : variableList){
            string = string.replace("{{"+v.getName()+".functionNameType}}", v.getVariableFunctionNameType());
            string = string.replace("{{"+v.getName()+".nameType}}", v.getVariableNameType());
            string = string.replace("{{"+v.getName()+".name}}", v.getVariableName());
            string = string.replace("{{"+v.getName()+".numberType}}", v.getVariableNumberType());
            string = string.replace("{{"+v.getName()+".number}}", v.getVariableNumber());
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

    @Override public void exitFunctionStatement(Fortran77Parser.FunctionStatementContext ctx) {
        System.out.println("exitFunctionStatement");

    }

    @Override public void exitTypeStatement(Fortran77Parser.TypeStatementContext ctx) {
        System.out.println("exitTypeStatement");
        System.out.println(ctx.getText());

    }

    @Override
    public void enterFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {

    }

//    FUNCTION

    @Override public void enterFunctionStatement(Fortran77Parser.FunctionStatementContext ctx) {

        // DEFINE

        builder.append("define dso_local ");

        // FUNCTION NAME

        String functionName = null;

        // without type
        if(ctx.children.get(0).getText().equals("FUNCTION")){
            functionName = ctx.children.get(1).getText();
            currentReturnName = functionName;
            variableList.add(new Variable(functionName));
            builder.append("{{"+functionName+".functionNameType}} ");

        }
        // with type
        else{
            functionName = ctx.children.get(2).getText();
            currentReturnName = functionName;
            Variable functionVariable = new Variable(functionName);
            functionVariable.setType(Type.valueOf(ctx.children.get(0).getText()).getLlvmVal());
            variableList.add(functionVariable);
            builder.append("{{"+functionName+".functionNameType}}");
        }

        // FUNCTION PARAMETERS

        int paramStartingPoint = 0;

        builder.append("(");

        for(int i = 0; i < ctx.children.size(); i++){
            if(ctx.children.get(i).getText().equals("(")) paramStartingPoint = i;
        }

        if(!ctx.children.get(paramStartingPoint+1).equals(")")){
            String[] parameters = ctx.children.get(paramStartingPoint+1).getText().split(",");

            for(int i = 0; i < parameters.length; i++){
                Variable tmp = new Variable(parameters[i]);
                variableList.add(tmp);
                builder.append("{{"+tmp.getName()+".numberType}}");
                if(i+1 < parameters.length)
                    builder.append(", ");
            }

        }

        builder.append(") local_unnamed_addr #0 { \n");

    }

    @Override
    public void exitSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {
        builder.append("} \n");

    }


    @Override public void enterTypeStatement(Fortran77Parser.TypeStatementContext ctx) {
        String type = Type.valueOf(ctx.children.get(0).getText()).getLlvmVal();

        String[] parameters = ctx.children.get(1).getText().split(",");
        for(int i = 0; i < parameters.length; i++) {
            boolean alreadyExists = false;
            for(int j = 0; j < variableList.size(); j++){
                if(variableList.get(j).getName().equals(parameters[i])){
                    variableList.get(j).setType(type);
                    alreadyExists = true;
                }
            }
            if(alreadyExists) continue;
            Variable tmp = new Variable(parameters[i]);
            tmp.setType(type);
            variableList.add(tmp);
        }

    }

    @Override public void enterAssignmentStatement(Fortran77Parser.AssignmentStatementContext ctx) {
        builder.append("{{" +ctx.children.get(0).getText()+".number}}");
        builder.append(" "+ctx.children.get(1)+" ");

        ParseTree equation = ctx.children.get(2);

        while(equation.getChildCount() == 1){
            equation = equation.getChild(0);
        }


        builder.append("\n");

    }


    @Override public void enterReturnStatement(Fortran77Parser.ReturnStatementContext ctx) {
        builder.append("ret {{" + currentReturnName +".numberType}}\n");

    }


    @Override
    public void exitFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {
        builder.append("\n");
    }


}
