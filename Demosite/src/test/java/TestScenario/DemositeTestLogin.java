package TestScenario;

import java.util.concurrent.TimeUnit;
import PageObject.DemositeLoginPage;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class DemositeTestLogin {
    protected WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected DemositeLoginPage demositeLoginPage;

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

    public void login() throws Exception {

        demositeLoginPage.loginUser("admin", "demo123");

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
