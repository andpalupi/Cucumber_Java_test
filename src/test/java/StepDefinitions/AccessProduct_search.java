package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.homePage;
import org.testng.asserts.SoftAssert;

public class AccessProduct_search {

	WebDriver driver = null;
	homePage home;
	private By resultElement = By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div[1]/div[1]");
	private String webURL = "https://evermos.com/catalog";
	
	@Given("open browser")
	public void open_browser() {
		System.out.println("Inside step - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path "+ projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();

		home = new homePage(driver);
	}
	
	@When("home web page")
	public void home_web_page() throws InterruptedException {
		System.out.println("Inside step - user is on home web page");
		driver.navigate().to(webURL);
		Thread.sleep(6000);
	}

	@And("user login")
	public void user_login() throws InterruptedException {
		System.out.println("Inside step - user is on login page");
		home.login();
		Thread.sleep(6000);
		
	}
	
	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		System.out.println("Inside step - user enters a text in search box");
		home.entertext();
		Thread.sleep(3000);
	}
	
	@And("user click enter")
	public void user_click_enter() throws InterruptedException {
		System.out.println("Inside step - user click enter");
		home.clickEnter();
		Thread.sleep(3000);		
	}
	
	@When("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		System.out.println("Inside step - user is navigated to search results");
		Thread.sleep(4000);

	}
	
	@Then("verify search result")
	public void verify_search_result() throws InterruptedException {
		System.out.println("Inside step - verify search results");
		SoftAssert softAssert = new SoftAssert();
	    
		List<WebElement> products = driver.findElements(resultElement);
		for(WebElement product : products) {

			String x = "baju renang muslim";
			Boolean actualtext = (driver.getPageSource().contains(x));
			
			if (driver.getPageSource().contains(x)) {
				System.out.println(x + " string is present");
			}
			else {
				softAssert.assertFalse(actualtext, x + " string is not present"); 
				softAssert.assertAll();
			}
	    }
		Thread.sleep(30000);
		
		driver.close();
		driver.quit();
	      
	}
	
	
}
