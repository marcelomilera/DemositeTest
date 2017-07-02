package TestScenario;

import PageObject.DemositeLoginPage;
import PageObject.DemositeLinksPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by MARCELO on 2/07/2017.
 */

public class DemositeTestLinks extends DemositeTestLogin{
    private DemositeLinksPage demositeLinkPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        demositeLoginPage = PageFactory.initElements(driver, DemositeLoginPage.class);
        demositeLinkPage =PageFactory.initElements(driver,DemositeLinksPage.class);
    }

    @Test
    public void testAddNewLink() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-admin/link-add.php");
        //Login
        login();

        // Add New Link
        demositeLinkPage.addNewLink("Test Link", "http://wordpress.org/", "This is a Link for testing purposes");

        // Verify expected results
        try {
            assertEquals("Link added.", driver.findElement(By.cssSelector("#message > p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        // Navigate to All Links Page
        demositeLinkPage.navigateAllLinksPage();

        // Verify expected results
        try {
            assertEquals("Test Link", driver.findElement(By.linkText("Test Link")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testUpdateLink() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-admin/link-manager.php");
        //Login
        login();

        // Click "Test Link"
        demositeLinkPage.clickTestLink();
        demositeLinkPage.updateLink("Test Link Updated", "http://google.com/", "This link was updated.");

        // Verify expected results
        try {
            assertEquals("Test Link Updated", driver.findElement(By.linkText("Test Link Updated")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testAddCategory() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-admin/edit-tags.php?taxonomy=link_category");
        // Login
        login();

        // Add New Category
        demositeLinkPage.addNewCategory("Test Category", "Category", "This is a link category for testing purposes.");

        // Verify expected results
        try {
            assertEquals("Test Category", driver.findElement(By.linkText("Test Category")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testLinkSearch() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-admin/link-manager.php");
        // Login
        login();

        // Search Link
        demositeLinkPage.searchLink("Documentation");

        // Verify expected results
        try {
            assertEquals("Documentation", driver.findElement(By.linkText("Documentation")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testDeleteAllCategories() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-admin/edit-tags.php?taxonomy=link_category");
        // Login
        login();

        // Delete all categories
        demositeLinkPage.deleteAllCategories();

        // Verify expected results
        try {
            Boolean categoryExists = driver.findElement(By.linkText("Test Category")).isDisplayed();
            if (categoryExists)
                verificationErrors.append("Test Category still exists");
        }
        catch (NoSuchElementException e){
            assertTrue( demositeLinkPage.verifyItemsCount("1 item"));
        }
        catch (Error e) {
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
