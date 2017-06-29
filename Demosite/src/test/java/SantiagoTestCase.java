import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Hiraoka on 28/06/2017.
 */
public class SantiagoTestCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private DemositeLoginPage demositeLoginPage;
    private DemositePostPage demositePostPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demositeLoginPage = PageFactory.initElements(driver,DemositeLoginPage.class);
        demositePostPage = PageFactory.initElements(driver, DemositePostPage.class);
        driver.get(baseUrl + "/wordpress/wp-login.php");
    }

    /*Test Cases:
        -> savePost
        -> publishPost
        -> addCategory
        -> sendPostToTrash
        -> filterByCategory
    * */


    @Test
    public void testSaveNewPost() throws Exception {
        //------------------------- Login
        //------Start
        demositeLoginPage.loginUser("admin","demo123");

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
        // ------End

        demositePostPage.savePost("sgp demoPost02","this is the demo post 02");

        try {
            assertEquals("sgp demoPost02",driver.findElement(By.linkText("sgp demoPost02")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void testPublishPost() throws Exception{
        //------------------------- Login
        //------Start
        demositeLoginPage.loginUser("admin","demo123");

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
        // ------End

        demositePostPage.publishPost("sgpDemoPublishPost03","this is the demo post 03");

        try {
            assertEquals("sgpDemoPublishPost03",driver.findElement(By.linkText("sgpDemoPublishPost03")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testAddCategory() throws Exception{
        //------------------------- Login
        //------Start
        demositeLoginPage.loginUser("admin","demo123");

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
        // ------End

        demositePostPage.addCategory("CategoryDemo01","catdemo01","None","this is the category demo 01");

        try {
            assertEquals("CategoryDemo01",driver.findElement(By.linkText("CategoryDemo01")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void testPostToTrash()throws Exception{
        //------------------------- Login
        //------Start
        demositeLoginPage.loginUser("admin","demo123");

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
        // ------End

        demositePostPage.movePostToTrash("Move to Trash");
        try {
            assertEquals("Item moved to the Trash. Undo", driver.findElement(By.cssSelector("#message > p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testFilterByCategory() throws Exception{
        //------------------------- Login
        //------Start
        demositeLoginPage.loginUser("admin","demo123");

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
        // ------End

        demositePostPage.filterByCategory("cetegotyDemo01");
        try {
            assertEquals("cetegotyDemo01", driver.findElement(By.linkText("cetegotyDemo01")).getText());
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
