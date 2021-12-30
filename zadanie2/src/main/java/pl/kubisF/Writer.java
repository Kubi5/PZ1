package pl.kubisF;


import lombok.SneakyThrows;

import java.util.logging.Level;
import java.util.logging.Logger;
/** Writer class - it's a thread with writer's allowance to ReadingRoom */
public class Writer extends Thread{
    private final ReadingRoom r;
    private static final Logger LOGGER = Logger.getLogger( Writer.class.getName() );

    Writer(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }
    @SneakyThrows
    @Override
    /** Writer's run method contain his logs in ReadingRoom */
    public void run(){
        while(true){
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--WANTS-- " + this.getName() + " wants to write");
            r.startWriting();
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--ACTION IN READING ROOM-- " + this.getName() + " is writing");
            Thread.sleep(4000);
            LOGGER.log(Level.INFO, "--END-- " + this.getName() + " ends writing");
            r.endWriting();
        }
    }


}
