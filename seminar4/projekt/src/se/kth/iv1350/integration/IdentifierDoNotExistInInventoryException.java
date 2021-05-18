package se.kth.iv1350.integration;

/**
 * Thrown when a specific identifier is not in the inventory catalog
 */
public class IdentifierDoNotExistInInventoryException extends Exception{
    private int invalidIdentifier;

    /**
     * Creates a new instance with a message specifying which identifier is invalid
     *
     * @param invalidIdentifier the scanned invalid identifier
     */
    public IdentifierDoNotExistInInventoryException(int invalidIdentifier){
        super("The scanned identifier " + "'" + invalidIdentifier + "'"  + " does not exist in the inventory catalog");
        this.invalidIdentifier = invalidIdentifier;
    }

    /**
     * Get the invalid identifier
     *
     * @return the invalid identifier
     */
    public int getInvalidIdentifier(){
        return invalidIdentifier;
    }



}
