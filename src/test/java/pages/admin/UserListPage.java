package pages.admin;

import org.openqa.selenium.By;
import org.testng.Assert;
import resource.Base;

public class UserListPage extends Base {
    By search_username_input = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By search_employee_input = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input");
    By employee_name_dropdown = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[@role='option'][1]");
    By search_button = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By edit_icon = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[2]");
    By username_in_list = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");
    By delete = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]");

    public void enter_employee_name(String name){
        driver.findElement(search_employee_input).sendKeys(name);
    }
    public void select_employee_from_dropdown(){
        driver.findElement(employee_name_dropdown).click();
    }
    public void click_search_employee(){
        driver.findElement(search_button).click();
    }
    public void edit_employee(){
        driver.findElement(edit_icon).click();
    }
    public void delete_employee(){
        driver.findElement(delete).click();
    }
    public void verify_username(){
        Assert.assertEquals(driver.findElement(username_in_list).getText(), "Admin");
    }
}
