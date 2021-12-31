package pl.kubisF;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
/** This class simply testing Reader class */
public class ReaderTest {
    private String test;
    private ReadingRoom readingRoom;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        readingRoom = new Resource();
        test = "Name test";
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void isConstructorWorks(){
        Reader r = new Reader("Name test",readingRoom);
        assertEquals(r.getName(),test);
    }

    @Test
    public void testTime(){
        Reader reader = new Reader("SIMEA",readingRoom);
        long startTime = System.nanoTime();
        reader.start();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        assertTrue(timeElapsed/1000000 < 10000);
    }

    @Test
    public void StringsTest() {
        Reader reader = new Reader("SIMEA",readingRoom);
        reader.start();
        Assert.assertEquals("", outputStreamCaptor.toString().trim());

    }

    @Test
    public void isThreadSleeping() throws InterruptedException {
        Reader r = new Reader("SIMEA",readingRoom);
        r.start();
        assertEquals(Thread.State.RUNNABLE,r.getState());
    }



}