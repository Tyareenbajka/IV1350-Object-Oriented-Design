package se.kth.iv1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.model.Sale;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;
    private ItemDTO itemFromInventory;
    private ItemDTO testItem;
    private Sale testSale;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        testSale = new Sale();
        testItem = new ItemDTO("gurka", 8877, 15, 3);
        testSale.itemsInSale.add(testItem);
    }

    @Test
    void testRetrieveInfo() {
        int validIdentifier = 8877;
        itemFromInventory = inventory.retrieveInfo(validIdentifier);
        boolean expResult = true;
        boolean result = checkIfValidIdentifierRetrievesTheExpectedItem(testItem, itemFromInventory);
        assertEquals(expResult, result, "Did not retrieve the expected item from the inventory!");
    }

    private boolean checkIfValidIdentifierRetrievesTheExpectedItem(ItemDTO testItem, ItemDTO itemFromInventory){
        if(testItem.getItem().equals(itemFromInventory.getItem()) &&
                (testItem.getIdentifier() == itemFromInventory.getIdentifier()) &&
                (testItem.getPrice() == itemFromInventory.getPrice()) &&
                (testItem.getVatRate() == itemFromInventory.getVatRate()))
            return true;
        else
            return false;
    }

    @Test
    void testUpdateInventory() {
        String inventoryList = getListOfInventory();
        int expResultbeforSale = 100;
        int resultbeforSale = getQuantityInInventoryBeforeSale(inventoryList);
        assertEquals(expResultbeforSale, resultbeforSale, "Inventory has not been updated correctly!" );

        inventory.updateInventory(testSale);
        inventoryList = getListOfInventory();
        int expResultAfterSale = 99;
        int resultAfterSale = getQuantityInInventoryAfterSale(inventoryList);
        assertEquals(expResultAfterSale, resultAfterSale, "Inventory has not been updated correctly!");

    }
    private int getQuantityInInventoryBeforeSale(String inventoryList){
        int quantity = Integer.parseInt(inventoryList.substring(23, 26));
        return quantity;
    }

    private int getQuantityInInventoryAfterSale(String inventoryList){
        int quantity = Integer.parseInt(inventoryList.substring(23, 25));
        return quantity;
    }

    private String getListOfInventory(){
        String inventoryList = inventory.printListOfInventory();
        return inventoryList;
    }
}