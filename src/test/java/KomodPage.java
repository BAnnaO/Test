import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KomodPage extends AbstractPage {

private static final Random random=  new Random();
private String currentProducer;
public int numOfitems;
ArrayList<String> itemsList = new ArrayList<>();


   public KomodPage(WebDriver driver){
        super(driver);
        pageUrl="https://pn.com.ua/ct/5260/";
        driver.get(pageUrl);
    }

    private static final int num = random.nextInt(7)+1;
    private  static final String POPULAR_PRODUCER="//span[@class='popular'][3]/a";
   // private  static final String POPULAR_PRODUCER="//span[@class='popular']["+num+"]/a";
    private static final String ITEM1 = "//ul[@class='catalog-list']/li[";
    private static final String ITEM2 = "]//img";
    private static final String NEXT_PAGE="//link[@rel='next']";
    private static final String NUM_OF_ITEMS="//span[@class='popular'][3]/small";



    @FindBy(xpath = POPULAR_PRODUCER)
    protected WebElement popularProducer;// =driver.findElement(By.xpath(POPULAR_PRODUCER));

    @FindBy(xpath = NUM_OF_ITEMS)
    protected WebElement numOfItems;


    @FindBy(xpath = NEXT_PAGE)
    protected WebElement nextPage;


    public void clickOnpopularProducer() throws Exception{
        currentProducer=popularProducer.getText();
        boolean flag=false;
        int i=0;
        do
    {
        try {
            clicker.elementclickerWebElement(popularProducer);
            flag=false;
        } catch (StaleElementReferenceException e) {
            flag=true;
           // System.out.println(i++);
            DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                clicker.elementclickerWebElement(driver.findElement(By.xpath("//div[@id='total-producers']/a[@class='show-all']")));
            }catch (ElementNotVisibleException exs){}

        }
    }while(flag==true);


    }

    public void clickOnnextPage() throws Exception{
            clicker.elementclickerWebElement(nextPage);
    }


    public ArrayList<String> getItemsList(){
        boolean flag=true;
        int i=1;

        while (flag){
            try {
                itemsList.add(driver.findElement(By.xpath(ITEM1+i+ITEM2)).getAttribute("alt"));
                i++;
            }catch (Exception e){
               try{
                    clickOnnextPage();
                }catch (ElementNotVisibleException ex){
                   flag=false;
                   break;
               }catch (NoSuchElementException ex){
                   flag=false;
                   break;
               }catch (Exception exx){
                    e.printStackTrace();
               }

            }

        }
        return itemsList;
   }

   public String getCurrentProducer(){
       return currentProducer;
   }
   public int getNumOfItems(){
       numOfitems = Integer.getInteger(numOfItems.getText().replace("+",""));
       boolean flag=true;
       int i=1;
       while (flag){
           try {
               driver.findElement(By.xpath(ITEM1+i+ITEM2));
               i++;
           }catch (Exception e){
               try{
                   clickOnnextPage();
               }catch (ElementNotVisibleException ex){
                   flag=false;
                   break;
               }catch (NoSuchElementException ex){
                   flag=false;
                   break;
               }catch (Exception exx){
                   e.printStackTrace();
               }

           }

       }
return i;
   }

}
