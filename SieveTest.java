import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Sieve class.
 *
 * @author Tobias Hansson
 * @author Alberto Bergqvist
 */
public class SieveTest {
    private Sieve sieve;

    @Before
    public void setUp() {
        sieve = new Sieve();
    }

    @Test
    public void isPrimeTrueWhenNumberIsTwo() {
        assertTrue(sieve.isPrime(2));
    }

    @Test
    public void isPrimeTrueWhenNumberIsPrime() {
        boolean threeIsPrime = sieve.isPrime(3);
        boolean ninetySevenIsPrime = sieve.isPrime(97);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean fiveIsPrime = sieve.isPrime(5);

        assertTrue(threeIsPrime);
        assertTrue(ninetySevenIsPrime);
        assertTrue(sevenIsPrime);
        assertTrue(fiveIsPrime);
    }

    @Test
    public void isPrimeFalseWhenNumberIsComposite() {
        boolean fourIsPrime = sieve.isPrime(4);
        boolean nineHundredThreeIsPrime = sieve.isPrime(903);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean thirtyFiveIsPrime = sieve.isPrime(35);

        assertFalse(fourIsPrime);
        assertFalse(nineHundredThreeIsPrime);
        assertFalse(sixIsPrime);
        assertFalse(thirtyFiveIsPrime);
    }

    @Test
    public void isPrimeWorksWhenPassedIncrementingValues() {
        boolean twoIsPrime = sieve.isPrime(2);
        boolean threeIsPrime = sieve.isPrime(3);
        boolean fourIsPrime = sieve.isPrime(4);
        boolean fiveIsPrime = sieve.isPrime(5);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean eightIsPrime = sieve.isPrime(8);
        boolean nineIsPrime = sieve.isPrime(9);

        assertTrue(twoIsPrime);
        assertTrue(threeIsPrime);
        assertFalse(fourIsPrime);
        assertTrue(fiveIsPrime);
        assertFalse(sixIsPrime);
        assertTrue(sevenIsPrime);
        assertFalse(eightIsPrime);
        assertFalse(nineIsPrime);
    }

    @Test (expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsOne(){
        sieve.isPrime(1);
    }
    @Test (expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsMinusTen(){
        sieve.isPrime(-10);
    }

    @Test
    public void isPrimeFalseWhenNumberIs2Pow26() {
        int twoPow26 = (int) Math.pow(2, 26);
    boolean twoPow26IsPrime = sieve.isPrime(twoPow26);
    assertFalse(twoPow26IsPrime);
    }

    @Test (expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow26Plus1(){
        int twoPow26Plus1 = (int) Math.pow(2, (26 + 1));
        sieve.isPrime(twoPow26Plus1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow28(){
        int twoPow28 = (int) Math.pow(2, 28);
        sieve.isPrime(twoPow28);
    }
}
