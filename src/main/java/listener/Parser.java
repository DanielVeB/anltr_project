package listener;

import listener.objects.Program;
import org.antlr.v4.runtime.CharStream;

public interface Parser {
    Program parse(CharStream charStream);
}
