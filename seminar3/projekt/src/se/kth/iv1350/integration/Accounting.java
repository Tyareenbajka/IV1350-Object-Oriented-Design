package se.kth.iv1350.integration;

import se.kth.iv1350.model.CashPayment;

/**
 * Contains the store's accounting
 */
public class Accounting {
    private double account = 0;

    /**
     * Updates the accounting
     *
     * @param payment object of the payment class
     */
    public void updateSalesReport(CashPayment payment){
        account = account + payment.getAmountToAccounting();
    }

    /**
     * Get the value of accounting
     *
     * @return the value of accounting
     */
    public double getAccounting(){

        return account;
    }
}
