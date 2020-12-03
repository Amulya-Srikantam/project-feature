package parameter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObj.Login;

public class Excelsheet {
	WebDriver driver;
	Properties or;
	Login lp;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");;
		driver = new ChromeDriver();
		driver.manage().window().maximize();                         //to maximize window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FileReader f2=new FileReader("objectrepo.properties"); //for object repository file
		or= new Properties();
		or.load(f2);//to maximize window
		driver.get(or.getProperty("url"));    
	}
	
	@Test(dataProvider="user")
	public void verify(String email, String pass) throws Exception
	{
		
		Thread.sleep(1500);
		lp= new Login(driver);
		System.out.println("click on Signin button");
        lp.signinbtn().click();
        Thread.sleep(2000);
        lp.switchframe();
		
		 System.out.println("user enter invalid email:" +email);
	       lp.email().sendKeys(email);
	       System.out.println("user gives invalid password :"+pass);
	    	 lp.password().sendKeys(pass);
	    	 lp.loginbtn().click();
		       System.out.println("Invalid login credentials message dispayed as:");
		       Thread.sleep(2000);
//		       String s=lp.msg().getAttribute("id");
		       String s1=lp.msg().getText();
//		       System.out.println(s);
		       System.out.println(s1);
		       lp.exitframe();
		
	}
	
	@DataProvider(name="user")
	public String[][] data() throws Exception
	{
		String[][] arrobj = getDataFromXLSX("TestData.xlsx");
		return arrobj;

	}
public String[][] getDataFromXLSX(String filename) throws Exception
{
	String[][] array=null;
	
	FileInputStream fs = new FileInputStream(filename);
	XSSFWorkbook wb = new XSSFWorkbook(fs);
	XSSFSheet sh= wb.getSheetAt(0);
	XSSFRow rows;
	XSSFCell cell;
	
	int rowCount = sh.getLastRowNum();
	int columnCount = sh.getRow(0).getLastCellNum();
	
	array=new String[rowCount][columnCount];
	
	for(int i=1;i<rowCount+1;i++)
	{
		for(int j=0;j<columnCount;j++)
		{
			rows=sh.getRow(i);
			cell=rows.getCell(j);
			array[i-1][j] = cell.getStringCellValue();
		}
	}
	return array;
}
@AfterMethod 
public void teardown()
{
	driver.close();
}

}
