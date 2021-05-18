package se.kth.iv1350.model;

import se.kth.iv1350.util.Amount;

/**
 * Contains information about the payment for the current sale
 */
public class CashPayment {
    private Amount customerPay;
    private double change;
    private double amountToAccounting;

    /**
     * Creates a new instance representing a particular payment
     *
     * @param amount the amount customer paid
     * @param change the change
     * @param amountToAccounting the amount to report for accounting
     */
    public CashPayment(Amount amount, double change, double amountToAccounting) {
        this.customerPay = amount;
        this.change = change;
        this.amountToAccounting = amountToAccounting;
    }

    /**
     * Get the value of accounting
     *
     * @return the value of accounting
     */
    public double getAmountToAccounting(){
        return amountToAccounting;
    }
}
