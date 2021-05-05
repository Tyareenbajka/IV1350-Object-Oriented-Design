package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.util.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents the receipt of a sale.
 */
public class Receipt {
    private StringBuilder theReceipt = new StringBuilder();
    private Sale sale;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date = new Date();
    private final String storeName = "POS Livs ItemShop" + Font.NEW_LINE;
    private final String storeAdress = "Sweaty Sands 45, 999 99 Polar Peak" + Font.NEW_LINE;


    /**
     * Adds the sale to the receipt
     *
     * @param sale the current sale
     */
    public void addToReceipt(Sale sale){
        this.sale = sale;
    }

    /**
     * Generate the receipt of the current sale
     *
     * @param sale the current sale
     * @return the receipt
     */
    public void generateReceipt(Sale sale){
        theReceipt.append(storeInformation());
        theReceipt.append(dateAndTime() + Font.NEW_LINE);
        theReceipt.append(Font.NEW_LINE);
        theReceipt.append(Font.dashedBreakLine);

        theReceipt.append(printItemsInSale(sale));
        theReceipt.append(Font.dashedBreakLine);
        theReceipt.append(Font.NEW_LINE);

        theReceipt.append(printTotalSumAndTotalVat());
        theReceipt.append(Font.NEW_LINE);
        theReceipt.append(customerPaidAndChange() + Font.NEW_LINE);
        theReceipt.append(changeToCustomer() + Font.NEW_LINE);
        theReceipt.append(Font.dashedBreakLine);
    }

    /**
     * Get the receipt of the current sale
     *
     * @return the receipt
     */
    public String receiptToString(){
        return theReceipt.toString();
    }

    private String changeToCustomer() {
        return ("Change: " + sale.getChange());
    }

    private String customerPaidAndChange(){
        return ("Paid: " + sale.getCustomerPaid());
    }

    private String dateAndTime(){
        return formatter.format(date);
    }

    private String storeInformation(){
        return storeName + storeAdress;
    }

    private String printTotalSumAndTotalVat(){
        StringBuilder total = new StringBuilder();
        total.append("Total sum: " + Font.TAB_SPACE + sale.getTotalPrice() + Font.NEW_LINE);
        total.append("Total VAT: " + Font.TAB_SPACE + sale.getTotalVatRate() + Font.NEW_LINE);
        return total.toString();
    }

    private String printItemsInSale(Sale sale) {
        StringBuilder collectItems = new StringBuilder();
        for(ItemDTO collect : sale.itemsInSale){
            collectItems.append(collect.getItem() + Font.TAB_SPACE + collect.getQuantity() + "st*" +
                    collect.getPrice() + Font.TAB_SPACE + (collect.getPrice() * collect.getQuantity()) + Font.NEW_LINE);
        }
        return collectItems.toString();
    }

}
