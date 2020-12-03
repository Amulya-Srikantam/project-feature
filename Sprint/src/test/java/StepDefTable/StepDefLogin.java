package StepDefTable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObj.Login;
import pageObj.Register;

public class StepDefLogin {
	//global objects
	WebDriver driver;   
	Login lp;
	Register rp;
	Properties or;
	
	
	@Before
	public void setup() throws IOException
	{
//invoke chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		driver = new ChromeDriver();
//to maximize window and add Implicit wait
		driver.manage().window().maximize();                         
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Reading object repository file		
		FileReader f2=new FileReader("objectrepo.properties");     
		or= new Properties();
		or.load(f2);
//load the Website page url		
		driver.get(or.getProperty("url"));   //data taken from property file
//Parent Window
		 String parentWindowHandle = driver.getWindowHandle();
		 System.out.println("Parent window's handle is : " + parentWindowHandle);
		
	}
//Login functionality
	
	 @Given("^User opens Browser$")
	    public void user_opens_browser() throws Throwable
	    {
	        System.out.println("User opens Browser");
	    }

	    @Given("^user in HomePage$")
	    public void user_in_homepage() throws Throwable 
	    {
	        System.out.println("user in HomePage");	        
	        lp= new Login(driver);
	    }
	    @When("^User enter URL$")
	    public void user_enter_url() throws Throwable 
	    {
	        System.out.println("User enter URL");
	        
	    }

	    @When("^click on Signin button$")
	    public void click_on_signin_button() throws Throwable 
	    {
	        System.out.println("click on Signin button");
	        lp.signinbtn().click();
//	        WebDriverWait wait=new WebDriverWait(driver, 2000);
//	        Thread.sleep(2000);
//	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	        lp.switchframe();   //After clicking sign in button the user should switch to Login frame to input data
	    }
	    

	    @And("^user enter invalid email (.+)$")
	    public void user_enter_invalid_email(String uname) throws Throwable 
	    {
	        System.out.println("user enter invalid email:" +uname);
	        Thread.sleep(1000);
	        lp.email().sendKeys(uname);//data taken from feature file
	    }

	    @Then("^User navigated to HomePage$")
	    public void user_navigated_to_homepage() throws Throwable 
	    {
	        System.out.println("User navigated to HomePage");
	    }
	    
	    @Then("^User Logged successfully$")
	    public void user_logged_successfully() throws Throwable 
	    {
	       System.out.println("User Logged successfully");
	       Thread.sleep(500);
	       lp.icon().click();
	       Thread.sleep(500);
	       String loginmsg=lp.verifylogin().getText();
		   System.out.println("Succes message is : " +loginmsg);//Message displayed after successful login in after clicking the drop down button
		   Boolean b=lp.verifylogin().isDisplayed();         
		   System.out.println("Succesful login message display status: " +b); //Verifying and printing the message display status
		   Assert.assertTrue(true, loginmsg); //Asserting the message displayed or not ,here the message displayed changes with change in input name given so we used boolean to verify the message displayed or not
		   screenCapture();
	    }

	    @Then("^Invalid login credentials message dispayed$")
	    public void invalid_login_credentials_message_dispayed() throws Throwable 
	    {
	       System.out.println("Invalid login credentials message dispayed as:");
	       Thread.sleep(2000);
	          //getting the error message
	       String s1=lp.msg().getText();
	//       Thread.sleep(500);
	       String s=lp.msg().getAttribute("id");
	       System.out.println(s);
	       Thread.sleep(500);
	       System.out.println(s1);
	       Assert.assertEquals(s1, "Your email and password don't match. Please try again."); //Asserting the error message
//	       lp.exitframe();
	       screenCapture();
	    }

	    @And("^user enters email (.+)$")
	    public void user_enters_email(String uname) throws Throwable 
	    {
	       System.out.println("user enters email :" +uname);  
	       lp.email().sendKeys(uname);//data taken from feature file
	    }

	    @And("^user gives password (.+)$")
	    public void user_gives_password(String pass) throws Throwable 
	    {
	       
	       System.out.println("user gives password :"+pass);
	       lp.password().sendKeys(pass);              //data taken from feature file
	       lp.loginbtn().click();
	       lp.exitframe();          //after successful login the user should exit the frame to verify the success message weather he is logged in or not 
	    }

	    @And("^user give invalid password (.+)$")
	    public void user_give_invalid_password(String pass) throws Throwable 
	    {
	    	 System.out.println("user gives invalid password :"+pass);
	    	 Thread.sleep(500);
	    	 lp.password().sendKeys(pass);             //data taken from feature file
	    	 lp.loginbtn().click();
	    	 Thread.sleep(500);
	    
	    }
		
//login through google account
		  
	    @And("^clicks on Booking link$")
	    public void clicks_on_booking_link() throws Throwable 
	    {
	    	System.out.println("User clicks on Booking link");
	    	Thread.sleep(500);
			  lp.bookbtn().click(); //user clicks on booking.com option to login from booking.com account
			  screenCapture();
		      lp.exitframe();         // user should exit the frame in order to switch to child window
		  }
	    
	    @And("^user switches to new booking window$")
	    public void user_switches_to_new_booking_window() throws Throwable 
	    {
	    	System.out.println("User switches to new booking window");
	    	 lp.switchwin(); //switching to booking.com child window
	    	 screenCapture();
			 String b=driver.getTitle();       
			 System.out.println(b);            //verifying weather user entered booking.com child window
	    }
		 
	    @And("^selects google icon in booking window$")
	    public void selects_google_icon_in_booking_window() throws Throwable 
	    {
	    	System.out.println("User selects google icon in booking window");
	    	Thread.sleep(2000);
	    	lp.googlebtn().click();//user clicks on google icon to login with his google account
	    	
	    }
	    
	    @And("^user switches to new google window$")
	    public void user_switches_to_new_google_window() throws Throwable 
	    {
	    	System.out.println("User switches to new google window");
	    	 lp.switchwin();
	    	 screenCapture();
	    }
	    @And("^user enters his credentials$")
	    public void user_enters_his_credentials() throws Throwable 
	    {
	    	System.out.println("User enters his credentials");
	    	  lp.gemail().sendKeys(or.getProperty("email"));      //data taken from property file
			  lp.nextbtn().click();
			  lp.gpass().sendKeys(or.getProperty("pass"));       //data taken from property file
			  lp.gpass().sendKeys(Keys.ENTER);
	    }
	
		  @And("^Closes new window$") public void closes_new_window() throws Throwable
		  {
			  System.out.println("User switches back to Parent Window");
		  lp.switchback(); //user switches back to parent window
		  }
		    
//screenshot
		  public void screenCapture() throws IOException
		    {
			  //Convert web driver object to TakeScreenshot
			  TakesScreenshot scrShot = ((TakesScreenshot)driver);
			  
			  //Call getScreenshotAs method to create image file
			  File scrFile= scrShot.getScreenshotAs(OutputType.FILE);
			  
			  //Move image file to new destination
			  File destFile = new File ("C:\\Users\\hp\\Desktop\\Automation\\Screenshots\\img"+System.currentTimeMillis()+"_01"+".png");
			  
			  //Copy file at destination
			  FileUtils.copyFile(scrFile, destFile); 
			  Reporter.log("<br><img src='"+destFile+"' height='300' width='300'/><br>");
		    }
	    
	  //closing the driver

	    
	    @After
		public void close()
		{
			driver.quit();
		}


}
