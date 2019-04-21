import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        final Logger log = Logger.getLogger(Main.class);
        try {
            MainThread  mainThread = new MainThread(25);
            mainThread.сreatePhilosopher();
        }catch (AmoutPhilosopherException e){
           log.error("Ошибка ввода количества философов", e);
        }
    }
}