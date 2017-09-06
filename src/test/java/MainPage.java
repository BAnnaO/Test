import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    ComputerPage computerPage;
    RemontPage remontPage;
    KomodPage komodPage;

    MainPage(WebDriver driver){
        super(driver);
        pageUrl="https://pn.com.ua";
        driver.get(pageUrl);
    }



    private final static String CATEGORY_BUTTON_COMPUTER="//div[@class='pc-block']/a[@href='/computer/']";
    private final static String CATEGORY_BUTTON_REMONT="//div[@class='pc-block']/a[@href='/remont/']";
    private final static String CATEGORY_BUTTON_KOMODS="//ul[@class='prb-menu']//a[@href='/ct/5260/']";


    @FindBy(xpath = CATEGORY_BUTTON_COMPUTER)
    protected WebElement categoryButtonComputer;

    @FindBy(xpath = CATEGORY_BUTTON_REMONT)
    protected WebElement getCategoryButtonRemont;

    @FindBy(xpath = CATEGORY_BUTTON_KOMODS)
    protected WebElement categoryButtonKomods;



    public void clickOncategoryButtonCompuer(){
        try {
            clicker.elementclickerWebElement(categoryButtonComputer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickOncategoryButtonRemont(){
        try {
            clicker.elementclickerWebElement(getCategoryButtonRemont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickOncategoryButtonKomods(){
        try {
            clicker.elementclickerWebElement(categoryButtonKomods);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ComputerPage goToComputerPage(){
        computerPage = new ComputerPage(this.driver);
        return computerPage;
    }

    public RemontPage goToRemontPage(){
        remontPage = new RemontPage(this.driver);
        return remontPage;
         }


    public KomodPage goToKomodPage(){
        komodPage = new  KomodPage(this.driver);
        return  komodPage;
    }

}
