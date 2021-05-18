package se.kth.iv1350.integration;

/**
 * Contains information about one particular item
 */
public class ItemDTO {
    private final String item;
    private final int identifier;
    private final double price;
    private final double vatRate;
    private int quantity = 1;

    /**
     * Creates a new instance representing a particular item
     *
     * @param item Item description
     * @param identifier The identifier of the item
     * @param price The price of the item
     * @param vatRate The VAT rate
     */
    public ItemDTO(String item, int identifier, double price, double vatRate) {
        this.item = item;
        this.identifier = identifier;
        this.price = price;
        this.vatRate = vatRate;
    }

    /**
     * Get the name of the item
     *
     * @return name of the item
     */
    public String getItem(){
        return item;
    }

    /**
     * Get the identifier of the item
     *
     * @return identifier of the item
     */
    public int getIdentifier(){
        return identifier;
    }

    /**
     * Get the price of the item
     *
     * @return price of the item
     */
    public double getPrice(){
        return price;
    }

    /**
     * Get the vateRate of the item
     *
     * @return vateRate of the item
     */
    public double getVatRate(){
        return vatRate;
    }

    /**
     * Get the quantity of the item
     *
     * @return quantity of the item
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Increases the quantity
     */
    public void increaseQuantity(){
        quantity++;
    }
}
