package pl.kubisF;


public class Writer extends Thread{
    private ReadingRoom r;
    private String name;

    Writer(String name, ReadingRoom r){
        super(name);
        this.r = r;
    }

    public void run(){
        while(true) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                   // Thread.currentThread().interrupt();
                }
                System.out.println("--WANTS-- " +this.getName() + " wants to write");
                r.startWriting();
                try {
                    System.out.println("--ACTION IN READING ROOM-- " + this.getName() + " is writing");
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                   // Thread.currentThread().interrupt();
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                   // Thread.currentThread().interrupt();
                }
                System.out.println("--END-- " + this.getName() + " ends writing");
                r.endWriting();
        }
    }
}
