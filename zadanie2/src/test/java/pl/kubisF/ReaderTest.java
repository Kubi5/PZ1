package pl.kubisF;
import org.junit.*;
import static org.junit.Assert.*;

public class ReaderTest {
    private String test;
    private ReadingRoom readingRoom;

    @Before
    public void setUp(){
        readingRoom = new Resource();
        test = "Name test";
    }

    @Test
    public void isConstructorWorks(){
        Reader r = new Reader("Name test",readingRoom);
        assertEquals(r.getName(),test);
    }


}