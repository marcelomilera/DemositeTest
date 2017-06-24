import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by MARCELO on 24/06/2017.
 */
public class DemositeLoginPage {
    WebDriver driver;

    @FindBy(id="title")
    WebElement txtTitle;

    @FindBy(css = "html")
    WebElement frameText;

    public DemositeLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeTitle(String title){
        this.txtTitle.sendKeys(title);
    }

    public void typeText(String text){
        this.frameText.sendKeys(text);
    }
    public void insertPost(String title, String text){
        this.typeTitle(title);
        this.typeText(text);
    }
}
