package com.myschool.learn.tests.phptravels.login;

import com.myschool.learn.pages.phptravels.HomePage;
import com.myschool.learn.pages.phptravels.login.Login;
import com.myschool.learn.tests.phptravels.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class LoginTest extends BaseFunctionalTest {
    protected Login login;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.login=new Login(this.driver, configPhpTravels);
   }

   @Test(description = "Test to Login With Existing Profile")
    public void testLoginWithExistingProfile(){
        this.login.get();
        this.login.waitForPageLoad();
        this.login.enterEmail("lilly.tamara@example.com");
        this.login.enterPassword("Quality1!");
        this.login.clickLoginButton();
       Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/account/"), "Login Success Url is Valid");
       Assert.assertTrue(this.login.getFirstLastName().contains("Hi, Lilly Tamara"),"Profile Contains the Valid First & Last Name");
   }

}
