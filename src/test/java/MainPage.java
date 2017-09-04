import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    ComputerPage computerPage;
    RemontPage remontPage;

    MainPage(WebDriver driver){
        super(driver);
        pageUrl="https://pn.com.ua";
        driver.get(pageUrl);
    }



    private final static String CATEGORY_BUTTON_COMPUTER="//div[@class='pc-block']/a[@href='/computer/']";
    private final static String CATEGORY_BUTTON_REMONT="//div[@class='pc-block']/a[@href='/remont/']";


    @FindBy(xpath = CATEGORY_BUTTON_COMPUTER)
    protected WebElement categoryButtonComputer;

    @FindBy(xpath = CATEGORY_BUTTON_REMONT)
    protected WebElement getCategoryButtonRemont;



    public void clickOncategoryButtonCompuer(){
        clicker.elementclickerWebElement(categoryButtonComputer);
    }
    public void clickOncategoryButtonRemont(){
        clicker.elementclickerWebElement(getCategoryButtonRemont);
    }

    public ComputerPage goToComputerPage(){
        computerPage = new ComputerPage(this.driver);
        return computerPage;
    }

    public RemontPage goToRemontPage(){
        remontPage = new RemontPage(this.driver);
        return remontPage;
         }


}
