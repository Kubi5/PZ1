package pl.kubisF;
import lombok.SneakyThrows;
import java.util.logging.Logger;

public class Display extends Thread{
    private static final Logger LOGGER = Logger.getLogger( Display.class.getName() );

    @SneakyThrows
    @Override
    public void run(){
        while(true) {
            sleep(6000);
            LOGGER.info(String.format("INFO:------CURRENTlY THERE ARE/IS %d writer and %d readers in reading room------", Resource.writersnumber, Resource.readersnumber));
            LOGGER.info(String.format("INFO:------%d writers and %d readers are waiting for their turn in queue------", Resource.writerswaiting, Resource.readerswaiting));
        }
    }
}
