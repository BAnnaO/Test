
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class PnTest extends BaseTest {
    MainPage mainPage ;
    ComputerPage computerPage;
    RemontPage remontPage;


    @BeforeClass(alwaysRun= true)
    public  void createDriver(){
        mainPage = new MainPage(DriverFactory.getDriver());
    }
//This is a first test
    @Test
    public void firstTest(){

            mainPage.clickOncategoryButtonCompuer();
            mainPage.goToComputerPage();
            computerPage = mainPage.goToComputerPage();
            Assert.assertEquals(computerPage.itServiceString.getText(),"IT услуги");
    }
//This is a second test
    @Test
    public void secondTest(){
        mainPage.clickOncategoryButtonRemont();
        remontPage = mainPage.goToRemontPage();
        remontPage.clickOnCategoryPlitka();
        remontPage.clickOnSorting();
        remontPage.clickOnSortPrice();
        ArrayList<Integer> prises= remontPage.getAllPrises();
        ArrayList<Integer> sortedPrices=(ArrayList<Integer>)prises.clone();
        Collections.sort(sortedPrices);

        Assert.assertEquals(prises,sortedPrices);
    }

    
    @AfterMethod
    public void goToMain(){
        DriverFactory.getDriver().get(mainPage.pageUrl);
    }
}
