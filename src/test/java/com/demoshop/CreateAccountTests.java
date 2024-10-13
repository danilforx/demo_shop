package com.demoshop;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createAccountNegativeTest() {
        register("forex05@gmail.com", "Password1$");
    }


    @Test
    public void createAccountPositiveTest2() {
        register("forexsws11@gmail.com", "Password1$");
        logout();
        login("forexsws11@gmail.com", "Password1$");
    }
}
