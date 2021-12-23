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
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + " wants to write");
                r.startWriting();
                try {
                    System.out.println(this.getName() + " is writing");
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " ends writing");
                r.endWriting();
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
