package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashbordPage {
    WebDriver driver;
    By cadran = By.className("orangehrm-dashboard-widget-header");

    public dashbordPage(WebDriver driver){
        this.driver = driver;
    }

    public String verifieActions(){
       return driver.findElements(cadran).get(1).getText();
    }

    public String verifierquicklauch(){
       return  driver.findElements(cadran).get(2).getText();
    }

}
