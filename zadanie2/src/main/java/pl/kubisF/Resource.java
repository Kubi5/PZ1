package pl.kubisF;

import java.security.SecureRandom;
import java.util.Random;

public class Resource implements ReadingRoom{
public int writers_number;
public int readers_number;
public int writers_waiting;
private boolean is_writers_turn = true;
SecureRandom random = new SecureRandom();

    synchronized public void startReading(){
        while(writers_number > 0 || (writers_waiting > 0 && is_writers_turn) || readers_number == 5){
            try{
                wait();
            } catch (InterruptedException e) {
               // Thread.currentThread().interrupt();
            }
        }

        int value = random.nextInt(3);
        if(value == 0) {
            is_writers_turn = true;
        }
        readers_number++;

    }

    synchronized  public void endReading(){
        readers_number--;
        notifyAll();
    }

    synchronized public void startWriting(){
        writers_waiting++;
        while(readers_number > 0 || writers_number > 0){
            try{
                wait();
            } catch (InterruptedException e) {
                //Thread.currentThread().interrupt();
            }
        }
        writers_waiting--;
        writers_number++;
    }

    synchronized public void endWriting(){
        is_writers_turn = false;
        writers_number--;
        notifyAll();
    }

}
