package resource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class Base
{
    public static WebDriver driver;
    public FileReader reader;
    public Properties props;
    public static String className;
    ChromeOptions options = new ChromeOptions();
    public WebDriver setupApplication() throws IOException, InterruptedException
    {
        options.addArguments("--remote-allow-origins=*");
        reader=new FileReader("/Users/tanzinatoma/Documents/OrangeHRM/OrangeHRM/src/main/java/resource/TestData.properties");
        props=new Properties();
        props.load(reader);
        String browser = props.getProperty("browser_name");
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver=new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equals("edge")) {}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
    public String packageName() {
        String final_package;
        String packageName = this.getClass().getPackage().getName();
        int lastDot = packageName.lastIndexOf(".");
        int secondLastDot = packageName.lastIndexOf(".", lastDot - 1);
        if (secondLastDot != -1) {
            String lastPackage = packageName.substring(lastDot + 1);
            String secondLastPackage = packageName.substring(secondLastDot + 1, lastDot);
            final_package = secondLastPackage +"."+ lastPackage+".";
        } else {
            final_package =  packageName+".";
        }
        return final_package;
    }
}