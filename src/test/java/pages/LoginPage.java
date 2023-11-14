package pages;

import org.openqa.selenium.*;
import resource.Base;

public class LoginPage extends Base {
    By username = By.name("username");
    By password = By.name("password");
    By login_button = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    public void type_username(String text){
        driver.findElement(username).sendKeys(text);
    }

    public void type_password(String text){
        driver.findElement(password).sendKeys(text);
    }
    public void click_login_button(){
        driver.findElement(login_button).click();
    }
}
