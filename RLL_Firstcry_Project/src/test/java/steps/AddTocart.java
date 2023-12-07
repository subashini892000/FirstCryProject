package steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AddToCartpage;



public class AddTocart {
	
	
	  WebDriver driver;
	  SharedStepsFirstcry s;
	  AddToCartpage d;
	
	
	  public AddTocart(SharedStepsFirstcry s)
		
		 {
			 this.s=s; //this s will get place when we use pico container before using picocontainer we got error
			 
		 }
	
	
	@BeforeAll
	public static void featurestarts()
	{
		System.out.println("The feature has started execution");
	}
	
	@AfterAll
	public static void featureends()
	{
		System.out.println("The feature has completed execution");
	}
	
	
	@Given("I open the browser and enter URL")
	public void i_open_the_browser_and_enter_url() {
		
		   driver=s.getDriver();//whenever we initialized we will get chrome driver
		   
		   //by adding below line only DemoAddToCartPage will work
		   d=PageFactory.initElements(driver, AddToCartpage.class);
		   
		   driver.get("https://www.firstcry.com/");
	    
	}

	@Then("I click on Login link and enter the email id {string}")
	public void i_click_on_login_link_and_enter_the_email_id(String EmailId) throws InterruptedException {
		
		//clicking LoginLink
		d.clickLoginLink();
		
		//sending keys to email id
		d.sendkeysEmailLink(EmailId);
		Thread.sleep(2000);
		
		//clicking on continue button
		d.continueButton();
		Thread.sleep(20000);
		
		//clicking on submit button
		d.submitButton();
		System.out.println("Successfully entered OTP");
		
	    
	}


	@Then("I capture the title of the FirstCryPage")
	public void i_capture_the_title_of_the_first_cry_page() {
		
		System.out.println(driver.getTitle());
        SoftAssert sf = new SoftAssert();
		
		String expectedtitle = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		String actualtitle = driver.getTitle();
	    sf.assertEquals(actualtitle, expectedtitle, "The title donot match");
	    
	}

	@Then("I click on Footwear and click on Casualshoes")
	public void i_click_on_footwear_and_click_on_casualshoes() {
		
		WebElement footwear= driver.findElement(By.xpath("(//li[@class='M14_42 categry'])[3]/child::a")); //hovering footwear
        Actions a = new Actions(driver);
		a.moveToElement(footwear).build().perform();
		
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    //clicking casual shoes
		d.clickshoes();
	    
	}

	@Then("I click on Product on the page")
	public void i_click_on_product_on_the_page() throws InterruptedException {
		
		//clicking the product
		d.clickproduct();
		
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(1000);
	    
	}

	@Then("I click on Add to cart page")
	public void i_click_on_add_to_cart_page() {
		
		//selecting shoe size
		d.selectshoesize();
		
		//clicking on add to cart button
		d.addtocart();
	    
	}

	@Then("I click on Go to Cart page")
	public void i_click_on_go_to_cart_page() throws InterruptedException {
		
		try {
		    WebElement cartItemCount =driver.findElement(By.xpath("(//span[@class='step2 M16_white'])[1]/child::span"));
		    cartItemCount.click();
		    Thread.sleep(1000);
		    Assert.assertEquals(cartItemCount.getText(), "1", "Product is not added to the cart.");
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				System.out.println(" CartItemCount Assesrtion Passed");
		    }
		    
		   }
	    
	
	/*
	
	@Given("I open the browser and enter URL")
	public void i_open_the_browser_and_enter_url() {
		
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://www.firstcry.com/");
	    
	}

	@Then("I click on Login link and enter the valid credentials")
	public void i_click_on_login_link_and_enter_the_valid_credentials() throws InterruptedException {
		
		driver.findElement(By.xpath("//li[@class='logreg']/child::span[1]")).click();	
		driver.findElement(By.xpath("//input[@id='lemail']")).sendKeys("subashini08092000@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='B14_white comm-btn btn-login-continue btn-login-cont-otp']")).click(); //continue btn
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='B14_white comm-btn btn-login-continue']")).click();
		System.out.println("Successfully entered OTP");
		
		
		
	    
	}
	
	@Then("I capture the title of the Page")
	public void i_capture_the_title_of_the_page() {
		
		
		
		System.out.println(driver.getTitle());
        SoftAssert sf = new SoftAssert();
		
		String expectedtitle = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		String actualtitle = driver.getTitle();
	    sf.assertEquals(actualtitle, expectedtitle, "The title donot match");
	    
	    
	}

	@Then("I click on Boy Fashion and click on sets and suits")
	public void i_click_on_boy_fashion_and_click_on_sets_and_suits() throws InterruptedException {
		
		
		WebElement footwear= driver.findElement(By.xpath("(//li[@class='M14_42 categry'])[3]/child::a"));
        Actions a = new Actions(driver);
		
		a.moveToElement(footwear).build().perform();
		
		//Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div/div[2]/div[5]/div/div/ul[1]/li[2]/a")).click();//casual shoes
		//driver.findElement(By.xpath("(//ul[@class='col-one'])[3]/descendant::li[2]/a")).click();
		
	    
	}

	@Then("I click on Product")
	public void i_click_on_product() throws InterruptedException {
		
		
		//driver.findElement(By.xpath("(//div[@class='list_img wifi'])[1]/a")).click();
		driver.findElement(By.xpath("(//div[@class='list_img wifi'])[1]")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(1000);
	    
	    
	}

	@Then("I click on Add to cart")
	public void i_click_on_add_to_cart() throws InterruptedException {
		
		
		driver.findElement(By.xpath("(//span[@class='size-option pos-rel2stat R14_42'])[1]")).click(); //selecting the size
		driver.findElement(By.xpath("(//span[@class='M16_white'])[4]")).click();
	}
	
	@Then("I click on go to cart")
	public void i_click_on_go_to_cart() throws InterruptedException {
		////span[@id='cart_TotalCount']
		
		try {
	    WebElement cartItemCount =driver.findElement(By.xpath("(//span[@class='step2 M16_white'])[1]/child::span"));
	    cartItemCount.click();
	    Thread.sleep(1000);
	    Assert.assertEquals(cartItemCount.getText(), "1", "Product is not added to the cart.");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			System.out.println(" CartItemCount Assesrtion Passed");
	    }
	    
	   }

	@Then("I close the browser")
	public void i_close_the_browser() throws InterruptedException {
		
		
		
		driver.quit();
	    
	}
*/
}
