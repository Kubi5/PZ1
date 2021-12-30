package pl.kubisF;

import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.Random;

public class Resource implements ReadingRoom{
public int writers_number;
public int readers_number;
public int writers_waiting;
private boolean is_writers_turn = true;
SecureRandom random = new SecureRandom();

    @SneakyThrows
    synchronized public void startReading(){
        while(writers_number > 0 || (writers_waiting > 0 && is_writers_turn) || readers_number == 5){
                wait();
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

    @SneakyThrows
    synchronized public void startWriting(){
        writers_waiting++;
        while(readers_number > 0 || writers_number > 0){
                wait();
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
