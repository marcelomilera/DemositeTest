import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by Cajas on 27/06/2017.
 */
public class DemositeTestPages {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private DemositeLoginPage demositeLoginPage;
  private DemositePagesPage demositePagesPage;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://demosite.center/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    demositeLoginPage = PageFactory.initElements(driver, DemositeLoginPage.class);
    demositePagesPage=PageFactory.initElements(driver,DemositePagesPage.class);
    driver.get(baseUrl + "/wordpress/wp-login.php");
  }

  @Test
  public void testAddDraftPages() throws Exception {

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


 // Add Draft Pages
    //driver.findElement(By.cssSelector("#menu-pages > div.wp-menu-image > a")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Pages Add New", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.cssSelector("a.add-new-h2")).click();
    demositePagesPage.setLinkAdd();
    try {
      assertEquals("Add New Page", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("Page 1");
    driver.findElement(By.id("content-html")).click();
    driver.findElement(By.id("content")).clear();
    driver.findElement(By.id("content")).sendKeys("testing page 1 here");
    driver.findElement(By.id("save-post")).click();*/
    demositePagesPage.AddDraftPage("Page 1", "testing page 1 here");
    try {
      assertEquals("Page draft updated. Preview page", driver.findElement(By.cssSelector("#message > p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.linkText("Pages")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Page 1", driver.findElement(By.linkText("Page 1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.linkText("Drafts (3)")).click();
    demositePagesPage.setLinkDrafts();
    try {
      assertEquals("Page 1", driver.findElement(By.linkText("Page 1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @Test
  public void testAddPublishedPages() throws Exception {

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


    //Add Published Pages
    //driver.findElement(By.cssSelector("#menu-pages > div.wp-menu-image > a")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Pages Add New", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.cssSelector("a.add-new-h2")).click();
    demositePagesPage.setLinkAdd();
    try {
      assertEquals("Add New Page", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*driver.findElement(By.id("title-prompt-text")).click();
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("Post 2");
    driver.findElement(By.id("content")).clear();
    driver.findElement(By.id("content")).sendKeys("Testing post 2 here");
    driver.findElement(By.id("publish")).click();*/
    demositePagesPage.AddPublishedPage("Post 2", "Testing post 2 here");
    try {
      assertEquals("Page published. View page", driver.findElement(By.cssSelector("#message > p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.linkText("Pages")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Post 2", driver.findElement(By.linkText("Post 2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //driver.findElement(By.linkText("Published (3)")).click();
    demositePagesPage.setLinkPublished();
    try {
      assertEquals("Post 2", driver.findElement(By.linkText("Post 2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @Test
  public void testPagesFilterByJuly2012() throws Exception {

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


    //Filter by July 2012
    //driver.findElement(By.cssSelector("#menu-pages > div.wp-menu-image > a")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Pages Add New", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("July 2012", driver.findElement(By.cssSelector("option[value=\"201207\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*new Select(driver.findElement(By.name("m"))).selectByVisibleText("July 2012");
    driver.findElement(By.id("post-query-submit")).click();*/
    demositePagesPage.FilterDate("July 2012");
    try {
      assertEquals("Sample Page", driver.findElement(By.linkText("Sample Page")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("2012/07/01", driver.findElement(By.cssSelector("abbr[title=\"2012/07/01 6:32:32 PM\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @Test
  public void testEditPages() throws Exception {

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


    //Edit Page
    //driver.findElement(By.cssSelector("#menu-pages > div.wp-menu-image > a")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Pages Add New", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Edit", driver.findElement(By.cssSelector("option.hide-if-no-js")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*driver.findElement(By.name("post[]")).click();
    new Select(driver.findElement(By.name("action"))).selectByVisibleText("Edit");
    driver.findElement(By.id("doaction")).click();*/
    demositePagesPage.EditPost("Edit");
    try {
      assertEquals("BULK EDIT", driver.findElement(By.cssSelector("h4")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*new Select(driver.findElement(By.name("post_author"))).selectByVisibleText("admin");
    new Select(driver.findElement(By.name("comment_status"))).selectByVisibleText("Do not allow");
    driver.findElement(By.id("bulk_edit")).click();*/
    demositePagesPage.SaveChanges("admin", "Do not allow");
    try {
      assertEquals("1 post updated.", driver.findElement(By.cssSelector("#message > p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @Test
  public void testMoveToTrashPages() throws Exception {

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


    //Move to trash
    //driver.findElement(By.cssSelector("#menu-pages > div.wp-menu-image > a")).click();
    demositePagesPage.setLinkPages();
    try {
      assertEquals("Pages Add New", driver.findElement(By.cssSelector("h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Move to Trash", driver.findElement(By.cssSelector("option[value=\"trash\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*driver.findElement(By.name("post[]")).click();
    new Select(driver.findElement(By.name("action"))).selectByVisibleText("Move to Trash");
    driver.findElement(By.id("doaction")).click();*/
    demositePagesPage.DeletePost("Move to Trash");
    try {
      assertEquals("Item moved to the Trash. Undo", driver.findElement(By.cssSelector("#message > p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    /*driver.findElement(By.linkText("Trash (1)")).click();
    driver.findElement(By.id("delete_all")).click();*/
    demositePagesPage.DeleteAll();
    try {
      assertEquals("Item permanently deleted.", driver.findElement(By.cssSelector("#message > p")).getText());
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

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
