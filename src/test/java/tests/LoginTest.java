package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import resource.Base;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginTest extends Base {
    static LoginPage login;
    String path;
    @BeforeTest
    public void test_setup() throws IOException, InterruptedException {
        driver = setupApplication();
        login= new LoginPage();
        className= this.getClass().getSimpleName();
    }

    @Test
    public void login(Method result) throws Exception {
        driver.get(props.getProperty("url"));
        login.type_username(props.getProperty("user"));
        login.type_password(props.getProperty("pass"));
        login.click_login_button();
        path = props.getProperty("ss_location") + className + "_All" + "/" + result.getName() +".png";
        takeSnapShot(driver, path);
    }
}
