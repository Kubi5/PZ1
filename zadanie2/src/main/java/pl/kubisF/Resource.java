package pl.kubisF;

public class Resource implements ReadingRoom{
private int writers_number;
private int readers_number;
private int writers_waiting;
private boolean is_writers_turn = false;

    synchronized public void startReading(){
        while(writers_number > 0 || (writers_waiting > 0 && is_writers_turn)){
            try{
                wait();
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
        is_writers_turn = true;
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
                e.printStackTrace();
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
