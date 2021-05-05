package se.kth.iv1350.integration;

import se.kth.iv1350.model.Sale;
import se.kth.iv1350.util.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the item inventory, all items to purchase are taken from the stock
 */
public class Inventory {
    private List<ItemData> itemInventory = new ArrayList<>();

    /**
     * Creates a stock of items
     */
    public Inventory(){
        addItems();
    }

    private void addItems() {
        itemInventory.add(new ItemData("gurka", 8877, 15, 3, 100));
        itemInventory.add(new ItemData("oxfilé", 9976, 399, 20, 100));
        itemInventory.add(new ItemData("potatis", 1123, 10, 1, 100));
        itemInventory.add(new ItemData("bea", 4432, 31, 3, 100));
        itemInventory.add(new ItemData("loka", 4564, 18, 2, 100));
        itemInventory.add(new ItemData("resorb", 6532, 40, 8, 100));
    }

    /**
     * Search for the item with the given identifier in the inventory.
     *
     * @param identifier the identifier of the item to purchase
     * @return the item of the given identifier to purchase
     */
    public ItemDTO retrieveInfo(int identifier){
        for(ItemData itemToPurchase : itemInventory){
            if(itemToPurchase.identifier == identifier){
                return new ItemDTO(itemToPurchase.item, identifier, itemToPurchase.price, itemToPurchase.vatRate);
            }
        }
        return null;
    }

    /**
     * Updating the inventory after a complete sale
     *
     * @param sale the current completed sale
     */
    public void updateInventory(Sale sale){
        int identifier;
        int quantity;
        for(ItemDTO updateItem : sale.itemsInSale){
            identifier = updateItem.getIdentifier();
            quantity = updateItem.getQuantity();
            for(ItemData updateInventory : itemInventory){
                if(identifier == updateInventory.identifier){
                    updateInventory.quantity -= quantity;
                }
            }
        }
    }

    /**
     * Prints what is in the inventory
     *
     * @return data over the inventory
     */
    public String printListOfInventory(){
        //kommentera detta i rapport att bara används för läaren

        StringBuilder itemToString = new StringBuilder();
        for(ItemData itemInfo : itemInventory){
            itemToString.append("Item: " + itemInfo.item + Font.COMMA);
            itemToString.append("Quantity: " + itemInfo.quantity + Font.NEW_LINE);
        }
        return itemToString.toString();
    }

    private class ItemData {
        private final String item;
        private final int identifier;
        private final double price;
        private final double vatRate;
        private int quantity;

        public ItemData(String item, int identifier, double price, double vatRate, int quantity){
            this.item = item;
            this.identifier = identifier;
            this.price = price;
            this.vatRate = vatRate;
            this.quantity = quantity;
        }
    }
}