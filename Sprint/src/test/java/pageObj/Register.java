package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {

	WebDriver driver;
	
	//constructor
		public Register(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\'wrapper\']/div/div/header/div[2]/div[2]/div[1]/button[1]")
		@CacheLookup
		WebElement signup;
		
		@FindBy(xpath="//*[@id=\'FirstName\']")
		@CacheLookup
		WebElement fname;
		
		@FindBy(id="LastName")
		@CacheLookup
		WebElement lname;
		
		@FindBy(id="Email")
		@CacheLookup
		WebElement email;
		
		@FindBy(id="Password")
		@CacheLookup
		WebElement pass;
		
		@FindBy(id="Password2")
		@CacheLookup
		WebElement cpass;
		
		@FindBy(id="PrimaryDiningCityId")
		@CacheLookup
		WebElement location;
		
		
		@FindBy(xpath="//*[@id=\'OptinRule_EmailMarketing_DefaultOptIn\']")
		@CacheLookup
		WebElement check;
		
		
		@FindBy(xpath="//*[@id=\'registerForm\']/button")
		@CacheLookup
		WebElement register;
		
		@FindBy(xpath="//iframe[@title='Sign up']")
		@CacheLookup
		WebElement fr;
		
		@FindBy(xpath="//*[@id=\"wrapper\"]/div/div/header/div[2]/div[2]/div[1]/div/div[1]/button")
		@CacheLookup
		WebElement btn;
		
		@FindBy(xpath="//*[@id=\"wrapper\"]/div/div/header/div[2]/div[2]/div[1]/div/div[1]/div/span")
		@CacheLookup
		WebElement success;
		
		public WebElement getFrame() {
			return fr;
		}
		public void switchframe()
		{
			driver.switchTo().frame(fr);
		}
		public WebElement signupbtn() {
			return signup;
		}
		public WebElement enterfname() {
			return fname;
		}
		public WebElement enterlname() {
			return lname;
		}
		public WebElement enteremail() {
			return email;
		}
		public WebElement password() {
			return pass;
		}
		public WebElement confirmpassword() {
			return cpass;
		}
		public Select location() {
			
			return new Select(location);
		}
		public WebElement checkbox() {
			return check;
		}
		public WebElement register() {
			return register;
		}
		public WebElement icon() {
			return btn;
		}
		public WebElement verifyreg() {
			return success;
		}
		public void exitframe()
		{
			driver.switchTo().defaultContent();
		}
}
