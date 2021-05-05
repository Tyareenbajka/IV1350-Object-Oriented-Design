package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.IntegrationCreator;
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
        Controller contr = new Controller(integration);
        View view = new View(contr);

        view.sampleExecution();
    }
}
