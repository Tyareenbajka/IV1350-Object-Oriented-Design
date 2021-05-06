package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;
import se.kth.iv1350.util.Amount;

/**
 * The application's only controller class. All calls to the model and integration pass through here.
 */
public class Controller {
    private Sale sale;
    private IntegrationCreator integration;
    private Inventory inventory;
    private SaleLog saleLog;
    private CashPayment payment;
    private ItemDTO item;
    private Receipt receipt;

    public Controller(IntegrationCreator integration) {
        this.integration = integration;
        this.inventory = integration.getInventory();
        this.saleLog = integration.getSaleLog();
    }

    /**
     * Initiates a new sale.
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    /**
     * Scans the product to be purchased, checks if it has already been scanned and adds it to the sale.
     * If it has already been scanned, increase quantity, otherwise, create the item
     *
     * @param identifier the identifier of the item to purchase
     * @return the item to purchase
     */
    public ItemDTO enterIdentifier(int identifier){
        boolean alreadyBeenScanned = sale.checkIfAlreadyInSale(identifier);
        item = inventory.retrieveInfo(identifier);
        sale.updateSale(alreadyBeenScanned, item);
        return item;
    }

    /**
     * End ongoing sale
     *
     * @return the total sum
     */
    public double endSale(){
        sale.endSale();
        return sale.getTotalPrice();
    }

    /**
     * Registers the customer's payment, logs inventory & accounting and creates the receipt
     *
     * @param amount customer's payment
     * @return the receipt for the sale
     */
    public String enterAmountPaidForSale(Amount amount){
        payment = sale.pay(amount);
        saleLog.logCompleteSale(sale, payment);
        receipt = sale.getReceipt(sale);
        return receipt.receiptToString();
    }

    /**
     * Prints the inventory
     *
     * @return data from the inventory
     */
    public String printInventory(){
        return inventory.printListOfInventory();
    }

    /**
     * Reports the accounting
     *
     * @return reports the accounting
     */
    public double getAccounting(){
        return saleLog.getAccounting();
    }
}
