package se.kth.iv1350.integration;

/**
 * A listener interface for receiving notifications about report revenue
 */
public interface RevenueObserver {

    /**
     * Invoked when a sale has been booked
     *
     * @param amount the amount to be booked
     */
    void newPayment(double amount);
}
