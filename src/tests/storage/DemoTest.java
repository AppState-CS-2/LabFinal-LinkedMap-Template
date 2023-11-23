package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import client.Demo;
import labtests.util.TestUtilities;

public class DemoTest
{
    private static final String prompt = "Enter a character from a-f to see "
        + "its entry, p to print the map, or q to quit.\n";
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;
    private InputStream oldIn;

    @BeforeEach
    public void beforeEach()
    {
        this.oldOut = System.out;
        this.oldIn = System.in;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }

    @Test
    public void test1()
    {
        String input = "q\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Demo.main(null);
        String output = TestUtilities.getOutput(baos);
        assertEquals(prompt, output);
    }

    @Test
    public void test2()
    {
        String input = "a\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Demo.main(null);
        String output = TestUtilities.getOutput(baos);
        assertEquals(prompt + "a is for abstract\n" + prompt, output);
    }

    @Test
    public void test3()
    {
        String input = "f\ne\na\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Demo.main(null);
        String output = TestUtilities.getOutput(baos);
        assertEquals(prompt + "f is for for\n" + prompt + "e is for enum\n"
            + prompt +"a is for abstract\n" + prompt, output);
    }

    @Test
    public void test4()
    {
        String input = "r\nr\nr\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Demo.main(null);
        String output = TestUtilities.getOutput(baos);
        assertEquals(prompt + prompt + prompt + prompt, output);
    }

    @Test
    public void test5()
    {
        String input = "b\nc\nd\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Demo.main(null);
        String output = TestUtilities.getOutput(baos);
        assertEquals(prompt + "b is for boolean\n"
            + prompt + "c is for class\n"
            + prompt + "d is for double\n" + prompt, output);
    }
}
