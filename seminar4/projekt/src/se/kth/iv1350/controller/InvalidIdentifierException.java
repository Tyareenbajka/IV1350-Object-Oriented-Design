package se.kth.iv1350.controller;

/**
 * Thrown when an invalid identifier is scanned
 */
public class InvalidIdentifierException extends Exception{
    private int invalidIdentifier;

    /**
     * Creates a new instance with a message specifying which identifier is invalid
     *
     * @param invalidIdentifier the scanned invalid identifier
     */
    public InvalidIdentifierException(int invalidIdentifier){
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
