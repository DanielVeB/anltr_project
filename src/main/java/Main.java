import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {


    public static void main(String[] args) {

        String file = "src/main/resources/examples/example1.txt";

        Translator translator = new Translator();

        CharStream stream = null;

        try {
            stream = CharStreams.fromFileName(file);
        }catch (Exception e){
            System.out.println("UPS");
        }
        Fortran77Lexer lexer = new Fortran77Lexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        Fortran77Parser parser = new Fortran77Parser(tokenStream);
        Fortran77Parser.ProgramContext context= parser.program();
        translator.visit(context);

    }
}
