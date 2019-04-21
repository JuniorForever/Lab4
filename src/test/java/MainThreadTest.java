import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainThreadTest {
    private static final Logger log = Logger.getLogger(MainThread.class);
    @Test
    public void сreatePhilosopher() throws AmoutPhilosopherException {
        try {
            MainThread mainThread = new MainThread(1);
            mainThread.сreatePhilosopher();
            try {
                mainThread.philosopherList.get(0).thread.join();
            } catch (InterruptedException e) {
                log.error(null,e);
            }
            boolean expected = mainThread.philosopherList.get(0).haveEaten;
            boolean actual = true;
            assertEquals(expected,actual);
        }catch (AmoutPhilosopherException e){
            log.error(null,e);
        }
    }
}