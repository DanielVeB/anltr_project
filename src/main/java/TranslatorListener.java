import object.FortranType;
import object.Variable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    }

    @Override
    public void exitProgram(Fortran77Parser.ProgramContext ctx) {

    }

    @Override
    public void enterProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {

    }

    @Override
    public void exitProgramStatement(Fortran77Parser.ProgramStatementContext ctx) {

    }

    @Override
    public void enterPrintStatement(Fortran77Parser.PrintStatementContext ctx) {

    }

    @Override
    public void exitPrintStatement(Fortran77Parser.PrintStatementContext ctx) {

    }

    @Override
    public void enterEndStatement(Fortran77Parser.EndStatementContext ctx) {

    }

    @Override
    public void exitEndStatement(Fortran77Parser.EndStatementContext ctx) {

    }

    @Override
    public void enterExpression(Fortran77Parser.ExpressionContext ctx) {

    }


    @Override
    public void enterExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {

    }

    @Override
    public void exitExecutableStatement(Fortran77Parser.ExecutableStatementContext ctx) {

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

    }

    @Override
    public void exitMainProgram(Fortran77Parser.MainProgramContext ctx) {

    }

    @Override
    public void enterSubprogramBody(Fortran77Parser.SubprogramBodyContext ctx) {

    }


    @Override
    public void enterStatement(Fortran77Parser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(Fortran77Parser.StatementContext ctx) {
    }

    @Override
    public void enterAexpr4(Fortran77Parser.Aexpr4Context ctx) {
        System.out.println(ctx.SCON());
        System.out.println(ctx.getText());

    }

    @Override
    public void exitAexpr4(Fortran77Parser.Aexpr4Context ctx) {

    }


    @Override
    public void enterAexpr0(Fortran77Parser.Aexpr0Context ctx) {
    }

    @Override
    public void exitAexpr0(Fortran77Parser.Aexpr0Context ctx) {

    }

    @Override
    public void enterAexpr1(Fortran77Parser.Aexpr1Context ctx) {
    }

    @Override
    public void exitAexpr1(Fortran77Parser.Aexpr1Context ctx) {
    }

    @Override
    public void exitAexpr2(Fortran77Parser.Aexpr2Context ctx) {
    }

    @Override
    public void enterAexpr3(Fortran77Parser.Aexpr3Context ctx) {
    }

    @Override
    public void exitAexpr3(Fortran77Parser.Aexpr3Context ctx) {
    }

    @Override
    public void exitFunctionStatement(Fortran77Parser.FunctionStatementContext ctx) {

    }

    @Override
    public void exitTypeStatement(Fortran77Parser.TypeStatementContext ctx) {

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

        List<String> equationList = makeEquation(ctx);
        solveEquation(equationList, variableMap.get(equationList.get(0)).getType().getLlvmVal());
    }


    @Override
    public void enterReturnStatement(Fortran77Parser.ReturnStatementContext ctx) {
        builder.append("ret {{" + currentReturnName + ".numberType}}\n");

    }


    @Override
    public void exitFunctionSubprogram(Fortran77Parser.FunctionSubprogramContext ctx) {
        builder.append("\n");
    }



    private void solveEquation(List<String> list, String type){
        List <String> equation = new ArrayList<>(list);
        solveEquationRemoveParenthesis(equation, type);
        solveEquationRemoveMulDiv(equation, type);
        solveEquationRemoveAddSub(equation, type);
        solveEquationFinish(equation, type);
    }

    private void solveEquationFinish(List<String> list, String type){
        List <String> equation = new ArrayList<>(list);

        if(equation.get(0).startsWith("%"))builder.append(equation.get(0)+" = ");
        else builder.append("{{"+equation.get(0)+".number}} = ");
        if(type.equals("i32"))builder.append("add ");     //jesli int
        else builder.append("fadd ");                                                                 //jesli nie int (float) ?
        builder.append(type+" 0, ");
        if(variableMap.containsKey(equation.get(2)))builder.append("{{"+equation.get(2)+".number}}\n"); //jesli zmienna
        else builder.append(equation.get(2)+"\n");                                                      //jesli stala
    }


    private void solveEquationSign(List<String> list, int sign, String intSign, String floatSign, String type){
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

    private void solveEquationRemoveMulDiv(List<String> equation, String type){
        while(equation.contains("*") || equation.contains(("/"))){
            int sign = 0;
            for(int i = 2; i < equation.size(); i++){
                if(equation.get(i).equals("*") || equation.get(i).equals("/")){
                    sign = i;
                    break;
                }
            }
            if(equation.get(sign).equals("*")){
                solveEquationSign(equation, sign, "mul", "fmul", type);
            }
            if(equation.get(sign).equals("/")){
                solveEquationSign(equation, sign, "div", "fdiv", type);
            }
            equation.remove(sign+1);
            equation.remove(sign);
            equation.remove(sign-1);
            equation.add(sign-1,"%"+counter);
        }
    }

    private void solveEquationRemoveParenthesis(List<String> equation, String type){
        while(equation.contains("(")){
            int parenthesisStartPlace = 0;
            int parenthesisEndPlace = 0;
            int parenthesisCounter = 0;
            for(int i = 0; i<equation.size(); i++){
                if(equation.get(i).equals("(")){
                    if(parenthesisCounter==0)
                        parenthesisStartPlace = i;
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

            solveEquation(tmpEquation, type);


            for(int i = parenthesisEndPlace; i >= parenthesisStartPlace; i--){
                equation.remove(i);
            }
            equation.add(parenthesisStartPlace, "%"+counter);

        }

    }

    private void solveEquationRemoveAddSub(List<String> equation, String type){
        while(equation.contains("+") || equation.contains(("-"))){
            int sign = 0;
            for(int i = 2; i < equation.size(); i++){
                if(equation.get(i).equals("-") || equation.get(i).equals("+")){
                    sign = i;
                    break;
                }
            }
            if(equation.get(sign).equals("+")){
                solveEquationSign(equation, sign, "add", "fadd", type);
            }
            if(equation.get(sign).equals("-")){
                solveEquationSign(equation, sign, "sub", "fsub", type);
            }
            equation.remove(sign+1);
            equation.remove(sign);
            equation.remove(sign-1);
            equation.add(sign-1,"%"+counter);
        }
    }

    private List<String> makeEquation(Fortran77Parser.AssignmentStatementContext ctx){

        List<String> equation = new ArrayList<>();


        String equationString = ctx.start.getInputStream().getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));

        CharStream stream = CharStreams.fromString(equationString);
        Fortran77Lexer lexer = new Fortran77Lexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        tokenStream.getNumberOfOnChannelTokens();

        for(int i = 0; i < tokenStream.size(); i++){
            equation.add((tokenStream.get(i).getText()));
        }

        // LICZBY UJEMNE

        String charsNotAllowedBeforeMinus = "=+-*/";

        for(int i = 0; i < equation.size(); i++){
            if(equation.get(i).equals("-"))
                if(charsNotAllowedBeforeMinus.contains(equation.get(i-1))){
                    equation.remove(i);
                    equation.add(i, "-"+equation.get(i));
                    equation.remove(i+1);
                    i--;
            }
        }

        return equation;
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


