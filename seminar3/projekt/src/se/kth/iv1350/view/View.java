package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.util.Amount;
import se.kth.iv1350.util.Font;

/**
 * This program has no view, instead this class is a placeholder for the entire view.
 */
public class View {
    private Controller contr;
    private ItemDTO itemToPurchase;
    private String receipt;
    private double totalPrice;


    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates a sales process that is used for all operations.
     */
    public void sampleExecution(){
        System.out.println("Starting a new sale!" + Font.NEW_LINE);
        contr.startNewSale();

        System.out.println("Items to purchase: " + Font.NEW_LINE);
        itemsToPurchase();
        System.out.print(Font.NEW_LINE + "Ending sale and get the total sum:");
        totalPrice = contr.endSale();
        printTotalPrice(totalPrice);

        System.out.print("Customer pays cash and receives the receipt: " + Font.NEW_LINE);
        Amount customerPaid = new Amount(1500);
        receipt = contr.enterAmountPaidForSale(customerPaid);
        printReceipt(receipt);

        //Checking the inventory
        String printInventory = contr.printInventory();
        printInventory(printInventory);

        //Checking accounting
        double checkTheAccounts = contr.getAccounting();
        printAccounting(checkTheAccounts);
    }

    private void printTotalPrice(double totalPrice) {
        System.out.println(Font.NEW_LINE + "Total sum: " + totalPrice + Font.KR + Font.NEW_LINE);
    }

    private void printReceipt(String receipt) {
        System.out.print("***** RECEIPT *****" + Font.NEW_LINEx2);
        System.out.println(receipt);
        System.out.print("***** END OF RECEIPT *****" + Font.NEW_LINE);
    }


    private void showOnDisplay(ItemDTO item){
        System.out.println(item.getItem() + Font.SPACE + item.getPrice() + Font.KR);
    }

    private void itemsToPurchase(){
        itemToPurchase = contr.enterIdentifier(9976);
        showOnDisplay(itemToPurchase);
        itemToPurchase = contr.enterIdentifier(6532);
        showOnDisplay(itemToPurchase);
        itemToPurchase = contr.enterIdentifier(9976);
        showOnDisplay(itemToPurchase);
    }

    private void printAccounting(double checkTheAccounts){
        System.out.println("**** CHECK THE ACCOUNTING! ****");
        System.out.println("Accounting: " + checkTheAccounts);
    }

    private void printInventory(String printInventory){
        System.out.println(Font.NEW_LINE + "**** INVENTORY CHECK! ****");
        System.out.println(printInventory);
    }
}
