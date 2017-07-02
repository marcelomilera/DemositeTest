package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by MARCELO on 2/07/2017.
 */
public class DemositeLinksPage {
    WebDriver driver;

    @FindBy(id = "link_name")
    WebElement txtLinkName;

    @FindBy(id="link_url")
    WebElement txtLinkURL;

    @FindBy(id="link_description")
    WebElement txtLinkDescription;

    @FindBy(id = "publish")
    WebElement btnPublish;

    @FindBy(id = "tag-name")
    WebElement txtTagName;

    @FindBy(id="tag-slug")
    WebElement txtTagSlug;

    @FindBy(id="tag-description")
    WebElement txtTagDescription;

    @FindBy(id = "submit")
    WebElement btnSubmit;

    @FindBy(css = "#cb > input[type=\"checkbox\"]")
    WebElement checkboxSelectAll;

    @FindBy(id = "doaction")
    WebElement btnApply;

    @FindBy(name = "action")
    WebElement comboboxAction;

    @FindBy(css = "div.tablenav.bottom > div.tablenav-pages.one-page > span.displaying-num")
    WebElement lblItemsCount;

    @FindBy(linkText = "Test Link")
    WebElement linkTestLink;

    @FindBy(id = "link-search-input")
    WebElement txtSearch;

    @FindBy(id = "search-submit")
    WebElement btnSearch;

    @FindBy(linkText = "All Links")
    WebElement linkAllLinks;

    public DemositeLinksPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeLinkName(String linkName){txtLinkName.sendKeys(linkName);}
    public void typeLinkURL(String linkURL){txtLinkURL.sendKeys(linkURL);}
    public void typeLinkDescription(String linkDescription){txtLinkDescription.sendKeys(linkDescription);}
    public void clickAddLink(){btnPublish.click();}
    public void clickTestLink(){linkTestLink.click();}

    public void typeCategoryName(String categoryName){txtTagName.sendKeys(categoryName);}
    public void typeCategorySlug(String categorySlug){txtTagSlug.sendKeys(categorySlug);}
    public void typeCategoryDescription(String categoryDescription){txtTagDescription.sendKeys(categoryDescription);}
    public void clickAddCategory(){btnSubmit.click();}

    public void clickSelectAll(){checkboxSelectAll.click();}
    public void clickApply(){btnApply.click();}

    public void navigateAllLinksPage(){linkAllLinks.click();}

    public void typeSearch(String searchText){txtSearch.sendKeys(searchText);}
    public void clickSearch(){btnSearch.click();}

    public void addNewLink(String linkName, String linkURL, String linkDescription){
        typeLinkName(linkName);
        typeLinkURL(linkURL);
        typeLinkDescription(linkDescription);
        clickAddLink();
    }

    public void updateLink(String linkName, String linkURL, String linkDescription){
        txtLinkName.clear();
        txtLinkURL.clear();
        txtLinkDescription .clear();
        typeLinkName(linkName);
        typeLinkURL(linkURL);
        typeLinkDescription(linkDescription);
        clickAddLink();
    }

    public void searchLink(String linkName){
        typeSearch(linkName);
        clickSearch();
    }

    public void addNewCategory(String categoryName, String categorySlug, String categoryDescription){
        typeCategoryName(categoryName);
        typeCategorySlug(categorySlug);
        typeCategoryDescription(categoryDescription);
        clickAddCategory();
    }

    public void selectAction(String action){
        new Select(comboboxAction).selectByVisibleText(action);
    }

    public void deleteAllCategories(){
        clickSelectAll();
        selectAction("Delete");
        clickApply();
    }

    public boolean verifyItemsCount(String itemsCount){
        return lblItemsCount.getText().equals(itemsCount);
    }
}
