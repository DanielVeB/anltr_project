import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    private static String FUNCTION_PATH = "src/main/resources/examples/function/function_1.txt";


    public static void main(String[] args) {



        String file = FUNCTION_PATH;

        TranslatorListener listener = new TranslatorListener();

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

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( listener, context );

    }
}
