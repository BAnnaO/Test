import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    Configuration c;

    public BaseTest(){
        c= new Configuration();
//        try {
//            setUp();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @BeforeTest(alwaysRun= true)
    public void setUp()throws Exception {
        DriverFactory.createDriver(c.browser);
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterTest(alwaysRun= true)
    public void tearDown()throws Exception{
        DriverFactory.getDriver().quit();
    }
}
