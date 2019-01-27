package Maven_PatientPortal.PatientPortal;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PatientPortal extends PatientPortalData
{
		@Parameters({"TestURL","TestUsername","TestPassword","TestFirstname","TestMiddlename","TestLastname","TestGender","TestDate","TestMonth","TestYear","TestAddress1","TestAddress2","TestCity","TestState","TestCountry","TestZipcode","TestPhoneNumber","TestRelationType","TestRelationName"})
		@BeforeClass
		public void beforeRun(String TestURL, String TestUsername, String TestPassword, String TestFirstname, String TestMiddlename, String TestLastname, String TestGender, String TestDate, String TestMonth, String TestYear,String TestAddress1,String TestAddress2,String TestCity,String TestState,String TestCountry,String TestZipcode,String TestPhoneNumber,String TestRelationType,String TestRelationName)
		{
			url = TestURL;
			username = TestUsername;
			password = TestPassword;
			
			firstname = TestFirstname;
			middlename = TestMiddlename;
			lastname = TestLastname;
			gender = TestGender;
			date = TestDate;
			month = TestMonth;
			year = TestYear;
			
			address1 = TestAddress1;
			address2 = TestAddress2;
			city = TestCity;
			state = TestState;
			country = TestCountry;
			zipcode = TestZipcode;
			
			phoneNumber = TestPhoneNumber;
			relationType = TestRelationType;
			relationName = TestRelationName;			
		}
		
		@Test
		public void runTest() throws InterruptedException
		{
			Login();
			//Registration();
			//Logout();
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
			//driver.close();
		}
		
		//Registering a new patient
		public void Registration() throws InterruptedException
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
			
			//driver.findElement(By.xpath("html/body/header/ul/li[3]/a/i")).click();
			//driver.findElement(By.xpath("html/body/header/ul/li[3]/a")).click();	
			
			driver.close();
			}
}