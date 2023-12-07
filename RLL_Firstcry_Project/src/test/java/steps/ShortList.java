package steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.ShortListPage;

public class ShortList {
	
	  WebDriver driver;
	  SharedStepsFirstcry s;
	  ShortListPage d;
	
	
	  public ShortList(SharedStepsFirstcry s)
		
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
	
	
	@Given("I open the browser and enter URL of Firstcry")
	public void i_open_the_browser_and_enter_url_of_Firstcry() {
		
		   driver=s.getDriver();//whenever we initialized we will get chrome driver
		   
		   //by adding below line only DemoAddToCartPage will work
		   d=PageFactory.initElements(driver, ShortListPage.class);
		   
		   driver.get("https://www.firstcry.com/");
	    
	}

	@Then("I click on login link and enter the email id {string}")
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


	

	@Then("I click on Footwear and click on Casualshoes product")
	public void i_click_on_footwear_and_click_on_casualshoes_product() {
		
		WebElement footwear= driver.findElement(By.xpath("(//li[@class='M14_42 categry'])[3]/child::a")); //hovering footwear
      Actions a = new Actions(driver);
		a.moveToElement(footwear).build().perform();
		
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    //clicking casual shoes
		d.clickshoes();
	    
	}

	@Then("I click on Products on the page")
	public void i_click_on_products_on_the_page() throws InterruptedException {
		
		//clicking the product
		d.clickproduct();
		
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(1000);
	    
	}
	@Then("I click on ShortList Icon")
	public void i_click_on_short_list_icon() throws InterruptedException {
		
		d.selectshoesize();
		d.shortlist();
		Thread.sleep(2000);
		
	    
	}

	@Then("I Go to ShortList Page")
	public void i_go_to_short_list_page() throws InterruptedException {
		
		d.shortlistIcon();
		Thread.sleep(3000);
	    
	}

	
	

}
