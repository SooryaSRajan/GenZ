import GenzModule.GenzLexer;
import GenzModule.GenzParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CharStream codePointCharStream = CharStreams.fromFileName("src/main/resources/test.genz");

        //generates a lexer output for the input code
        GenzLexer lexer = new GenzLexer(codePointCharStream);

        //Gets tokens for the input file
        CommonTokenStream token = new CommonTokenStream(lexer);

//        String[] ruleNames = lexer.getRuleNames();
//        token.fill();
//
//        for (Token i : token.getTokens()) {
//            System.out.println("<" + ruleNames[i.getType() - 1] + ", \"" + i.getText() + "\">");
//        }

        //parsing the token stream
        GenzParser parser = new GenzParser(token);
        parser.genz();


    }
}
