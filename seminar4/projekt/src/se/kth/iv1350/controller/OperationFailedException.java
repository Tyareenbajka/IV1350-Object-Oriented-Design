package se.kth.iv1350.controller;

/**
 * Thrown when database server is not running
 */
public class OperationFailedException extends Exception{

    public OperationFailedException(String message){
        super(message);
    }
}
