package learnTestng;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG1 {
	WebDriver driver;
	String browser; 
	String url;

	@BeforeClass
	public void readConfig() {
		// (i) Buufer reader (ii) Input Stream (iii) File Reader (iv) Scanner
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("C:\\Users\\sarit\\OneDrive\\Documents\\QA\\SELENIUM\\6thSession\\src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser= prop.getProperty("Browser");
			
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@BeforeMethod
	public void launchBrowser() {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarit\\OneDrive\\Documents\\QA\\SELENIUM\\8thSession\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sarit\\OneDrive\\Documents\\QA\\SELENIUM\\8thSession\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("https://techfios.com/billing/?ng=admin/");

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	@Test (priority=1)
	public void loginTest() throws InterruptedException {

		Assert.assertEquals(driver.getTitle(), "Login - iBilling", "WRONG SITE!!!");

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LOGIN_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));

		USER_NAME_ELEMENT.clear();
		String LoginId = "demo@techfios.com";
		USER_NAME_ELEMENT.sendKeys(LoginId);

		String Password = "abc123";
		PASSWORD_ELEMENT.sendKeys(Password);

		LOGIN_ELEMENT.click();

		WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),  'Dashboard ')]"));

		Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong page!!!");

	}
	@Test (priority=2)
	public void addCustomer() {
		

		Assert.assertEquals(driver.getTitle(), "Login - iBilling", "WRONG SITE!!!");

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LOGIN_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));

		USER_NAME_ELEMENT.clear();
		String LoginId = "demo@techfios.com";
		USER_NAME_ELEMENT.sendKeys(LoginId);

		String Password = "abc123";
		PASSWORD_ELEMENT.sendKeys(Password);

		LOGIN_ELEMENT.click();

		WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),  'Dashboard ')]"));

		Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong page!!!");
		
		WebElement CUSTOMER_ELEMENT= driver.findElement(By.xpath("//span[contains(text(), 'Customers')]"));
		
		CUSTOMER_ELEMENT.click();
		
		WebElement ADD_CUSTOMER_ELEMENT= driver.findElement(By.xpath("//a[contains(text(), 'Add Customer')]"));
		ADD_CUSTOMER_ELEMENT.click();
			
		WebElement FULL_NAME_ELEMENT= driver.findElement(By.xpath("//input[@id='account']"));
		 FULL_NAME_ELEMENT.sendKeys("Sarita Oli");
		 
		 WebElement COMPANY_ELEMENT= driver.findElement(By.xpath("//select[@id='cid']"));
		 
		 COMPANY_ELEMENT.click();
		
		 WebElement COMPANY_OPTION_ELEMENT= driver.findElement(By.xpath("//option[contains(text(), 'Agency for the Performing Arts')]")); 
		 COMPANY_OPTION_ELEMENT.click();
		 
		 WebElement EMAIL_ELEMENT= driver.findElement(By.xpath("//input[@id='email']"));
		 EMAIL_ELEMENT.clear();
		 EMAIL_ELEMENT.sendKeys("asoatir@gmail.com");
		 
		
		 WebElement PHONE_ELEMENT= driver.findElement(By.xpath("//input[@id='phone']"));
		 PHONE_ELEMENT.sendKeys("469-623-4664");
		 
		
		 WebElement ADDRESS_ELEMENT= driver.findElement(By.xpath("//input[@id='address']"));
		 ADDRESS_ELEMENT.sendKeys("1718 Clarke Springs Dr");
		 
		 WebElement CITY_ELEMENT= driver.findElement(By.xpath("//input[@id='city']"));
		 CITY_ELEMENT.sendKeys("Allen");
		 
		 
	}
	
	
	
	
	
	
}
