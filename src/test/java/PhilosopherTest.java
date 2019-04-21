import org.junit.Test;

import static org.junit.Assert.*;

public class PhilosopherTest {
    Fork left = new Fork();
    Fork right = new Fork();
    Philosopher philosopher = new Philosopher(2, left, right);

    @Test
    public void run() {
        philosopher.run();
       boolean actual =  philosopher.haveEaten;
       boolean expected = true;
       assertEquals(expected,actual);
       actual = philosopher.leftFork.isTaken();
       expected=false;
       assertEquals(expected,actual);
        actual = philosopher.rightFork.isTaken();
        expected=false;
        assertEquals(expected,actual);
    }

    @Test
    public void takeFork() {
        philosopher.takeFork(true);
        boolean expected = true;
        boolean actual = philosopher.leftFork.isTaken();
        assertEquals(expected, actual);
        actual = philosopher.rightFork.isTaken();
        assertEquals(expected, actual);
    }

    @Test
    public void forksIsFree() {
        left.setState(false);
        right.setState(false);
        boolean actual = philosopher.forksIsFree();
        boolean expected = true;
        assertEquals(expected, actual);
    }
}