package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.util.Amount;
import java.util.ArrayList;
import java.util.List;

/**
 * Representing the current sale
 */
public class Sale {
    private Receipt receipt;
    private CashPayment cashPayment;
    private double totalPrice = 0;
    private double totalVatRate = 0;
    private double change;
    private double amountToAccounting;
    private int customerPaid;
    public List<ItemDTO> itemsInSale = new ArrayList<>();

    public Sale(){
        receipt = new Receipt();
    }

    /**
     * Updates the sale with the given item
     *
     * @param alreadyBeenScanned <code>true</code> if the item already been scanned,
     *                           otherwise <code>false</code>
     * @param item the item to add to the sale
     */
    public void updateSale(boolean alreadyBeenScanned, ItemDTO item){
        if(alreadyBeenScanned){
            increaseQuantityOfItem(item);
        }
        else{
            itemsInSale.add(item);
        }
        addToTotalPrice(item.getPrice());
        addToTotalVatRate(item.getVatRate());
    }

    private void increaseQuantityOfItem(ItemDTO item){
        for(ItemDTO increaseItem : itemsInSale){
            if(item.getIdentifier() == increaseItem.getIdentifier())
                increaseItem.increaseQuantity();
        }
    }

    /**
     * Checks if the given identifier already been added to the sale
     *
     * @param identifier the given identifier of the item
     * @return <code>true</code> if the item already been added,
     *         otherwise <code>false</code>
     */
    public boolean checkIfAlreadyInSale(int identifier){
        for(ItemDTO eachItem : itemsInSale){
            if (theIdentifierAlreadyBeenScanned(identifier, eachItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean theIdentifierAlreadyBeenScanned(int identifier, ItemDTO eachItem){
        return identifier == eachItem.getIdentifier();
    }

    private void addToTotalVatRate(double vatRate) {
        totalVatRate = totalVatRate + vatRate;
    }
    private void addToTotalPrice(double price) {
        totalPrice = totalPrice + price;
    }

    /**
     * Adding the current sale to the receipt after ending the sale
     */
    public void endSale(){
        receipt.addToReceipt(this);
    }

    /**
     * Receives the customer's payment and calculates any change and amount to accounting
     *
     * @param amount the amount customer paid
     * @return instance of payment consisting <code>amount</code>, change and amount to accounting
     */
    public CashPayment pay(Amount amount){
        customerPaid = amount.getAmountPaid();
        calculateChange(amount);
        calculateAmountToAccounting(amount);
        cashPayment = new CashPayment(amount, change, amountToAccounting);
        return cashPayment;
    }

    private void calculateChange(Amount amount) {
        this.change = amount.getAmountPaid() - totalPrice;
    }

    private void calculateAmountToAccounting(Amount amount) {
        this.amountToAccounting = amount.getAmountPaid() - change;
    }

    /**
     * Get the receipt of the current sale
     *
     * @param sale the current sale
     */
    public Receipt getReceipt(Sale sale){
        receipt.generateReceipt(sale);
        return receipt;
    }

    /**
     * Get the change
     *
     * @return the change
     */
    public double getChange(){
        return change;
    }

    /**
     * Get the total sum of the current sale
     *
     * @return the total sum
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * Get the total VAT rate of the current sale
     *
     * @return the total VAT rate
     */
    public double getTotalVatRate(){
        return totalVatRate;
    }

    /**
     * Get the amount customer paid
     *
     * @return amount customer paid
     */
    public int getCustomerPaid(){
        return customerPaid;
    }





}
