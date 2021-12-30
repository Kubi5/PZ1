package pl.kubisF;
/**
 *  ReadingRoom is an interface which contain
 *  all actions which take place in ReadingRoom by readers and writers */
public interface ReadingRoom {
    public void startReading();
    public void endReading();
    public void startWriting();
    public void endWriting();
}
