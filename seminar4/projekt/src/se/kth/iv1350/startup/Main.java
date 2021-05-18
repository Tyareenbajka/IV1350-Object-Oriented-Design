package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.IntegrationCreator;
import se.kth.iv1350.util.Logger;
import se.kth.iv1350.view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of
 * the program
 */
public class Main {

    /**
     * Starts the program
     * @param args The program does not take any command line parameters.
     */
    public static void main(String[] args) {
        IntegrationCreator integration = new IntegrationCreator();
        Logger logger = new Logger();
        Controller contr = new Controller(integration, logger);
        View view = new View(contr);

        view.sampleExecution();
    }
}
