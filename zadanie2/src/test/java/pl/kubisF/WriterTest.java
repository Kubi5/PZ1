package pl.kubisF;
import org.junit.*;
import static org.junit.Assert.*;

public class WriterTest {
    private String test;
    private ReadingRoom readingRoom;
    @Before
    public void setUp(){
        readingRoom = new Resource();
        test = "Name test";
    }

    @Test
    public void isConstructorWorks(){
        Writer w = new Writer("Name test",readingRoom);
        assertEquals(w.getName(),test);
    }

    @Test
    public void testTime(){
        Writer w = new Writer("SIMEA",readingRoom);
        long startTime = System.nanoTime();
        w.start();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        assertTrue(timeElapsed/1000000 < 10000);
    }


}
