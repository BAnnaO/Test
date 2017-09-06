
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class PnTest extends BaseTest {

    MainPage mainPage ;



    @BeforeClass(alwaysRun= true)
    public  void createDriver(){
        mainPage = new MainPage(DriverFactory.getDriver());
    }
//This is a first test
    @Test
    public void firstTest(){

            mainPage.clickOncategoryButtonCompuer();
            mainPage.goToComputerPage();
        ComputerPage computerPage = mainPage.goToComputerPage();
            Assert.assertEquals(computerPage.itServiceString.getText(),"IT услуги");
    }
//This is a second test
    @Test @Ignore
    public void secondTest(){
        mainPage.clickOncategoryButtonRemont();
        RemontPage remontPage = mainPage.goToRemontPage();
        remontPage.clickOnCategoryPlitka();
        remontPage.clickOnSorting();
        remontPage.clickOnSortPrice();
        ArrayList<Integer> prises= remontPage.getAllPrises();
        ArrayList<Integer> sortedPrices=(ArrayList<Integer>)prises.clone();
        Collections.sort(sortedPrices);

        Assert.assertEquals(prises,sortedPrices);
    }

    @Test
    public void thriedTest(){
        mainPage.clickOncategoryButtonKomods();
        KomodPage komodPage = mainPage.goToKomodPage();
        try {
            komodPage.clickOnpopularProducer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String popProd = komodPage.getCurrentProducer();
        for (String str:komodPage.getItemsList()){
            System.out.println(popProd+"  "+str);
            Assert.assertTrue(str.contains(popProd));

        }

    }

    @Test
    public void fourthTest(){
        mainPage.clickOncategoryButtonKomods();
        KomodPage komodPage = mainPage.goToKomodPage();
        int NumOfItems=komodPage.getNumOfItems();
        try {
            komodPage.clickOnpopularProducer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(NumOfItems,komodPage.numOfitems);


    }

    
    @AfterMethod
    public void goToMain(){
        DriverFactory.getDriver().get(mainPage.pageUrl);
    }
}
