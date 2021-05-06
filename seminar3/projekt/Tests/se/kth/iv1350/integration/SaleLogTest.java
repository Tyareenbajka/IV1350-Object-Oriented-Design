package se.kth.iv1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.model.CashPayment;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.util.Amount;

import static org.junit.jupiter.api.Assertions.*;

class SaleLogTest {
    private ItemDTO testItem;
    private Sale testSale;
    private Inventory inventory;
    private Accounting realAccounting = new Accounting();
    private InventoryTest test;
    private SaleLog salelog;
    private CashPayment testPayment;
    private Amount testAmount;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        salelog = new SaleLog(inventory);
        testSale = new Sale();
        testItem = new ItemDTO("gurka", 8877, 15, 3);
        testSale.itemsInSale.add(testItem);
        testAmount = new Amount(15);
        testPayment = new CashPayment(testAmount, 0, 15);
    }

    @AfterEach
    void tearDown() {
        inventory = null;
        salelog = null;
        testSale = null;
        testItem = null;
        testAmount = null;
        testPayment = null;
    }

    @Test
    void testLogCompleteSale() {
        String inventoryList = getListOfInventory();
        int expResultbeforSale = 100;
        int resultbeforSale = getQuantityInInventoryBeforeSale(inventoryList);
        assertEquals(expResultbeforSale, resultbeforSale, "Inventory has not been updated correctly!" );

        inventory.updateInventory(testSale);
        inventoryList = getListOfInventory();
        int expResultAfterSale = 99;
        int resultAfterSale = getQuantityInInventoryAfterSale(inventoryList);
        assertEquals(expResultAfterSale, resultAfterSale, "Inventory has not been updated correctly!");

        realAccounting.updateSalesReport(testPayment);
        double expResult = 15;
        double result = realAccounting.getAccounting();
        assertEquals(expResult, result, "The accounting has been updated incorrectly!");

    }
    private String getListOfInventory(){
        String inventoryList = inventory.printListOfInventory();
        return inventoryList;
    }

    private int getQuantityInInventoryBeforeSale(String inventoryList){
        int quantity = Integer.parseInt(inventoryList.substring(23, 26));
        return quantity;
    }

    private int getQuantityInInventoryAfterSale(String inventoryList){
        int quantity = Integer.parseInt(inventoryList.substring(23, 25));
        return quantity;
    }

}