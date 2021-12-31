package pl.kubisF;

import lombok.SneakyThrows;

import java.util.logging.Level;
import java.util.logging.Logger;
/** Reader class - it's a thread with reader's allowance to ReadingRoom */
public class Reader extends Thread{
    private final ReadingRoom r;
    private static final Logger LOGGER = Logger.getLogger( Reader.class.getName() );
    private final String wantsRead = String.format("--WANTS-- %s wants to read",this.getName());
    private final String reading =  String.format("--ACTION IN READING ROOM-- %s is reading",this.getName());
    private final String finishedReading = String.format("--END-- %s finished reading",this.getName());

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
            LOGGER.log(Level.INFO, wantsRead);
            r.startReading();
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, reading);
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, finishedReading);
            r.endReading();
            }

    }

}
