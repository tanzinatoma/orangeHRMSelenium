package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import resource.Base;

import java.security.Key;

public class AddUserPage extends Base {
    By admin_sidebar = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    By add_button =By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By user_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    By admin_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[@role='option'][2]");
    By ess_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[@role='option'][3]");
    By employee_name = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By employee_list = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[@role='option'][1]");
    By status_dropdown = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
    By enabled = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[@role='option'][2]");
    By username = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By password = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By confirm_password = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    By create_user_button = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");

    public void click_admin_sidebar(){
        driver.findElement(admin_sidebar).click();
    }
    public void click_add_button(){
        driver.findElement(add_button).click();
    }
    public void click_user_role(){
        driver.findElement(user_role).click();
    }
    public void click_admin_role() {
        driver.findElement(admin_role).click();
    }
    public void click_ess_role() {
        driver.findElement(ess_role).click();
    }
    public void type_employee_name(String name) throws InterruptedException {
        driver.findElement(employee_name).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(employee_list).click();
    }
    public void click_status(){
        driver.findElement(status_dropdown).click();
    }
    public void click_enabled(){
        driver.findElement(enabled).click();
    }
    public void type_username(String name){
        driver.findElement(username).sendKeys(name);
    }
    public void type_password(String name){
        driver.findElement(password).sendKeys(name);
    }
    public void type_confirm_password(String confirm){
        driver.findElement(confirm_password).sendKeys(confirm);
    }
    public void save_user(){
        driver.findElement(create_user_button).click();
    }
}
