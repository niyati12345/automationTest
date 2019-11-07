package Group;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterSuccefully extends Utils {
    //protected static WebDriver driver;
LoadProp loadProp=new LoadProp();


    public static String randomDate(){
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }

    //to run before method
    @BeforeMethod
    public void openBrowser()
     {
        System.setProperty("webdriver.chrome.driver","src\\main\\Resource\\BrowserDrive\\chromedriver.exe");
        //open the brwser
        driver  = new ChromeDriver();
        //maximise the browser window screen
        driver.manage().window().fullscreen();
        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //open the website
        driver.get(loadProp.getProperty("Url"));
     }
      //to run after method
      @AfterMethod
      public void closeBrowser()
      {// quit driver
        //driver.close();

      }
    //User should able to register
    @Test(priority = 0)
    public void userShouldAbleToRegisterSuccessfully(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("niyati");
        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("patel");
        System.out.println();
        driver.findElement(By.name("Email")).sendKeys("testte1st" + randomDate()+ "@test.com");
        //enter password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //re-enter same password to confirm
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register
        driver.findElement(By.name("register-button")).click();

        //expected result
        String expectedresult="Thanks for registration";
        //actual result
        String actual=driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

        //Comparing actual and expected result
        Assert.assertEquals(actual,expectedresult);


    }
    @Test(priority = 1)
    public void userShouldAbletoSendAnEmail(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("niyati");
        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("patel");
        System.out.println();
        driver.findElement(By.name("Email")).sendKeys("testte1st" + randomDate()+ "@test.com");
        //enter password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //re-enter same password to confirm
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register
        driver.findElement(By.name("register-button")).click();

        driver.findElement(By.name("register-continue")).click();
        driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
        // driver.findElement(By.xpath("//h2/a[@href=\"/electronics\"]")).click();
        //aend a email
        driver.findElement(By.xpath("//div[@class='email-a-friend']")).click();
        //friends email
        driver.findElement(By.className("friend-email")).sendKeys("niyati141193@gmail.com");
        //your email
        //input[@class="your-email"]
        //driver.findElement(By.xpath("//input[@class=\"your-email\"]")).;
        //message
        driver.findElement(By.xpath("//textarea[@placeholder='Enter personal message (optional)]")).sendKeys("hi");
        //send email
        driver.findElement(By.name("send-email")).click();

        //compare the send message
        String expectresult="Your message has been sent.";
        String actualresult=driver.findElement(By.cssSelector("div.result")).getText();
        Assert.assertEquals(actualresult,expectresult);

    }
    @Test(priority = 2)
    public void userShouldNavigateToCameraAndPhoto()
    {//click on Electronics
     driver.findElement(By.linkText("Electronics")).click();
     //click on camera and photo
     driver.findElement(By.linkText("Camera & photo")).click();
     //need to verify expected ans actual message
     String expected="Camera & photo";
     String actual=driver.findElement(By.tagName("h1")).getText();
     Assert.assertEquals(expected,actual);
    }
    @Test(priority = 3)
        public  void userShouldbeabletoSelectJewelryByPrice() {
            //go to Jewelry category
            driver.findElement(By.linkText("Jewelry")).click();
            //select price$700-&3000
            driver.findElement(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]")).click();
            //find min range
            String minrange = driver.findElement(By.xpath("//span[@class=\"PriceRange\"][1]")).getText();
            //replace $ using string  replace() method
            String minrange1 = String.valueOf(minrange.replace("$", ""));
            //convert double to int
            double minrange2 = Double.valueOf(minrange1);
            //find max range
            String maxrange = driver.findElement(By.xpath("//span[@class=\"PriceRange\"][2]")).getText();
            String maxrange1 = String.valueOf(maxrange.replace("$", ""));
            String maxrange2 = String.valueOf(maxrange1.replace(",", ""));
            double maxrange3 = Double.valueOf(maxrange2);
            //Expected result value
            String myvalue = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
            String myvalue1 = String.valueOf(myvalue.replace("$", ""));
            String myvalue2 = String.valueOf(myvalue1.replace(",", ""));
            double myvalue3 = Double.valueOf(myvalue2);}

    @Test(priority = 4)
    public void userShouldAbleToAddTwoBooks()
    {//click on books
        driver.findElement(By.linkText("Books")).click();
     //click on specific
        driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();
     //click on add to cart
        driver.findElement(By.id("add-to-cart-button-37")).click();
        //click on cancel button
     driver.findElement(By.className("close")).click();
    // nagivate to back
        driver.navigate().back();
        //click on second back
        driver.findElement(By.linkText("First Prize Pies")).click();
        //click on add to cart
        driver.findElement(By.id("add-to-cart-button-38")).click();
        //click on close
        driver.findElement(By.className("close")).click();
        //click on shopping cart
        driver.findElement(By.linkText("Shopping cart")).click();
        //actual result
        String actualsku=driver.findElement(By.xpath("//span[text()='FR_451_RB']")).getText();
        //expected result
        String expectedsku="FR_451_RB";
        Assert.assertEquals(actualsku,expectedsku);
        String actualr=driver.findElement(By.xpath("//span[text()='FIRST_PRP'")).getText();
        String expectr="FIRST_PRP";
        //

    }@Test(priority = 0)
    public void books(){

        driver.findElement(By.linkText("Books")).click();
        //click on book Fahrenheit 451 by Ray Bradbury
        driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();
        //add the item in to cart
        driver.findElement(By.id("add-to-cart-button-37")).click();
        //click on close
        driver.findElement(By.className("close")).click();
        driver.navigate().back();
        //select the book Pride and Prejudice
        driver.findElement(By.linkText("Pride and Prejudice")).click();
        //add to cart the item
        driver.findElement(By.id("add-to-cart-button-39")).click();
        driver.findElement(By.className("close")).click();
        // addtional book
        driver.findElement(By.linkText("First Prize Pies")).click();
        //click on add to cart
        driver.findElement(By.id("add-to-cart-button-38")).click();
        driver.findElement(By.className("close")).click();
        //go to the shopping cart
        driver.findElement(By.linkText("Shopping cart")).click();

        List<WebElement> sku=driver.findElements(By.className("sku-number"));
        List <String> skuelement=new ArrayList<>();

        for(int i=0;i<sku.size();i++)
        {
            skuelement.add(sku.get(i).getText());
            System.out.println(sku.get(i).getText());
        }

        List<WebElement>expected=driver.findElements(By.className("product"));
        List<String>expectedelement=new ArrayList<>();

        for(int i=0;i<expected.size();i++)
        {
            expectedelement.add(expected.get(i).getText());
            System.out.println(expected.get(i).getText());
        }
        //converting expectedelement into array from array list
        String expected1[] = expectedelement.toArray(new String[expectedelement.size()]);
        System.out.println(Arrays.toString(expected1));

        String actual1[]=skuelement.toArray(new String[skuelement.size()]);
        System.out.println(Arrays.toString(actual1));

        Assert.assertEquals(expected1,actual1);
        //String expected1 [] = {"FR_451_RB", "PRIDE_PRJ"};
}}
