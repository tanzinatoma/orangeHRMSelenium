package tests.admin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.admin.AddUserPage;
import resource.Base;
import tests.LoginTest;

import java.io.IOException;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.*;

public class AddUserTests extends Base {

    static AddUserPage user;
    Faker faker;
    LoginPage login;
    ExtentSparkReporter reporter;
    ExtentReports reports;
    @BeforeTest
    public void test_setup() throws IOException, InterruptedException {
        driver = setupApplication();
        user = new AddUserPage();
        login = new LoginPage();
        faker = new Faker();
        reporter = new ExtentSparkReporter("/Users/tanzinatoma/Documents/Github/orangeHRMSelenium/reports/addUserTestReport.html");
        reporter.config().setDocumentTitle("Add User Tests");
        reporter.config().setReportName("Add User Tests");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }
    @Test (priority = 1, enabled = true)
    public void login() {
        ExtentTest login_test = reports.createTest("Login Test - Valid");
        driver.get(props.getProperty("url"));
        login.type_username(props.getProperty("user"));
        login_test.info("Username entered");
        login.type_password(props.getProperty("pass"));
        login_test.info("Password entered");
        login.click_login_button();
        assertThat(driver.getCurrentUrl()).isEqualTo(props.getProperty("dashboard_url"));
        login_test.pass("User Successfully Logged In");
    }
    @Test (priority = 2, enabled = true)
    public void create_admin() throws InterruptedException {
        ExtentTest create_admin = reports.createTest("Create Admin Test");
        user.click_admin_sidebar();
        assertThatNoException();
        create_admin.info("Clicked on sidebar");
        user.click_add_button();
        create_admin.pass("Clicked on Add Admin button");
        user.click_user_role();
        user.click_admin_role();
        user.type_employee_name(props.getProperty("employee_name"));
        user.click_status();
        user.click_enabled();
        props.setProperty("username", faker.name().username());
        user.type_username(props.getProperty("username"));
        props.setProperty("password", faker.internet().password());
        user.type_password(props.getProperty("password"));
        user.type_confirm_password(props.getProperty("password"));
        user.save_user();
    }
    @AfterTest
    public void test_close(){
        reports.flush();
    }
}
