package de.dhbw.vote;


import de.dhbw.vote.common.CustomLogger;
import de.dhbw.vote.controller.CommandInterpreter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author codekeks
 */
public class ConsoleApplication {
    private static final BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    private static final CustomLogger logger = new CustomLogger(ConsoleApplication.class);
    
    public static void main(String[] args) {
        try {
            logger.debug("Console open");
            
            CommandInterpreter interpreter = new CommandInterpreter();
            boolean quit = false;

            interpreter.clearScreen();

                while(!quit){
                    try {
                        String command = fromKeyboard.readLine();
                        interpreter.interpret(command);
                    } 
                    catch (Exception e) {
                        logger.error("ERROR", e);
                        interpreter.errorWaitForCommand();
                    }
                }
            logger.debug("Console quit");            
        } 
        catch (Exception e) {
            logger.error("FATAL ERROR", e);
        }
    }
}
