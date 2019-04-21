
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class MainThread {
  private int amountPhilosopher, count;
    ArrayList<Philosopher> philosopherList = new ArrayList<Philosopher>();
    ArrayList<Fork> forkList = new ArrayList<Fork>();
    private static final Logger log = Logger.getLogger(MainThread.class);

    public MainThread(int amount) throws AmoutPhilosopherException {
        if(amount<=0)
            throw new AmoutPhilosopherException(null);
        count = 0;
        amountPhilosopher = amount;
        for(int i=0; i<amountPhilosopher; i++) {
            forkList.add(new Fork());
        }
    }

    public void сreatePhilosopher() {
        int i = 0;
        for(; i<amountPhilosopher; i++) {
            if(i != amountPhilosopher-1) {
                philosopherList.add(new Philosopher(i,forkList.get(i),forkList.get(i+1)));
            }else {
                philosopherList.add(new Philosopher(i,forkList.get(i),forkList.get(0)));
            }
            log.info("Философ добавлен "+(i+1));
        }

        for(i=0; i<amountPhilosopher; i++) {
            try {
                philosopherList.get(i).thread.join();
            } catch (InterruptedException e) {
                log.error(null,e);
            }
        }
        log.info("Философы пообедали");
    }
}