package se.kth.iv1350.integration;

/**
 * This class is responsible for instantiating all integration classes
 */
public class IntegrationCreator {
    private Inventory inventory = new Inventory();
    private SaleLog saleLog = new SaleLog(inventory);

    /**
     * Get the value of inventory
     *
     * @return the value of inventory
     */
    public Inventory getInventory(){
        return inventory;
    }

    /**
     * Get the value of saleLog
     *
     * @return the value of saleLog
     */
    public SaleLog getSaleLog(){
        return saleLog;
    }
}
