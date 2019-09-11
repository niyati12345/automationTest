package Group;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegisterSuccefully {
    protected static WebDriver driver;



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
        driver.get("https://demo.nopcommerce.com/");
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
        driver.findElement(By.xpath("//textarea[@placeholder='Enter personal message (optional).']")).sendKeys("hi");
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
    public void userShouldSelectJewelry(){
        //click on Jewelry
     driver.findElement(By.linkText("Jewelry")).click();
     //click on 700.00 - $3,000.00
        driver.findElement(By.xpath("//a[@href='//demo.nopcommerce.com/jewelry?price=700-3000']")).click();
        //verify the tile (check filter by price) expected result for jeweley
       String expectedJewelry="Jwellery";
       String actualJewelry=driver.findElement(By.tagName("h1")).getText();

        String expectedResultRange = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
        //replacing characters like $ and ,
        String replaceString = String.valueOf(expectedResultRange.replace("$", ""));
        String replaceString2 = String.valueOf(replaceString.replace(",",""));
        //converting double to int
        double price = Double.valueOf(replaceString2);
        //Actual Result
        Assert.assertTrue( price >= 700 && price <= 3000);

       //Assert.assertEquals(actualJewelry,expectedJewelry);
        //check price $700.00 - $3,000.00
     //  String actualrange= driver.findElement(By.xpath(" Assert.assertEquals(expectedMessage, actualMessage);")).getText();
        //Assert.assertFalse();
    }
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
        Assert.assertEquals(actualr,expectr);
    }
}
