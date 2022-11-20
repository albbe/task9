import javax.sound.sampled.SourceDataLine;

/**
 * The Calculator class represents a very basic calculator
 * supporting addition, subtraction, multiplication and division
 *
 * @author Gabriel Skoglund
 */
public class Calculator {
    private double value = 0;

    /**
     * @return the current value stored by the calculator
     */
    public double getValue() {
        return value;
    }

    /**
     * Reset the value of the calculator to zero
     */
    public void reset() {
        value = 0;
    }

    /**
     * Add to the stored value
     * @param summand the number to add
     * @return the current stored value after the addition
     */
    public double add(double summand) {
        value += summand;
        return value;
    }

    /**
     * Subtract from the stored value
     * @param subtrahend the number to subtract
     * @return the current stored value after the subtraction
     */
    public double subtract(double subtrahend) {
        value -= subtrahend;
        return value;
    }

    /**
     * Multiply the stored value with the given factor
     * @param factor the number to multiply by
     * @return the current stored value after the multiplication
     */
    public double multiply(double factor) {
        value *= factor;
        return value;
    }

    /**
     * Divide the currently stored value by the given number
     * @param divisor the number to divide by
     * @return the current stored value after the division
     */
    public double divide(double divisor) {
        if (divisor == 0){
        throw new IllegalArgumentException("Argument 'divisor' is 0");}
        value /= divisor;
        return value;
    }

    /**
     * Inverse the currently stored value by the given number
     * @param reciprocal the number to inverse
     * @return the current stored value after the inversion
     */
    public double inverse(double reciprocal){
        if (reciprocal == 0){
            throw new IllegalArgumentException("Argument 'inverter' is 0");}
            value = Math.pow(reciprocal, -1);
            return value;
        }
    }

