import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    private static String FUNCTION_PATH = "src/main/resources/examples/function/function_2.txt";

    private static String IF = "src/main/resources/examples/if/elseif.f90";

    private static String ASSIGN = "src/main/resources/examples/basic/assign";

    public static void main(String[] args) {


        String file = IF;

        TranslatorListener listener = new TranslatorListener();

        CharStream stream = null;

        try {
            stream = CharStreams.fromFileName(file);
        } catch (Exception e) {
            System.out.println("UPS");
        }

        Fortran77Lexer lexer = new Fortran77Lexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        Fortran77Parser parser2 = new Fortran77Parser(tokenStream);
        Fortran77Parser.ProgramContext context = parser2.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, context);

        System.out.println("RESULT");
        System.out.println("_____________________________");
        System.out.println(listener.getLLVM());

    }
}
