package pl.kubisF;


public class Main {
    public static void main(String []args) {
        ReadingRoom r = new Resource();

    for(int i = 0; i<3; i++){
        new Writer("Writer " + (i+1),r).start();
    }

    for(int i = 0; i<10; i++){
        new Reader("Reader " + (i+1),r).start();
    }
    }



}
