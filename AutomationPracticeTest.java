package NewPackage;

import java.sql.Driver;

import javax.sound.sampled.LineListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.*;
import org.testng.annotations.*;
import NewPackage.HomePageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\nidhi oswal\\Downloads\\chromedriver_win32");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void NewUserSignUp() throws Exception {
		// TODO Auto-generated method stub
	HomePageObject home = new HomePageObject(driver);
	home.SignInClick();
	home.CreateAccountSignIn();
	home.SignUp();
	}
	
	@Test
	public void DressOrdersAndSummary() throws InterruptedException{
	// TODO Auto-generated method stub
	HomePageObject home = new HomePageObject(driver);
	home.SignInClick();
	home.Login();
	home.SelectingDressAndPayment();
	}
    
    @AfterTest
    public void close(){
        driver.close();
     }
	
}
