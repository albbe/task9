import java.util.Arrays;

/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author Simon Larsén
 * @author Alberto Bergqvist
 */
public class Sieve {
    boolean[] primeCache;

    /**
     * Check that the entered number is one that this calculator can handle
     * @param number An integer value to be checked so that it meets the criteria for this calculator
     * If the numbers to big or small this method will cast an Illegal argument exceptoin
     */
    private void exceptionIfIllegalArg(int number){
        final Integer maxValue = (int) Math.pow(2, 26);
        if (number < 2){
            throw new IllegalArgumentException("There are no prime numbers less then 2. A prime number is a natural number greater than 1 that is not a product of two smaller natural numbers.");
        }
        if (number > maxValue){
            throw new IllegalArgumentException("The number is too big for this calculator, choos a number less or equal to 2^26");
        }
    }

    /**
     * A method performing the Sieve-algorithm
     * @param number
     * @return an array
     */
    private boolean[] sieve(int number){
        boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // Assume all numbers are prime
        int sqrt = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i]) {
                for (int j = i*2; j < prime.length; j += i) {
                    prime[j] = false; // Mark multiples of i as not prime
                }
            }   
        }
        return prime;
    }

    /**
     * Check if a number is prime or not!
     * @param   number  An integer value to be checked for primality.
     * @return  true if number is prime, false otherwise.
     */
    public boolean isPrime(int number) {
        exceptionIfIllegalArg(number);
        boolean[] prime = sieve(number);
        return prime[number];
    }

    
}