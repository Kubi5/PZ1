package pl.kubisF;

import lombok.SneakyThrows;

import java.util.logging.Level;
import java.util.logging.Logger;
/** Reader class - it's a thread with reader's allowance to ReadingRoom */
public class Reader extends Thread{
    private final ReadingRoom r;
    private static final Logger LOGGER = Logger.getLogger( Reader.class.getName() );

    Reader(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }
    @SneakyThrows
    @Override
    /** Reader's run method contain his logs in ReadingRoom */
    public void run(){
        while(true){
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--WANTS-- " + this.getName() + " wants to read");
            r.startReading();
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--ACTION IN READING ROOM-- " + this.getName() + " is reading");
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--END-- " + this.getName() + " ends reading");
            r.endReading();
            }

    }

}
