package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage {
    WebDriver driver;
    By username = By.name("username");
    By password = By.name("password");
    By bouton_login = By.cssSelector("button[type='submit']");



public loginPage (WebDriver driver){
    this.driver =driver;
}

public void saisirUsername(String name){
    driver.findElement(username).sendKeys(name);
}

public void saisirpassword(String pass){
    driver.findElement(password).sendKeys(pass);
}
public void clicklogin(){
    driver.findElement(bouton_login).click();
}

}
