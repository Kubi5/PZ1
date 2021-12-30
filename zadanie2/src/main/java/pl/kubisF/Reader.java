package pl.kubisF;

import lombok.SneakyThrows;

public class Reader extends Thread{
    private final ReadingRoom r;

    Reader(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }
    @SneakyThrows
    @Override
    public void run(){
        while(true) {
            Thread.sleep(4000);
            System.out.println("--WANTS-- " + this.getName() + " wants to read");
            r.startReading();
            Thread.sleep(4000);
            System.out.println("--ACTION IN READING ROOM-- " + this.getName() + " is reading");
            Thread.sleep(4000);System.out.println("--END-- " + this.getName() + " ends reading");
            r.endReading();
            }

    }

}
