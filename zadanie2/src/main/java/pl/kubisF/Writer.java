package pl.kubisF;


import lombok.SneakyThrows;

public class Writer extends Thread{
    private ReadingRoom r;

    Writer(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }
    @SneakyThrows
    @Override
    public void run(){
        while(true){
            Thread.sleep(4000);
            System.out.println("--WANTS-- " +this.getName() + " wants to write");
            r.startWriting();
            Thread.sleep(4000);
            System.out.println("--ACTION IN READING ROOM-- " + this.getName() + " is writing");
            Thread.sleep(4000);System.out.println("--END-- " + this.getName() + " ends writing");
            r.endWriting();
        }
    }
}
