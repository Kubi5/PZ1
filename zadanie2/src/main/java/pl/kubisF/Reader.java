package pl.kubisF;

public class Reader extends Thread{
    private final ReadingRoom r;
    private String name;

    Reader(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }

    public void run(){
        while(true) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--WANTS-- " + this.getName() + " wants to read");
                r.startReading();
                try {
                    System.out.println("--ACTION IN READING ROOM-- " + this.getName() + " is reading");
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--END-- " + this.getName() + " ends reading");
                r.endReading();
            }

    }

}
