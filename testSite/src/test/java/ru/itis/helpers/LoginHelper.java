package ru.itis.helpers;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.itis.datas.AccountData;
import ru.itis.manager.ApplicationManager;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends BaseHelper {


    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData accountData) throws InterruptedException {

        driver.get("https://evernote.com/intl/ru/");
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(accountData.getLogin());
        driver.findElement(By.id("loginButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("loginButton")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='gwt-debug-AccountMenu-avatar']/div/div/div/img")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перейти на новый Evernote Web'])[1]/following::div[4]")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void isLoggedIn(Boolean isLogged) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        if (!isLogged) {
            Assert.assertTrue(driver.findElement(By.className("error-status")).isDisplayed());
        } else Assert.assertTrue(driver.getCurrentUrl().contains("login=true"));
    }
}
