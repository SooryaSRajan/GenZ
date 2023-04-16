import GenzModule.GenzLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CharStream codePointCharStream = CharStreams.fromFileName("src/main/resources/code.genz");

        //generates a lexer output for the input code
        GenzLexer lexer = new GenzLexer(codePointCharStream);

        //Gets tokens for the input file
        CommonTokenStream token = new CommonTokenStream(lexer);

        String[] ruleNames = lexer.getRuleNames();

        //print all tokens
        token.fill();

        for (Token i : token.getTokens()) {
            if (i.getType() != -1)
                System.out.println(i.getText() + " " + ruleNames[i.getType() - 1]);
        }

    }
}
