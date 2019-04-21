import org.apache.log4j.Logger;

public class Philosopher implements Runnable{
    private static final Logger log = Logger.getLogger(Philosopher.class);
    int id;
    Fork leftFork, rightFork;
    Thread thread;
    boolean haveEaten = false;
    Philosopher(int _id, Fork left, Fork right){
        leftFork = left;
        rightFork = right;
        thread = new Thread(this);
        id = _id;
        thread.start();
    }
    @Override
    public void run()
    {
        while(true) {
            if(forksIsFree()) {
                takeFork(true);
                eat();
                try {
                    thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error(null,e);
                }
                log.info("Философ "+(id+1)+" пообедал");
                haveEaten = true;
                takeFork(false);
                break;
            }else {
                continue;
            }
        }
    }

    void eat() {
        log.info("Философ "+(id+1)+" обедает");
    }

    synchronized void takeFork(boolean state) {
        leftFork.setState(state);
        rightFork.setState(state);
    }

    synchronized boolean forksIsFree() {
        if(leftFork.isTaken()==false && rightFork.isTaken()==false)
            return true;
        return false;
    }
}