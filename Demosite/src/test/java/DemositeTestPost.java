import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class DemositeTestPost {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private DemositePage demositePostPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demositePostPage = PageFactory.initElements(driver, DemositePage.class);
        driver.get(baseUrl + "/wordpress/wp-admin/post-new.php");
    }

    @Test
    public void testAddNewPost() throws Exception {
        demositePostPage.insertPost("Post 1", "This post is for testing purposes.");

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
