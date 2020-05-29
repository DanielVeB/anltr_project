import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import objects.*;
public class Main {

    private static String FUNCTION_PATH = "src/main/resources/examples/function/function_1.txt";
    private static String BASIC = "src/main/resources/examples/basic/b.txt";

    public static void main(String[] args) {


        String file = BASIC;

        TranslatorListener listener = new TranslatorListener();

        CharStream stream = null;

        try {
            stream = CharStreams.fromFileName(file);
        } catch (Exception e) {
            System.out.println("UPS");
        }


//        ListenerOrientedParser parser = new ListenerOrientedParser();
//        Program program = parser.parse(stream);
//        System.out.println(program.toLLVM());


        Fortran77Lexer lexer = new Fortran77Lexer(stream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        Fortran77Parser parser2 = new Fortran77Parser(tokenStream);
        Fortran77Parser.ProgramContext context = parser2.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, context);

        System.out.println("----------------------------");
        System.out.println(stream);

        System.out.println("_____________________________");
        System.out.println(listener.getLLVM());

    }
}
