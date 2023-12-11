import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GitHubTest {
    private WebDriver driver;            // тестовий клас
    public void gitHubTest(){           // тестовий метод
        WebElement h1;
        WebElement img;
        WebElement ul;
        WebElement text;
        WebElement title = driver.findElement(By.xpath(//title));
        WebElement h1 = driver.findElement(By.xpath(//h1[1]));
        WebElement img = driver.findElement(By.xpath(//img[1]));
        WebElement ul = driver.findElement(By.xpath(//ul li:first-child(2)));
        WebElement text = driver.findElement(By.xpath(//input[type="text"]));

        System.setProperty("webdriver.chrome.driver"  , "C:\\Users\\User\\IdeaProjects\\FrameworkMaven\\src\\main\\resources\\drivers\\chromedriver-win64\\chromedriver.exe");

        //якщо не запустилося
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);
        driver.get("https://github.com");
        driver.quit();
        driver.get("https://github.com/TanyaChas/Les_1/blob/master/HW1.java");
        driver.quit();
        driver.get("https://github.com/TanyaChas/Les_1/blob/master/HW3.java");
        driver.quit();
        driver.get("https://github.com/TanyaChas/Les_1/blob/master/HW3_Star.java");
        driver.quit();
        driver.get("https://github.com/TanyaChas/Les_1/blob/master/HomeWork2.java");
        driver.quit();
        driver.get("https://github.com/TanyaChas/Les_1/blob/master/Student.java");
        driver.quit();

    }

    public static void main(String[] args) {
        GitHubTest gitHubTest =new GitHubTest();
        gitHubTest.gitHubTest();
    }
}
