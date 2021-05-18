package se.kth.iv1350.util;

import se.kth.iv1350.integration.RevenueObserver;
import se.kth.iv1350.view.TotalRevenueView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Prints total revenue to external file
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private PrintWriter logStream;

    public TotalRevenueFileOutput(){
        try{
            logStream = new PrintWriter(new FileWriter("totalRevenueLog.txt"), true);
        }
        catch (IOException e){
            System.out.println("FAIL TO LOG!");
        }
    }
    @Override
    public void newPayment(double amount) {
        logStream.println("Total revenue: " + amount + Font.KR);
    }
}
