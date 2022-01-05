package pl.kubisF;

import org.junit.*;
import static org.junit.Assert.*;
/** This class simply testing ReadingRoom class */
public class ReadingRoomTest {
    Resource resource = new Resource();

    @Test
    public void isStartReadingWorks(){
        resource.readersnumber = 0;
        resource.startReading();
        assertEquals(1,resource.readersnumber);
    }

    @Test
    public void isStartWritingWorks(){
        resource.writerswaiting = 0;
        resource.writersnumber = 0;
        resource.startWriting();
        assertEquals(1,resource.writersnumber);
        assertEquals(0,resource.writerswaiting);
    }

    @Test
    public void isEndReadingWorks(){
        resource.readersnumber = 1;
        resource.endReading();
        assertEquals(0, resource.readersnumber);
    }

    @Test
    public void isEndWritingWorks(){
        resource.writersnumber = 1;
        resource.endWriting();
        assertEquals(0, resource.writersnumber);
    }
}
