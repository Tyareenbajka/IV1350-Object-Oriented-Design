package se.kth.iv1350.integration;

import se.kth.iv1350.model.CashPayment;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the store's accounting
 */
public class Accounting {
    private double account = 0;
    private List<RevenueObserver> revenueObserverList = new ArrayList<>();

    /**
     * Updates the accounting and notifying the observers
     *
     * @param payment object of the payment class
     */
    public void updateSalesReport(CashPayment payment){
        account = account + payment.getAmountToAccounting();
        notifyObservers(account);
    }

    private void notifyObservers(Double amount){
        for(RevenueObserver obs : revenueObserverList){
            obs.newPayment(amount);
        }
    }

    /**
     * Adding the observer to the list of observers
     *
     * @param observers the observer to add to the list
     */
    public void addRevenueObserver(RevenueObserver observers){
        revenueObserverList.add(observers);
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
