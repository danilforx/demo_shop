package com.demoshop;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginTest() {
        login("forex05@gmail.com", "Password1$");
    }
}
