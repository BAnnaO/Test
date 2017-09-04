import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;
    protected Clicker clicker;
    public String pageUrl;

    AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        clicker = new Clicker(this.driver);
    }
}
