package se.kth.iv1350.integration;

/**
 * Thrown when database server is not running
 */
public class DatabaseServerNotRunningException extends RuntimeException{

    public DatabaseServerNotRunningException(String message){
        super(message);
    }

}
