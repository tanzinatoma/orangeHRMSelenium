package tests.admin;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.admin.AddUserPage;
import pages.admin.UserListPage;
import resource.Base;

import java.io.IOException;

public class UserEditDeleteTests extends Base {
    static AddUserPage user;
    static UserListPage list;
    Faker faker;
    LoginPage login;
    @BeforeTest
    public void test_setup() throws IOException, InterruptedException {
        driver = setupApplication();
        user = new AddUserPage();
        login = new LoginPage();
        faker = new Faker();
        list = new UserListPage();
    }
    @Test(priority = 1, enabled = true)
    public void login() {
        driver.get(props.getProperty("url"));
        login.type_username(props.getProperty("user"));
        login.type_password(props.getProperty("pass"));
        login.click_login_button();
        driver.get(props.getProperty("userlist_url"));
    }
    @Test(priority = 2, enabled = true)
    public void search_employee() throws InterruptedException {
        list.enter_employee_name(props.getProperty("employee_name"));
        Thread.sleep(3000);
        list.select_employee_from_dropdown();
        list.click_search_employee();
        Thread.sleep(1500);
        list.verify_username("Nathan.Elliot");
    }
    @Test(priority = 3, enabled = true)
    public void edit_employee() throws InterruptedException {
        list.edit_employee();
        user.clear_username();
        user.type_username("user.update");
        user.save_user();
        Thread.sleep(3000);
        driver.get(props.getProperty("userlist_url"));
        list.enter_employee_name(props.getProperty("employee_name"));
        Thread.sleep(3000);
        list.select_employee_from_dropdown();
        list.click_search_employee();
        Thread.sleep(1500);
        list.verify_username("user.update");
    }
    @Test(priority = 4, enabled = false)
    public void delete_user(){
        list.delete_employee();
    }
}