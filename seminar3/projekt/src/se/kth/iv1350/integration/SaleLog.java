package se.kth.iv1350.integration;

import se.kth.iv1350.model.CashPayment;
import se.kth.iv1350.model.Sale;

/**
 * Responsible for updating accounting and inventory after a complete sale
 */
public class SaleLog {
    private Accounting accounting;
    private Inventory inventory;

    public SaleLog(Inventory inventory) {
        accounting =  new Accounting();
        this.inventory = inventory;
    }

    /**
     * Updating inventory & accounting after a complete sale
     *
     * @param sale the current sale
     * @param payment payment of the current sale
     */
    public void logCompleteSale(Sale sale, CashPayment payment){
        inventory.updateInventory(sale);
        accounting.updateSalesReport(payment);
    }

    /**
     * Get the value of accounting
     *
     * @return the value of accounting
     */
    public double getAccounting(){
        return accounting.getAccounting();
    }


}
