import com.heartofthestone.gtm.Grep;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GrepTest {

    @Test
    void test1() throws IOException{
        String[] command = "мама .\\src\\test\\resources\\Files\\input1.txt".split(" ");

        PrintStream old = System.out;
        PrintStream toFile = new PrintStream(new File(".\\src\\test\\resources\\FilesOutput\\output1.txt"));
        System.setOut(toFile);
        Grep.main(command);
        System.out.flush();
        System.setOut(old);

        File file1 = new File(".\\src\\test\\resources\\FilesOutput\\output1.txt");
        File file2 = new File(".\\src\\test\\resources\\ExpectedOutput\\expected1.txt");

        assertTrue(FileUtils.contentEquals(file1,file2));
    }
    @Test
    void test2() throws IOException{
        String[] command = "жди -v -i .\\src\\test\\resources\\Files\\input2.txt".split(" ");

        PrintStream old = System.out;
        PrintStream toFile = new PrintStream(new File(".\\src\\test\\resources\\FilesOutput\\output2.txt"));
        System.setOut(toFile);
        Grep.main(command);
        System.out.flush();
        System.setOut(old);

        File file1 = new File(".\\src\\test\\resources\\FilesOutput\\output2.txt");
        File file2 = new File(".\\src\\test\\resources\\ExpectedOutput\\expected2.txt");

        assertTrue(FileUtils.contentEquals(file1,file2));
    }
    @Test
    void test3() throws IOException{
        String[] command = "^[a-z]+\\d -r -v .\\src\\test\\resources\\Files\\input3.txt".split(" ");
        PrintStream old = System.out;
        PrintStream toFile = new PrintStream(new File(".\\src\\test\\resources\\FilesOutput\\output3.txt"));
        System.setOut(toFile);
        Grep.main(command);
        System.out.flush();
        System.setOut(old);

        File file1 = new File(".\\src\\test\\resources\\FilesOutput\\output3.txt");
        File file2 = new File(".\\src\\test\\resources\\ExpectedOutput\\expected3.txt");

        assertTrue(FileUtils.contentEquals(file1,file2));
    }
}