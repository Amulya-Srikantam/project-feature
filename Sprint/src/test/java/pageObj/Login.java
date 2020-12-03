package pageObj;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	/*
	 * private By signin =By.xpath(
	 * "//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/button[2]");
	 * private By email = By.id("Email"); private By password = By.id("Password");
	 * private By login =By.id("signInButton"); private By fr
	 * =By.xpath("//iframe[@title='Sign in']");
	 */
	//constructor
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement signin;
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement email;

	@FindBy(id="Password")
	@CacheLookup
	WebElement password;

	@FindBy(id="signInButton")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="//span[@id='loginPopupValidationSummary']")
	@CacheLookup
	WebElement error;
	
	@FindBy(xpath="//button[@title='User account dropdown']")
	@CacheLookup
	WebElement btn;
	
	@FindBy(xpath="//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/div/div[1]/div/span")
	@CacheLookup
	WebElement success;
	
	@FindBy(xpath="//button[@class='social-login button with-icon button-social-login button-booking expand']")
	@CacheLookup
	WebElement book;
	
	@FindBy(xpath="//a[@aria-label='Sign in with Google']")
	@CacheLookup
	WebElement google;
	
	@FindBy(xpath="//input[@id='identifierId']")
	@CacheLookup
	WebElement gemail;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/div[2]")
	@CacheLookup
	WebElement next;
	
	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	@CacheLookup
	WebElement gpass;
	/*
	 * @FindBy(xpath=
	 * "//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/div/div[1]/button/div/span/svg/g/path")
	 * 
	 * @CacheLookup WebElement icon;
	 * 
	 * @FindBy(xpath=
	 * "//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/div/div[1]/div/span")
	 * 
	 * @CacheLookup WebElement loginpass;
	 */
	
	@FindBy(xpath="//iframe[@title='Sign in']")
	@CacheLookup
	WebElement fr;
	//method
	
	public WebElement getFrame() {
		return fr;
	}
	public WebElement signinbtn() {
		return signin;
	}
	public WebElement email() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement loginbtn() {
		return login;
	}
	public void switchframe()
	{
		driver.switchTo().frame(fr);
	}
	public WebElement icon() {
		return btn;
	}
	public WebElement msg() {
		return error;
	}
	public WebElement verifylogin() {
		return success;
	}
	public void exitframe()
	{
		driver.switchTo().defaultContent();
	}
	public WebElement bookbtn() {
		return book;
	}
	public WebElement gpass() {
		return gpass;
	}
	public WebElement gemail() {
		return gemail;
	}
	public WebElement googlebtn() {
		return google;
	}
	public WebElement nextbtn() {
		return next;
	}
	public void switchwin() {
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("Present number of windows open :" +allWin.size());
		for(String eachWin:allWin)
		{
		driver.switchTo().window(eachWin);
		}
	}

	public void switchback()
	{
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("Present number of windows open :" +allWin.size());
		for(String eachWin:allWin)
		{
		driver.switchTo().window(eachWin);
		break;
		}
		
	}
	
	/*
	 * public WebElement icon() { return icon; } public WebElement loginmsg() {
	 * return loginpass; }
	 */
	/*
	 * public void clicksignin() { driver.findElement(signin).click();
	 * driver.switchTo().frame(fr); }
	 * 
	 * 
	 * public void typeemail(String str) { driver.findElement(email).click();
	 * driver.findElement(email).sendKeys(str); } public void typepassword(String
	 * str) { driver.findElement(password).sendKeys(str); } public void clicklogin()
	 * { driver.findElement(login).click(); }
	 */
}
