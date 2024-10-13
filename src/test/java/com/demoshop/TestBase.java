package com.demoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
    public boolean isElementPresent(By locator) {
        System.out.println("Проверка есть ли элемент [" + locator +"] на странице");
        return driver.findElements(locator).size()>0;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    protected void login(String email, String password) {
        click(By.xpath("//a[text()='Log in']"));
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        click(By.xpath("//input[@value='Log in']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Log out']")));
    }

    protected void register(String email, String password) {
        click(By.xpath("//a[text()='Register']"));
        click(By.id("gender-male"));
        type(By.name("FirstName"), "David");
        type(By.name("LastName"), "Smith");
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        type(By.name("ConfirmPassword"), password);
        click(By.id("register-button"));
        click(By.xpath("//input[@value='Continue']"));
    }

    protected void logout() {
        click(By.xpath("//a[text()='Log out']"));
    }

}
