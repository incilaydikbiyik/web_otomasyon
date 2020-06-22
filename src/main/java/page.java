
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;

public class page {
    WebDriver driver;

    public page(WebDriver myDriver) {
        driver = myDriver;
        PageFactory.initElements(myDriver, this);
    }

    public page openWebsite() {
        driver.navigate().to("https://www.trendyol.com/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("logo"));
        String title = element.getAttribute("title");
        if(title.equalsIgnoreCase("trendyol")){
            System.out.println("WEB PAGE IS OPENED");
        }
        return this;
    }

    String priceProduct = "";

    @FindBy(id = "accountBtn")
    private WebElement loginIcon;

    @FindBy(className = "loggedin-panel-container")
    private WebElement panelElement;

    @FindBy(id = ("email"))
    private WebElement emailInput;

    @FindBy(id = ("password"))
    private WebElement passwordInput;

    @FindBy(id = ("loginSubmit"))
    private WebElement loginButton;

    @FindBy (id = ("logged-in-container"))
    private WebElement accountCheck;

    @FindBy(className = "search-box")
    private WebElement searchData;

    @FindBy(className  = "search-icon")
    private WebElement searchBtn;

    @FindBy(className = "prc-slg")
    private WebElement priceFromProductPage;


    @FindBy(className = "add-to-bs-tx")
    private WebElement addBasket;


    @FindBy(className = "basket-item-count")
    private WebElement mybasket;

    @FindBy(className = "pb-basket-item-price")
    private WebElement priceFromBasket;

    @FindBy(className = "ty-numeric-counter-button")
    private WebElement productInc;

    @FindBy (className = ("basketItemQuantity ng-pristine ng-valid ng-touched"))
    private WebElement forSelect;

    @FindBy(className = "i-trash")
    private WebElement deleteFromBasket;

    @FindBy(css = ".btn-item.btn-remove")
    private  WebElement delete;

    @FindBy(css = ".col-lg-8.col-md-8.col-xs-8")
    private WebElement emptyBasketControl;


    public page clickLogin() {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(loginIcon));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginIcon).click().perform();
        loginIcon.click();
        return this;
    }

    public page enterEmail(String email) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public page enterPassword(String password) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public page clickLoginButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();


        return this;
    }

    public page checkAccountTruth(){

        Actions actions = new Actions(driver);
        actions.moveToElement(loginIcon).build().perform();

        String accountName = accountCheck.getText();

        if(accountName.equalsIgnoreCase("testdenememaillllll@gmail.com")){
            System.out.println("LOGIN OPERATION DONE");

        }
        return this;
    }


    public page searchProduct(String searchProduct) {

        //new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(searchData));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchData).click().perform();

        searchData.sendKeys(searchProduct);
        return this;
    }

    public page clickSearchIcon() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
        return this;
    }

//    public page clickSecondPage(){
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pageNumber));
//        pageNumber.click();
//        return this;
//    }

    public page chooseRandomProduct(){

        Random rand = new Random();
        int randint = rand.nextInt(24 );
        randint = randint+1;

        List<WebElement> searchResult = driver.findElements(By.className("p-card-wrppr"));

        searchResult.get(randint).click();

        return this;

    }


    public page addToBasket() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addBasket));

        WebElement element = driver.findElement(By.className("prc-slg"));
        String textprice2 = element.getText();
        priceProduct = textprice2;
        //priceProduct = priceFromProductPage.getText();
        addBasket.click();
        return this;
    }

    public page goToBasket() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(mybasket));
        mybasket.click();
        return this;
    }

    public page getPriceFromBasket() {
       // new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(priceFromBasket));


        WebElement element = driver.findElement(By.className("total-price"));
        String textprice = element.getText();

        //String priceBasket = priceFromBasket.getText();
        System.out.println(priceProduct);
        System.out.println(textprice);
        if(textprice.equalsIgnoreCase(priceProduct)){
            System.out.println("PRICES ARE EQUAL");
        }

        return this;
    }



    public page productIncrement() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(productInc));
        productInc.click();


//        String productAmount = driver.findElement(By.className("counter-content")).getCssValue();
//        if(productAmount.equalsIgnoreCase("2")){
//
//            System.out.println("THERE ARE 2 PRODUCTS");
//        }

        return this;
    }


    public page deleteProductBasket() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteFromBasket));
        deleteFromBasket.click();


        return this;
    }

    public page deleteFull(){

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(delete));
        delete.click();
        return this;

    }

    public page controlEmpty(){

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emptyBasketControl));
        if(emptyBasketControl.getText().equalsIgnoreCase("Sepetinizde ürün bulunmamaktadır.")){
            System.out.println("BASKET IS EMPTY");
        }
        return this;

    }



}

