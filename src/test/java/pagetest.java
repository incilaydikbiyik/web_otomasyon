import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagetest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C://chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase() {

        WebDriver driver=new ChromeDriver();
        page login = new page(driver);

        login.openWebsite();
        login.clickLogin();
        login.enterEmail("testdenememaillllll@gmail.com");
        login.enterPassword("testşifre0");
        login.clickLoginButton();
        login.searchProduct("Bilgisayar");
        login.clickSearchIcon();
        login.chooseRandomProduct();
        login.addToBasket();
        login.goToBasket();
        login.getPriceFromBasket();
        login.productIncrement();
        login.deleteProductBasket();
        login.deleteFull();
        login.controlEmpty();


    }
}

