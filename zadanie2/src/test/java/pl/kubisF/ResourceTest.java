package pl.kubisF;
import org.junit.*;
import static org.junit.Assert.*;

public class ResourceTest {
    Resource resource = new Resource();

    @Test
    public void isStartReadingWorks(){
        resource.readers_number = 0;
        resource.startReading();
        assertEquals(1,resource.readers_number);
    }

    @Test
    public void isStartWritingWorks(){
        resource.writers_waiting = 0;
        resource.writers_number = 0;
        resource.startWriting();
        assertEquals(1,resource.writers_number);
        assertEquals(0,resource.writers_waiting);
    }

    @Test
    public void isEndReadingWorks(){
        resource.readers_number = 1;
        resource.endReading();
        assertEquals(0, resource.readers_number);
    }

    @Test
    public void isEndWritingWorks(){
        resource.writers_number = 1;
        resource.endWriting();
        assertEquals(0, resource.writers_number);
    }


}
