package Maven_PatientPortal.PatientPortal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PatientPortal 
{
	//Login data
		public WebDriver driver = null;
		public static String url = null;
		public static String username = null;
		public static String password = null;
		
		//Registration data
		public static String firstname = null;
		public static String middlename = null;
		public static String lastname = null;
		public static String gender = null;
		public static String date = null;
		public static String month = null;
		public static String year = null;
		
		public static String address1 = null;
		public static String address2 = null;
		public static String city = null;
		public static String state = null;
		public static String country = null;
		public static String zipcode = null;
		
		public static String phoneNumber = null;
		
		public static String relationType = null;
		public static String relationName = null;
				
		@Parameters({"TestURL","TestUsername","TestPassword","TestFirstname","TestMiddlename","TestLastname","TestGender","Testdate","Testmonth","Testyear"})
		@BeforeClass
		public void beforeRun(String TestURL, String TestUsername, String TestPassword, String TestFirstname, String TestMiddlename, String TestLastname, String TestGender, String Testdate, String Testmonth, String Testyear)
		{
			url = TestURL;
			username = TestUsername;
			password = TestPassword;
			
			firstname = TestFirstname;
			middlename = TestMiddlename;
			lastname = TestLastname;
			gender = TestGender;
			date = Testdate;
			month = Testmonth;
			year = Testyear;
		}
		
		@Test
		public void runTest()
		{
			Login();
			Logout();
			Registration();
		}
		
		//Login to application
		public void Login()
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().fullscreen();	
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath(".//*[@id='Registration Desk']")).click();
			driver.findElement(By.xpath(".//*[@id='loginButton']")).click();
			//driver.close();
		}
		
		//Logout from Application
		public void Logout()
		{
			driver.findElement(By.xpath("html/body/header/ul/li[3]/a")).click();
			driver.close();
		}
		
		//Registering a new patient
		public void Registration()
		{
			//Name
			driver.findElement(By.xpath(".//*[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();  
			driver.findElement(By.name("givenName")).sendKeys(firstname);
			driver.findElement(By.name("middleName")).sendKeys(middlename);
			driver.findElement(By.name("familyName")).sendKeys(lastname);
			
			//Gender
			driver.findElement(By.id("genderLabel")).click();
			driver.findElement(By.id("genderLabel")).click();
			
			if(gender.equals("Male"))
			{
				driver.findElement(By.xpath(".//*[@id='gender-field']/option[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath(".//*[@id='gender-field']/option[2]")).click();
			}
			
			//Birthday
			driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[1]/ul/li[3]")).click();
			driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[1]/ul/li[3]")).click();
			driver.findElement(By.id("birthdateDay-field")).sendKeys(date);		
			driver.findElement(By.id("birthdateMonth-field")).click();
			driver.findElement(By.id("birthdateMonth-field")).click();	
			Select dropdown = new Select(driver.findElement(By.id("birthdateMonth-field")));
			dropdown.selectByVisibleText(month);		
			driver.findElement(By.id("birthdateYear-field")).click();	
			driver.findElement(By.id("birthdateYear-field")).sendKeys(year);
			
			//Address
			driver.findElement(By.xpath("//span[contains(text(),'Address')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Address')]")).click();		
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address1);
			driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(address2);
			driver.findElement(By.xpath("//input[@id='cityVillage']")).sendKeys(city);
			driver.findElement(By.xpath("//input[@id='stateProvince']")).sendKeys(state);
			driver.findElement(By.xpath("//input[@id='country']")).sendKeys(country);
			driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys(zipcode);
			
			//Phone No.
			driver.findElement(By.xpath("//span[contains(text(),'Phone Number')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Phone Number')]")).click();
			driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
			
			//Relatives info
			driver.findElement(By.xpath("//span[contains(text(),'Relatives')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Relatives')]")).click();
			driver.findElement(By.xpath("//select[@id='relationship_type']")).click();
			Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='relationship_type']")));
			dropdown2.selectByVisibleText(relationType);
			driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys(relationName);
			
			//Confirm registration
			driver.findElement(By.xpath("//span[@id='confirmation_label']")).click();
			driver.findElement(By.xpath("//span[@id='confirmation_label']")).click();
			driver.findElement(By.xpath("//input[@id='submit']")).click();
		}
}
