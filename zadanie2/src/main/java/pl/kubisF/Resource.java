package pl.kubisF;

import lombok.SneakyThrows;

import java.security.SecureRandom;

/** Resource is a class which implements ReadingRoom interface and have all attributes which
 * are necessary in algorithm which handle all the rules in ReadingRoom - in one moment
 * in ReadingRoom can be only one writer or up to 5 readers.
  */
public class Resource implements ReadingRoom{
public int writers_number;
public int readers_number;
public int writers_waiting;
private boolean is_writers_turn = true;
SecureRandom random = new SecureRandom();

    @SneakyThrows
    /** This method have a logic when is possible to reader to read and etc. */
    public synchronized void startReading(){
        while(writers_number > 0 || (writers_waiting > 0 && is_writers_turn) || readers_number == 5){
                wait();
        }
        int value = random.nextInt(3);
        if(value == 0) {
            is_writers_turn = true;
        }
        readers_number++;
    }

    /** This method simply decrease the number of readers in ReadingRoom */
    public synchronized void endReading(){
        readers_number--;
        notifyAll();
    }

    @SneakyThrows
    /** This method have a logic when is possible to writer to write and etc. */
    public synchronized void startWriting(){
        writers_waiting++;
        while(readers_number > 0 || writers_number > 0){
                wait();
        }
        writers_waiting--;
        writers_number++;
    }
    /** This method simply decrease the number of writers in ReadingRoom
     * and changing flag is_writers_turn */
    public synchronized void endWriting(){
        is_writers_turn = false;
        writers_number--;
        notifyAll();
    }

}
