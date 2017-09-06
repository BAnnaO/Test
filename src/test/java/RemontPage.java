import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class RemontPage extends AbstractPage {

    private int numOfItems=24;

    RemontPage(WebDriver driver){
        super(driver);
        pageUrl="https://pn.com.ua/remont/";
        driver.get(pageUrl);
    }

    private final static String CATEGORY_PLITKA="//a[@href='/ct/4201/']";
    private final static String SORTING="//li[@class='dropdown dropdown-sorting']";
    private final static String SORT_PRICE="//a[@href='/ct/4201/?sort=price']";
    private static final String NEXT_PAGE="//link[@rel='next']";

    private static String PRICE1 = "//ul[@class='catalog-list']/li";
    private static String PRICE2 = "//div[@class='price']//strong";

    @FindBy(xpath = CATEGORY_PLITKA)
    protected WebElement categoryPlitka;

    @FindBy(xpath = SORTING)
    protected WebElement sorting;

    @FindBy(xpath = SORT_PRICE)
    protected WebElement sortPrice;

    public void clickOnCategoryPlitka(){
        try {
            clicker.elementclickerWebElement(categoryPlitka);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickOnSorting(){
        try {
            clicker.elementclickerWebElement(sorting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnSortPrice(){
        try {
            clicker.elementclickerWebElement(sortPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAllPrises()
    {
        ArrayList<Integer> prices = new ArrayList<>();
        WebElement el;
        for(int i=1;i<=numOfItems;i++){
            el=driver.findElement(By.xpath(PRICE1+"["+i+"]"+PRICE2));
          //  System.out.println(Integer.decode(el.getText().split(" ")[0]));
            prices.add(Integer.decode(el.getText().split(" ")[0]));
        }
        return prices;
    }


}
