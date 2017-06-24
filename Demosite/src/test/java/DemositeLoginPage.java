import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by MARCELO on 24/06/2017.
 */
public class DemositeLoginPage {
    WebDriver driver;

    @FindBy(id="user_login")
    WebElement txtUser;

    @FindBy(id = "user_pass")
    WebElement txtPass;

    @FindBy(id = "wp-submit")
    WebElement btnSubmit;

    public DemositeLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){
        this.txtUser.sendKeys(user);
    }

    public void typePass(String pass){
        this.txtPass.sendKeys(pass);
    }
    public void loginUser(String user, String pass){
        this.typeUser(user);
        this.typePass(pass);
        btnSubmit.click();
    }
}
