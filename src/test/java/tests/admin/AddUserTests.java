package tests.admin;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.admin.AddUserPage;
import resource.Base;
import tests.LoginTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class AddUserTests extends Base {

    static AddUserPage user;
    LoginPage login;
    @BeforeTest
    public void test_setup() throws IOException, InterruptedException {
        driver = setupApplication();
        user = new AddUserPage();
        login = new LoginPage();
    }
    @Test (priority = 1, enabled = true)
    public void login() {
        driver.get(props.getProperty("url"));
        login.type_username(props.getProperty("user"));
        login.type_password(props.getProperty("pass"));
        login.click_login_button();
    }
    @Test (priority = 2, enabled = true)
    public void create_admin() {
        user.click_admin_sidebar();
        user.click_add_button();
        user.click_user_role();
        user.click_admin_role();
    }
}
