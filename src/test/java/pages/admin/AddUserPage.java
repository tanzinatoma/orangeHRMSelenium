package pages.admin;

import org.openqa.selenium.By;
import resource.Base;

public class AddUserPage extends Base {
    By admin_sidebar = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    By add_button =By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By user_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    By admin_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[@role='option'][2]");
    By ess_role = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[@role='option'][3]");
    By employee_name = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By status_dropdown = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");

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
    public void type_employee_name(String name){
        driver.findElement(employee_name).sendKeys(name);
    }

}
