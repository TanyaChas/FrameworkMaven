import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GitHubTest extends BaseTest {
    @Test
    public void validateLogoOnTheLoginPageIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.goToLoginPage().getLogo().isDisplayed(), "Logo is not displayed");
        Logger logger = LogManager.getLogger();
        logger.info("validateLogoOnTheLoginPageIsDisplayed");
    }
    @Test
    public void validateAnUsedCan() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.goToLoginPage().getLogo().isDisplayed(), "Logo is not displayed");
        Logger logger = LogManager.getLogger();
        logger.info("validateAnUsedCan");
    }
    @Test
    public void checkLogoOnTheLoginPage() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.goToLoginPage().getLogo().isDisplayed(), "Logo is not displayed");
        Logger logger = LogManager.getLogger();
        logger.info("checkLogoOnTheLoginPage");
    }

    @Test
    public void checkLoginIsSuccessful() {
        HomePage home = new HomePage(driver);
        home.goToLoginPage().loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.getLogoOnTheMainPage();
        Assertions.assertTrue(mainPage.getLogoOnTheMainPage().isDisplayed());
        Logger logger = LogManager.getLogger();
        logger.info("checkLoginIsSuccessful");
    }

    @Test
    public void checkFailedLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFailed("1test9874@ukr.net", "test9874@ukr.net");
        loginPage.validateErrorMessage("Incorrect username or password.");
        Logger logger = LogManager.getLogger();
        logger.info("checkFailedLogin");
    }

    @Test
    public void checkLogOutFromGitHub() {
        String expectedQuestionText = "Are you sure you want to sign out?";
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm();
        ProfileForm profileForm = new ProfileForm(driver);
        Assertions.assertEquals(expectedQuestionText, profileForm.signOutFromGitHub().getQuestionElement().getText());
        Logger logger = LogManager.getLogger();
        logger.info("checkLogOutFromGitHub");
    }

    @Test
    public void checkRepositoriesList() {
        Logger logger = LogManager.getLogger();
        List<String> expReposList = new ArrayList<>();
        expReposList.add("test2");
        expReposList.add("test1");
        expReposList.add("test");

        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm().goToRepositoriesPage();
        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        Assertions.assertEquals(expReposList, repositoriesPage.getRepositories());
        logger.info("checkRepositoriesList");
    }
}