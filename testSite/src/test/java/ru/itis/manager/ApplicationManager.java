package ru.itis.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.NoteHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {

    private String baseUrl;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    private LoginHelper loginHelper;
    private NoteHelper noteHelper;
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    public static ApplicationManager getInstance() {
        if (app.get() == null) {

            ApplicationManager newInstance = new ApplicationManager();

            app.set(newInstance);

        }

        return app.get();
    }

    private ApplicationManager(){
        System.setProperty("webdriver.gecko.driver", "/home/dariya/Рабочий стол/инфа/testSite/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(this);
        noteHelper = new NoteHelper(this);
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NoteHelper getNoteHelper() {
        return noteHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
