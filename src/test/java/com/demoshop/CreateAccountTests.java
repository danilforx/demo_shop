package com.demoshop;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createAccountPositiveTest() {
        register("forex05@gmail.com", "Password1$");
    }


    @Test
    public void createAccountPositiveTest2() {
        register("forexsws01@gmail.com", "Password1$");
        logout();
        login("forexsws01@gmail.com", "Password1$");
    }
}
