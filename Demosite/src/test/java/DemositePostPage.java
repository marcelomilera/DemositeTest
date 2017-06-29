import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Hiraoka on 28/06/2017.
 */
public class DemositePostPage {
    WebDriver driver;

    @FindBy(id="title")
    WebElement txtPostTitle;

    @FindBy(id="content")
    WebElement txtPostContent;

    @FindBy(id="tag-name")
    WebElement txtCategoryName;

    @FindBy(id="tag-slug")
    WebElement txtCategoryTagSlug;

    @FindBy(name="parent")
    WebElement selectCategoryParent;

    @FindBy(name = "action")
    WebElement selectPostAction;

    @FindBy(name = "cat")
    WebElement selectCategory;

    @FindBy(id="tag-description")
    WebElement txtCategoryTagDesc;

    @FindBy(id="save-post")
    WebElement btnSavePost;

    @FindBy(id="publish")
    WebElement btnPublishPost;

    @FindBy(id="submit")
    WebElement btnAddCategory;

    @FindBy(id = "doaction")
    WebElement btnAction;

    @FindBy(id="post-query-submit")
    WebElement btnFilterCategory;

    @FindBy(linkText="All Posts")
    WebElement txtLinkAllPost;

    @FindBy(linkText="Categories")
    WebElement txtLinkCategories;

    @FindBy(css="li.draft > a")
    WebElement txtLinkDrafts;

    @FindBy(css="li.publish > a")
    WebElement txtLinkPublished;

    @FindBy(css="li.trash > a")
    WebElement txtLinkTrash;

    @FindBy(name = "post[]")
    WebElement rbtSelectPost;

    public DemositePostPage(WebDriver driver){
        this.driver = driver;
    }

    public void typePostTitle(String title){
        this.txtPostTitle.sendKeys(title);
    }

    public void typePostContent(String content){
        this.txtPostContent.sendKeys(content);
    }

    public void fillCategory(String cName,String cSlug, String cParent, String cDescription){
        this.txtCategoryName.sendKeys(cName);
        this.txtCategoryTagSlug.sendKeys(cSlug);
        new Select(selectCategoryParent).selectByVisibleText(cParent);
        this.txtCategoryTagDesc.sendKeys(cDescription);
    }

    public void savePost(String title, String text){
        this.typePostTitle(title);
        this.typePostContent(text);
        this.btnSavePost.click();
        this.txtLinkAllPost.click();
        this.txtLinkDrafts.click();
    }

    public void publishPost(String title,String text){
        this.typePostTitle(title);
        this.typePostContent(text);
        this.btnPublishPost.click();
        this.txtLinkAllPost.click();
        this.txtLinkPublished.click();
    }

    public void addCategory(String cName,String cSlug, String cParent, String cDescription){
        this.txtLinkCategories.click();
        this.fillCategory(cName,cSlug,cParent,cDescription);
        this.btnAddCategory.click();
    }

    public void movePostToTrash(String action){
        this.txtLinkAllPost.click();
        this.rbtSelectPost.click();
        new Select(selectPostAction).selectByVisibleText(action);
        btnAction.click();
    }

    public void filterByCategory(String category){
        this.txtLinkAllPost.click();
        new Select(selectCategory).selectByVisibleText(category);
        this.btnFilterCategory.click();
    }
}
