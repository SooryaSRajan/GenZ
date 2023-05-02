import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void TestValidCode() throws IOException {
        Main.main(new String[]{"src/test/resources/valid-code.genz"});
        assertTrue(new File("src/test/resources/Validcode.class").exists());
    }

    @Test
    void TestInvalidCode() {
        try {
            Main.main(new String[]{"src/test/resources/invalid-code.genz"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertFalse(new File("src/test/resources/Invalidcode.class").exists());
    }

    @Test
    void TestInvalidFile() {
        try {
            Main.main(new String[]{"src/test/resources/invalid-file.notgenz"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertFalse(new File("src/test/resources/Invalidfile.class").exists());
    }

    @AfterAll
    static void removeClassFiles() {
        File dir = new File("src/test/resources/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.getName().endsWith(".class")) {
                    child.delete();
                }
            }
        }
    }


}