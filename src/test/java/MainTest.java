import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void TestValidCode() {
        try {
            Main.main(new String[]{"src/test/resources/ValidCode.genz"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(new File("src/test/resources/Validcode.class").exists());
    }

    @Test
    void TestInvalidCode() {
        try {
            Main.main(new String[]{"src/test/resources/InvalidCode.genz"});
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
        assertFalse(new File("src/test/resources/Invalidcode.class").exists());
    }

    @Test
    void TestInvalidFile() {
        try {
            Main.main(new String[]{"src/test/resources/InvalidFile.notgenz"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertFalse(new File("src/test/resources/Invalidfile.class").exists());
    }

    @Test
    void TextInvalidFileName() {
        try {
            Main.main(new String[]{"src/test/resources/invalid_FileName12.genz"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertFalse(new File("src/test/resources/Invalidfilename.class").exists());
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