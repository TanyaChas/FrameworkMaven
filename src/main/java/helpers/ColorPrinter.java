package helpers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import static helpers.ConsoleColors.*;

public class ColorPrinter {
    public static void printMessage(String message){
        System.out.println(YELLOW + message + RESET);
    }
    public static void printColorMessage(String message, Logger logger, Level level){           //Logger 4j
        switch (level){
            case INFO:
                logger.info(GREEN +message + RESET);
                break;
            case DEBUG:
                logger.info(BLUE +message + RESET);
                break;
            case ERROR:
                logger.info(RED +message + RESET);
        }
    }
}
