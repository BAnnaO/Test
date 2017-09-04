import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends AbstractPage {


    public ComputerPage(WebDriver driver){
        super(driver);
        pageUrl="https://pn.com.ua/computer";
        driver.get(pageUrl);

    }

    private final static String CATEGORY_BUTTON="";
    private final static String IT_SERVICE_href="//div[@class='column-wrapper']/article/div/ul/li/a[@href='/pr/1182/']";
    private final static String IT_SERVICE_STRING="//div[@class='column-wrapper']/article/div/ul/li/a[@href='/pr/1182/']/../../../div";

    @FindBy(xpath = CATEGORY_BUTTON)
    protected WebElement categoryButton;

    @FindBy(xpath = IT_SERVICE_STRING)
    protected WebElement itServiceString;

    @FindBy(xpath = IT_SERVICE_href)
    protected WebElement itServiceHref;

    public void clickOncategoryButton(){
        clicker.elementclickerWebElement(categoryButton);
    }
    public WebElement getItServiceHref(){return itServiceHref;}
    public WebElement getItServiceString(){return itServiceString;}

}
