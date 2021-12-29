package pl.kubisF;

import org.junit.*;
import static org.junit.Assert.*;

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
    public void isMainWorks(){
        Main m = new Main();
        assertEquals(writer.getName(),"Writer");
        assertEquals(reader.getName(),"Reader");
    }

}
