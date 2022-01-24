package org.example;

import static junit.framework.TestCase.assertNotNull;
import org.junit.Test;

public class MainTest {
    @Test
    public void shouldCreateMainObject(){
        Main main = new Main();
        assertNotNull("Main method called", main);
    }
}
