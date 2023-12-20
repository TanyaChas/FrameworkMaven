import com.google.common.annotations.VisibleForTesting;
import org.asynchttpclient.util.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class JunitTest {
    private WebDriver driver;
@Test
public void validateLogoOnTheLoginPageIsDisplayed(){
    System.setProperty("webdriver.chrome.driver"  , "C:\\Users\\User\\IdeaProjects\\FrameworkMaven\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver.exe");

    //якщо не запустилося
    ChromeOptions option = new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);
    driver.get("https://github.com");
    driver.quit();
    WebDriver singInButton = driver.findElement(By.xpath('//a[contains(text(), \"Sing in\")]');
    ((WebElement) singInButton).click();
    WebDriver logo = (WebDriver) driver.findElement(By.className("header-logo"));
    Assertions.assertNotNull(logo.isDisplayed());
    driver.quit();
}

}
