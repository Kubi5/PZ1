package pl.kubisF;
import org.junit.*;
import static org.junit.Assert.*;

public class ResourceTest {
    Resource resource = new Resource();

    @Test
    public void isStartReadingWorks(){
        resource.readers_number = 0;
        resource.startReading();
        assertEquals(resource.readers_number, 1);
    }

    @Test
    public void isStartWritingWorks(){
        resource.writers_waiting = 0;
        resource.writers_number = 0;
        resource.startWriting();
        assertEquals(resource.writers_number, 1);
        assertEquals(resource.writers_waiting, 0);
    }

    @Test
    public void isEndReadingWorks(){
        resource.readers_number = 1;
        resource.endReading();
        assertEquals(resource.readers_number, 0);
    }

    @Test
    public void isEndWritingWorks(){
        resource.writers_number = 1;
        resource.endWriting();
        assertEquals(resource.writers_number, 0);
    }


}
