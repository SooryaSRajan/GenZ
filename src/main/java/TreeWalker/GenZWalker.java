package TreeWalker;

import GenzModule.GenzBaseListener;
import GenzModule.GenzParser;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class GenZWalker extends GenzBaseListener {

    ClassWriter cw;
    String className;

    Stack<MethodVisitor> methodStack = new Stack<>();

    public GenZWalker(String className) {
        this.className = className;
        cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    }

    @Override
    public void enterCodeEntry(GenzParser.CodeEntryContext ctx) {
        super.enterCodeEntry(ctx);
        cw.visit(52, 0, className, null, "java/lang/Object", null);
    }

    @Override
    public void exitCodeEntry(GenzParser.CodeEntryContext ctx) {
        super.exitCodeEntry(ctx);
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        try {
            FileOutputStream fos = new FileOutputStream(className + ".class");
            fos.write(b);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterGenz(GenzParser.GenzContext ctx) {
        super.enterGenz(ctx);
        MethodVisitor visitor = cw.visitMethod(1, "main", "([Ljava/lang/String;)V", null, null);
        methodStack.push(visitor);
    }

    @Override
    public void exitGenz(GenzParser.GenzContext ctx) {
        super.exitGenz(ctx);
        MethodVisitor visitor = methodStack.pop();
        visitor.visitInsn(177);
        visitor.visitMaxs(0, 0);
        visitor.visitEnd();
    }




}
