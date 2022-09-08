package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriver;
import org.openqa.selenium.*;

public class homePage {

	protected WebDriver driver;
	
	private By txt_searchbar = By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/form/input");
	private By txt_login_username = By.xpath("//*[@id=\"__layout\"]/div/div[1]/form/label[1]/span[2]/input");
	private By txt_login_password = By.xpath("//*[@id=\"__layout\"]/div/div[1]/form/label[2]/span[2]/input");
	private By txt_click_Masuk = By.xpath("//*[@id=\"__layout\"]/div/div[1]/form/div[2]/button");
	private By txt_click_search = By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/a[1]/span");
	private String data_username = "6281223334444";
	private String data_password = "password";
	private String search_text = "baju renang muslim";
	
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickEnter() {
//		WebElement enter = driver.findElement(By.id("Value"));
//		enter.sendKeys(Keys.ENTER);
		
		WebElement enter = driver.findElement(txt_searchbar);
		enter.sendKeys(Keys.ENTER);
	}

	public void entertext(){
		WebElement clickSearch = driver.findElement(txt_click_search);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", clickSearch);	
		
		WebElement searchbar = driver.findElement(txt_searchbar);
		searchbar.sendKeys(search_text);		
	}
	
	public void login() {
		WebElement usernamme = driver.findElement(txt_login_username);
		usernamme.sendKeys(data_username);
		WebElement password = driver.findElement(txt_login_password);
		password.sendKeys(data_password);

		WebElement Masuk = driver.findElement(txt_click_Masuk);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", Masuk);	
	}
}
