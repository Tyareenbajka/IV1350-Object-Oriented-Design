package se.kth.iv1350.view;

import se.kth.iv1350.integration.RevenueObserver;

/**
 * Shows total revenue to user interface
 */
public class TotalRevenueView implements RevenueObserver {

    @Override
    public void newPayment(double amount) {
        showTotalRevenue(amount);
    }

    private void showTotalRevenue(double amount){
        System.out.println("Total revenue: " + amount);
    }
}
