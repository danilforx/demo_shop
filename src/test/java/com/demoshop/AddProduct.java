package com.demoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProduct extends TestBase {


    @BeforeMethod
    public void preCondition() {
    login("forex05@gmail.com", "Password1$");
    }

    @Test
    public void addProductPositiveTest() {
        WebElement secondProduct = driver.findElements(By.cssSelector(".product-item")).get(1);
        secondProduct.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();

        // Переходим в корзину
        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

        // Подтверждаем условия и оформляем заказ
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }
}
