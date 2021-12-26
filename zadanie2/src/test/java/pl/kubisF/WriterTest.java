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


}
