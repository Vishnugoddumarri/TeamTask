package stepdefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginStepDefination {
    WebDriver driver;
    String productName="Fruits";
    String category="Fresh Fruits";
   int numberOfProducts=2;



    @Given("^user is already on Home Page$")
    public void user_is_already_on_Home_Page()  {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.jiomart.com/");
        driver.manage().window().maximize();

    }


    @Then("^user clicks on search button$")
    public void user_clicks_on_search_button() {

        By nameOfProduct=By.xpath("//input[@id='search'][@autocomplete='off']");
        WebElement productElement= driver.findElement(nameOfProduct);
        productElement.sendKeys(productName);
        productElement.sendKeys(Keys.ENTER);

    }

    @Then("^user select By Availability Filter$")
    public void user_select_By_Availability_Filter()  {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        By availability=By.xpath("//input[@type='checkbox' and @class='ais-refinement-list--checkbox']");
        WebElement availabilityElement= driver.findElement(availability);
        availabilityElement.click();
    }

    @Then("^user select item Category Filter$")
    public void user_select_item_Category_Filter() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        By categoryFilter=By.xpath("//label[@class='ais-RefinementList-label']//span[text()='"+category+"']");
        WebElement categoryElement= driver.findElement(categoryFilter);
        categoryElement.click();
    }

    @Then("^user select by Brand$")
    public void userSelectByBrand() {
        By brandFilter=By.xpath("//input[@class='ais-RefinementList-checkbox'][@value='Loose']");
        WebElement brandFilterElement= driver.findElement(brandFilter);
        brandFilterElement.click();
    }

    @Then("^user gets Respective product names$")
    public int userGetsRespectiveProductNames() {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        By productNames=By.cssSelector("div[class='cat-item ']>a>span[class='clsgetname']");
        List<WebElement> productElement=driver.findElements(productNames);
        System.out.println(productElement.size());
        int count=productElement.size();
        for(int i=0;i<productElement.size();i++)
        {
            System.out.println("Name of product"+" "+i+":"+" "+productElement.get(i).getText());
        }
        return count;
    }

    @Then("^user clicks on add to cart button$")
        public void user_clicks_on_add_to_cart_button() {

        for(int i=1;i<=numberOfProducts;i++) {
            By AddToCart=By.xpath("//span[text()='Add to Cart']");
            WebElement AddToCartElement= driver.findElement(AddToCart);
            AddToCartElement.click();
        }

        }


    @Then("^user clicks on Cart button$")
    public void user_clicks_on_Cart_button()  {
        driver.findElement(By.xpath("//a[@class='cart_text']")).click();


    }

    @Then("^user removes the items in cart$")
    public void userRemovesTheItemsInCart() {
        for(int itemsNumber=1;itemsNumber<=numberOfProducts;itemsNumber++) {
            By remove = By.cssSelector("div[class='product-details']>div[class='product-itemdetails row']:nth-of-type("+itemsNumber+")>div>div>div[class='product-qty col float-right']>div>span:nth-of-type(1)");
            WebElement removeElement = driver.findElement(remove);
            removeElement.click();
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        }
    }

    @Then("^user closes the browser$")
    public void userClosesTheBrowser() {
        driver.quit();
    }

    
}
