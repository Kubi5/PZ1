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
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + " wants to read");
                r.startReading();
                try {
                    System.out.println(this.getName() + " is reading");
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " ends reading");
                r.endReading();
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
