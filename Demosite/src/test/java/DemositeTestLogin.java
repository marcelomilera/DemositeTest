//package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemositeTestLogin {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private DemositeLoginPage demositeLoginPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demositeLoginPage = PageFactory.initElements(driver, DemositeLoginPage.class);
        driver.get(baseUrl + "/wordpress/wp-login.php");
    }

    @Test
    public void testLogin() throws Exception {

        /*driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("demo123");
        driver.findElement(By.id("wp-submit")).click();*/

        demositeLoginPage.loginUser("admin", "demo123");


        try {
            assertEquals("Howdy, admin", driver.findElement(By.linkText("Howdy, admin")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Dashboard", driver.findElement(By.cssSelector("h2")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
