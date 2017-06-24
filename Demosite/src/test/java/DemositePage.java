//package test.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by MARCELO on 24/06/2017.
 */
public class DemositePage {
    WebDriver driver;

    @FindBy(id="title")
    WebElement txtTitle;

    @FindBy(css = "html")
    WebElement frameText;

    public DemositePage(WebDriver driver){
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
