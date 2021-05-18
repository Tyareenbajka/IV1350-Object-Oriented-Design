package se.kth.iv1350.util;

import java.time.LocalTime;
import java.util.Date;

/**
 * Responsible for logging unchecked errors to the log
 */
public class Logger {
    private StringBuilder logger;
    public Logger(){
        logger = new StringBuilder();
    }

    /**
     * Adding information about the error to the log
     *
     * @param errorMessage the error message to log
     */
    public void addToLogger(String errorMessage){
        logger.append("ERROR:" + Font.NEW_LINE);
        logger.append(timeAndDate());
        logger.append(Font.NEW_LINE);
        logger.append(errorMessage);
        logger.append(Font.NEW_LINE);
    }

    private Date timeAndDate(){
        Date date = new java.util.Date();
        return date;
    }

    /**
     * Gets the log
     *
     * @return the content of the log
     */
    public String getLogger(){
        return logger.toString();
    }


}
