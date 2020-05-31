import object.FortranType;
import object.Variable;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatorListener extends Fortran77ParserBaseListener {

    private static int counter = 0;

    private int setCounter(){
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
            }
            else{
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

        // TO DO    BUDOWANIE TAKIEJ LISTY Z LISCI


        List<String> listka = new ArrayList<>();
        listka.add("F");
        listka.add("=");
        listka.add("X");
        listka.add("+");
        listka.add("2");
        listka.add("+");
        listka.add("3");
        listka.add("*");
        listka.add("62");
        listka.add("+");
        listka.add("(");
        listka.add("2");
        listka.add("+");
        listka.add("3");
        listka.add("+");
        listka.add("(");
        listka.add("2");
        listka.add("+");
        listka.add("3");
        listka.add("/");
        listka.add("4");
        listka.add(")");
        listka.add(")");
        listka.add("*");
        listka.add("62");
        makeEquation(listka, variableMap.get(listka.get(0)).getLLVMType());
    }


    @Override
    public void enterReturnStatement(Fortran77Parser.ReturnStatementContext ctx) {
        builder.append("ret {{" + currentReturnName + ".numberType}}\n");

    }


    @Override
    public void exitFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {
        builder.append("\n");
    }



    private void makeEquation(List<String> list, String type){
        List <String> equation = new ArrayList<>(list);
        while(equation.contains("(")){
            int parenthesisStartPlace = 0;
            int parenthesisEndPlace = 0;
            int parenthesisCounter = 0;
            for(int i = 0; i<equation.size(); i++){
                if(equation.get(i).equals("(")){
                    if(parenthesisCounter==0) parenthesisStartPlace = i;
                    parenthesisCounter++;
                }
                if(equation.get(i).equals(")")){
                    parenthesisCounter--;
                    if(parenthesisCounter==0){
                        parenthesisEndPlace = i;
                        break;
                    }

                }
            }

            counter++;
            List<String> tmpEquation = new ArrayList<>(equation.subList(parenthesisStartPlace+1,parenthesisEndPlace));
            tmpEquation.add(0, "=");
            tmpEquation.add(0, "%"+counter);

            makeEquation(tmpEquation, type);


            for(int i = parenthesisEndPlace; i >= parenthesisStartPlace; i--){
                equation.remove(i);
            }
            equation.add(parenthesisStartPlace, "%"+counter);

        }


        makeEquationRemoveMulDiv(equation, type);
        makeEquationRemoveAddSub(equation, type);
        makeEquationFinish(equation, type);
    }

    private void makeEquationFinish(List<String> list, String type){
        List <String> equation = new ArrayList<>(list);

        if(equation.get(0).startsWith("%")){
            return;
        }
        else builder.append("{{"+equation.get(0)+".number}} = ");
        if(type.equals("i32"))builder.append("add ");     //jesli int
        else builder.append("fadd ");                                                                 //jesli nie int (float) ?
        builder.append(type+" 0, ");
        if(variableMap.containsKey(equation.get(2)))builder.append("{{"+equation.get(2)+".number}}\n"); //jesli zmienna
        else builder.append(equation.get(2)+"\n");                                                      //jesli stala
    }


    private void makeEquationSign(List<String> list, int sign, String intSign, String floatSign, String type){
        List <String> equation = new ArrayList<>(list);

        counter++;
        builder.append("%"+counter+" = ");
        if(type.equals("i32"))builder.append(intSign+" ");     //jesli int
        else builder.append(floatSign+" ");                                                                 //jesli nie int (float) ?

        builder.append(type+" ");

        if(equation.get(sign-1).startsWith("%")) builder.append(equation.get(sign-1)+", ");           //jesli zmienna spoza listy
        else if(variableMap.containsKey(equation.get(sign-1)))builder.append("{{"+equation.get(sign-1)+".number}}, "); //jesli zmienna
        else builder.append(equation.get(sign-1)+", ");

        if(equation.get(sign+1).startsWith("%")) builder.append(equation.get(sign+1)+"\n");           //jesli zmienna spoza listy
        else if(variableMap.containsKey(equation.get(sign+1)))builder.append("{{"+equation.get(sign+1)+".number}}\n"); //jesli zmienna
        else builder.append(equation.get(sign+1)+"\n");
    }

    private void makeEquationRemoveMulDiv(List<String> equation, String type){
        while(equation.contains("*") || equation.contains(("/"))){
            int sign = 0;
            for(int i = 2; i < equation.size(); i++){
                if(equation.get(i).equals("*") || equation.get(i).equals("/")){
                    sign = i;
                    break;
                }
            }
            if(equation.get(sign).equals("*")){
                makeEquationSign(equation, sign, "mul", "fmul", type);
            }
            if(equation.get(sign).equals("/")){
                makeEquationSign(equation, sign, "div", "fdiv", type);
            }
            equation.remove(sign+1);
            equation.remove(sign);
            equation.remove(sign-1);
            equation.add(sign-1,"%"+counter);
        }
    }

    private void makeEquationRemoveAddSub(List<String> equation, String type){
        while(equation.contains("+") || equation.contains(("-"))){
            int sign = 0;
            for(int i = 2; i < equation.size(); i++){
                if(equation.get(i).equals("-") || equation.get(i).equals("+")){
                    sign = i;
                    break;
                }
            }
            if(equation.get(sign).equals("+")){
                makeEquationSign(equation, sign, "add", "fadd", type);
            }
            if(equation.get(sign).equals("-")){
                makeEquationSign(equation, sign, "sub", "fsub", type);
            }
            equation.remove(sign+1);
            equation.remove(sign);
            equation.remove(sign-1);
            equation.add(sign-1,"%"+counter);
        }
    }

}

