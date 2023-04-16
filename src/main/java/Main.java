import GenzModule.GenzLexer;
import GenzModule.GenzParser;
import TreeWalker.GenZWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFile = "src/main/resources/test.genz";
        if (pathToFile == null) {
            throw new IOException("No file path provided");
        } else if (!pathToFile.endsWith(".genz")) {
            throw new IOException("File is not a .genz file");
        }

        //Get name of file, also consider for cases where there are no /
        String fileName = pathToFile.substring(pathToFile.lastIndexOf("/") + 1, pathToFile.lastIndexOf("."));
        fileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);

        CharStream codePointCharStream = CharStreams.fromFileName(pathToFile);

        //generates a lexer output for the input code
        GenzLexer lexer = new GenzLexer(codePointCharStream);

        //Gets tokens for the input file
        CommonTokenStream token = new CommonTokenStream(lexer);

        //parser
        GenzParser parser = new GenzParser(token);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new GenZWalker(fileName), parser.codeEntry());

    }
}
