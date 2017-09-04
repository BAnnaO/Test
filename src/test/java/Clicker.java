import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Clicker {
    private WebDriver driver;
    public Clicker(WebDriver driver){
        this.driver=driver;
    }

    public void elementclickerWebElement(WebElement element){
        try{
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
