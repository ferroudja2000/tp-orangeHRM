package com.example.steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.pages.dashbordPage;
import com.example.pages.loginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogintoOrangeHRMTest {
    WebDriver driver;  
    loginPage lp;
    dashbordPage dp;

    @Before 
    public void setup(){
        //driver = new ChromeDriver();
        URL gridUrl = null;

        try {
            gridUrl = new URL("http://selenium-hub:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }   
        ChromeOptions cr = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, cr);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp = new loginPage(driver);
        dp = new dashbordPage(driver);

        
    } 

    @After 
    public void tearDown(){
        if (driver!=null)
            driver.quit();
        driver = null ;
    }

    @When("je saisis le password {string}")
    public void je_saisis_le_password(String s) {
        lp.saisirpassword(s);
    }

    @When("je saisis de username {string}")
    public void je_saisis_de_username(String m) { 
        lp.saisirUsername(m);
    }

    @When("je clique sur le bouton login")
    public void je_clique_sur_le_bouton_login() {
        lp.clicklogin();
    }

    @Given("visiter le site de orangeHRM {string}")
    public void visiter_le_site_de_orangeHRM(String URL) {
        driver.get(URL);
    }

    @Then("la section My Actions est  visible")
    public void   la_section_My_Actions_est_visible() {
        assertEquals("My Actions", dp.verifieActions());
    }

    @Then("la section Quick launch est visible")
    public void la_section_Quick_launch_est_visible() {
        assertEquals("Quick Launch", dp.verifierquicklauch());
    }

    @Then("je suis redirige vers le Dashbord")
    public void je_suis_redirige_vers_le_Dashbord() {
        assertEquals( "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",driver.getCurrentUrl());
    }
}
