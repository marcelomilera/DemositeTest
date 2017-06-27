import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Cajas on 27/06/2017.
 */
public class DemositePagesPage {
    WebDriver driver;
    public DemositePagesPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "title")
    WebElement txtTitle;

    @FindBy(id="content")
    WebElement txtContent;

    @FindBy(id="save-post")
    WebElement btnDraft;

    @FindBy(id = "publish")
    WebElement btnPublish;

    @FindBy(name = "m")
    WebElement mDate;

    @FindBy(id = "post-query-submit")
    WebElement btnFilter;

    @FindBy(name = "post[]")
    WebElement rbtSelectPost;

    @FindBy(name = "action")
    WebElement maction;

    @FindBy(name = "post_author")
    WebElement mauthor;

    @FindBy(name = "comment_status")
    WebElement mstatus;

    @FindBy(id = "doaction")
    WebElement btnAction;

    @FindBy(id = "bulk_edit")
    WebElement btnEdit;

    @FindBy(className = "trash")
    WebElement linkTrash;

    @FindBy(id = "delete_all")
    WebElement btnDelete;

    @FindBy(id = "content-html")
    WebElement htmlText;

    @FindBy(linkText = "Pages")
    WebElement linkPages;

    @FindBy(className = "draft")
    WebElement linkDrafts;

    @FindBy(className = "publish")
    WebElement linkPublished;

    @FindBy(className = "add-new-h2")
    WebElement linkAdd;


    public void typeTitle(String title){this.txtTitle.sendKeys(title);}
    public void typeContent(String content){this.txtContent.sendKeys(content);}
    public void changeContent(){this.htmlText.click();}
    public void selectDate(String m){new Select(mDate).selectByVisibleText(m);}
    public void selectPost(){rbtSelectPost.click();}
    public void selectAction(String action){new Select(maction).selectByVisibleText(action);}
    public void selectAuthor(String post_author){new Select(mauthor).selectByVisibleText(post_author);}
    public void selectStatus(String comment_status){new Select(mstatus).selectByVisibleText(comment_status);}
    public void selectTrash(){linkTrash.click();}
    public void addDraft(){btnDraft.click();}
    public void addPublish(){btnPublish.click();}
    public void filterByDate(){btnFilter.click();}
    public void clickAction(){btnAction.click();}
    public void editPost(){btnEdit.click();}
    public void deletePost(){btnDelete.click();}
    public void setLinkPages(){linkPages.click();}
    public void setLinkDrafts(){linkDrafts.click();}
    public void setLinkPublished(){linkPublished.click();}
    public void setLinkAdd(){linkAdd.click();}

    public void AddDraftPage(String title, String content){
        this.typeTitle(title);
        this.changeContent();
        this.typeContent(content);
        this.addDraft();
    }

    public void AddPublishedPage(String title, String content){
        this.typeTitle(title);
        this.changeContent();
        this.typeContent(content);
        this.addPublish();
    }

    public void FilterDate(String m){
        this.selectDate(m);
        this.filterByDate();
    }

    public  void EditPost(String action){
        this.selectPost();
        this.selectAction(action);
        this.clickAction();
    }

    public void SaveChanges(String post_author, String comment_status){
        this.selectAuthor(post_author);
        this.selectStatus(comment_status);
        this.editPost();
    }

    public void DeletePost(String action){
        this.selectPost();
        this.selectAction(action);
        this.clickAction();
    }

    public void DeleteAll(){
        this.selectTrash();
        this.deletePost();
    }

}
