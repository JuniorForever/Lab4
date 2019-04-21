import org.junit.Test;

public class AmoutPhilosopherExceptionTest{
    @Test(expected = AmoutPhilosopherException.class)
    public void amoutPhilosopherExceptionTest() throws AmoutPhilosopherException{
            MainThread mainThread = new MainThread(-2);
    }
}