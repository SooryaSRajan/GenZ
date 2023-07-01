import Exceptions.InvalidNameException;
import GenzModule.GenzLexer;
import GenzModule.GenzParser;
import TreeWalker.GenZWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException, InvalidNameException {

        //pre-check for file
        String pathToFile = args[0];
        if (pathToFile == null) {
            throw new IOException("No file path provided");
        } else if (!pathToFile.endsWith(".genz")) {
            throw new IOException("File is not a .genz file");
        }

        //pre-check for file existence
        File f = new File(pathToFile);
        if (!(f.exists() && !f.isDirectory())) {
            throw new IOException("File does not exist");
        }

        //pre-check for file name
        String fileName = pathToFile.substring(pathToFile.lastIndexOf("/") + 1, pathToFile.lastIndexOf("."));
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]*$");
        if (!pattern.matcher(fileName).matches()) {
            throw new InvalidNameException(String.format("File name %s is invalid, file name must follow upper camel case and must be devoid of special characters and numbers", fileName));
        }

        //gets the path of the directory
        String pathOfDirectory = pathToFile.substring(0, pathToFile.lastIndexOf("/"));

        //reads the input file
        CharStream codePointCharStream = CharStreams.fromFileName(pathToFile);

        //generates a lexer output for the input code
        GenzLexer lexer = new GenzLexer(codePointCharStream);

        //gets tokens for the input file
        CommonTokenStream token = new CommonTokenStream(lexer);

        //parser
        GenzParser parser = new GenzParser(token);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new GenZWalker(fileName, pathOfDirectory), parser.codeEntry());

    }
}
