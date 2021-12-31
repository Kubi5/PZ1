package pl.kubisF;

import org.junit.*;
import static org.junit.Assert.*;
/** This class simply testing Main class */
public class MainTest {
    Writer writer;
    Reader reader;
    ReadingRoom r;

    @Before
    public void setUp(){
        r = new Resource();
        writer = new Writer("Writer",r);
        reader = new Reader("Reader",r);
    }

    @Test
    public void shouldCreateMainObject(){
        Main main = new Main();
        assertNotNull("Main method called.", main);
    }

    @Test
    public void isMainWorks(){
        Main m = new Main();
        assertEquals("Writer", writer.getName());
        assertEquals("Reader", reader.getName());
    }

}
