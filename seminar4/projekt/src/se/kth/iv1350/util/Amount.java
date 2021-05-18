package se.kth.iv1350.util;

/**
 * Represent an amount of money
 */
public class Amount {

    private int amountInt;
    private double amountDouble;

    public Amount(int amountInt) {
        this.amountInt = amountInt;
    }

    public Amount(double amountDouble){
        this.amountDouble = amountDouble;
    }

    /**
     * Get the amount
     * @return the amount
     */
    public int getAmountPaid(){
        return amountInt;
    }

}
