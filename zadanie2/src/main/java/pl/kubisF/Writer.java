package pl.kubisF;


import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/** Writer class - it's a thread with writer's allowance to ReadingRoom */
public class Writer extends Thread{
    private final ReadingRoom r;
    private static final Logger LOGGER = Logger.getLogger( Writer.class.getName() );
    private final String wantsWrite = String.format("--WANTS-- %s wants to write",this.getName());
    private final String writing =  String.format("--ACTION IN READING ROOM-- %s is writing",this.getName());
    private final String finishedWriting = String.format("--END-- %s finished writing",this.getName());
    SecureRandom random = new SecureRandom();

    Writer(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }
    @SneakyThrows
    @Override
    /** Writer's run method contain his logs in ReadingRoom */
    public void run(){
        while(true){
            Thread.sleep(5000);
            LOGGER.log(Level.INFO, wantsWrite);
            r.startWriting();
            Thread.sleep((random.nextInt(2)+1)*(long)1000);
            LOGGER.log(Level.INFO, writing);
            Thread.sleep(5000);
            LOGGER.log(Level.INFO, finishedWriting);
            r.endWriting();
        }
    }


}
