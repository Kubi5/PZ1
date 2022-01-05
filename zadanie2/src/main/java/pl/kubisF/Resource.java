package pl.kubisF;
import lombok.SneakyThrows;
import java.security.SecureRandom;


/** Resource is a class which implements ReadingRoom interface and have all attributes which
 * are necessary in algorithm which handle all the rules in ReadingRoom - in one moment
 * in ReadingRoom can be only one writer or up to 5 readers.
  */
public class Resource implements ReadingRoom{
public static int writersnumber;
public static int readersnumber;
public static int writerswaiting;
public static int readerswaiting;
private boolean iswritersturn = true;
SecureRandom random = new SecureRandom();

    @SneakyThrows
    /** This method have a logic when is possible to reader to read and etc. */
    public synchronized void startReading(){
        readerswaiting++;
        while(writersnumber > 0 || (writerswaiting > 0 && iswritersturn) || readersnumber == 5){
                wait();
        }
        int value = random.nextInt(3);
        if(value == 0) {
            iswritersturn = true;
        }
        readerswaiting--;
        readersnumber++;
    }

    /** This method simply decrease the number of readers in ReadingRoom */
    public synchronized void endReading(){
        readersnumber--;
        notifyAll();
    }

    @SneakyThrows
    /** This method have a logic when is possible to writer to write and etc. */
    public synchronized void startWriting(){
        writerswaiting++;
        while(readersnumber > 0 || writersnumber > 0){
                wait();
        }
        writerswaiting--;
        writersnumber++;
    }
    /** This method simply decrease the number of writers in ReadingRoom
     * and changing flag iswritersturn */
    public synchronized void endWriting(){
        iswritersturn = false;
        writersnumber--;
        notifyAll();
    }

}
