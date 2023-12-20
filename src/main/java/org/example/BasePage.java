package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.ColorPrinter.printColorMessage;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    private String title;
    protected Logger logger;

    public BasePage(WebDriver driver, String title){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 3);
        this.title = this.title;
        this.logger = LogManager.getLogger(this.title);
        printColorMessage("Page object of" + this.title + this.getClass().getName(), logger, Level.DEBUG);

    }
}
