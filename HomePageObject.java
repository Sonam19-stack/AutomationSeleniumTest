package NewPackage;

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
import org.testng.annotations.Test;
import java.util.List;

public class HomePageObject{
	
	String emailAddress1 = "snm.bafna@gmail.com";
	String password ="ABCxyz";
	String baseUrl = "http://automationpractice.com/index.php";
	WebDriver driver;
	Actions actions = new Actions(driver);
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SignInClick()
	{
	driver.get(baseUrl);
	WebElement SignIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
	SignIn.click();
	}
	
	public void CreateAccountSignIn()
	{
	WebElement CreateAccountlbl = driver.findElement(By.xpath("//h3[text()='Create an account']"));
	Assert.assertNotNull(CreateAccountlbl);
	WebElement EmailAddresstxt = driver.findElement(By.id("email_create"));
	EmailAddresstxt.sendKeys(emailAddress1);
	WebElement CreateAccntbtn = driver.findElement(By.id("SubmitCreate"));
	CreateAccntbtn.click();
	}
	
	//SignUp Elements
	WebElement MrsRadioButton = driver.findElement(By.id("uniform-id_gender2"));
	WebElement custFirstNametb = driver.findElement(By.id("customer_firstname"));
    WebElement custLastNametb = driver.findElement(By.id("customer_lastname"));
    WebElement emailtb= driver.findElement(By.id("email"));
    WebElement pswdtb = driver.findElement(By.id("passwd"));
	Select selectdays = new Select(driver.findElement(By.id("uniform-days")));
	
	Select selectmonths = new Select(driver.findElement(By.id("months")));
	
	Select selectyears = new Select(driver.findElement(By.id("years")));
		
	WebElement fnametb= driver.findElement(By.id("firstname"));
	
    WebElement lnametb = driver.findElement(By.id("lastname"));
	WebElement compnytb = driver.findElement(By.id("company"));
	WebElement addr1tb = driver.findElement(By.id("address1"));
	WebElement addrtb2= driver.findElement(By.id("address2"));
	WebElement citytb = driver.findElement(By.id("city"));
	
	Select selectState = new Select(driver.findElement(By.id("id_state")));
	
	
	WebElement postcodetb = driver.findElement(By.id("postcode"));
	
	Select selectCountry = new Select(driver.findElement(By.id("id_country")));
	
	
	WebElement mobiletb = driver.findElement(By.id("phone_mobile"));
	WebElement addressaliastb = driver.findElement(By.id("alias"));
	WebElement registerbtn = driver.findElement(By.id("submitAccount"));
	
	
	public void SignUp() {
		MrsRadioButton.click();
		custFirstNametb.sendKeys("CustFirst");
		custLastNametb.sendKeys("LastFirst");
		String emailAddress2 = emailtb.getAttribute("text");
		Assert.assertEquals(emailAddress1,emailAddress2);
		pswdtb.sendKeys(password);
		
		selectdays.selectByValue("4");
		selectmonths.selectByValue("5");
		selectyears.selectByValue("1995");
		
		fnametb.sendKeys("CustFirst");
		lnametb.sendKeys("LastFirst");
		compnytb.sendKeys("Anchor");
		addr1tb.sendKeys("Lane 1, P.O.Box - 1234, Anchor");
		citytb.sendKeys("Atlanta");
		
		selectState.selectByVisibleText("Georgia");
		postcodetb.sendKeys("12345");
		selectCountry.selectByValue("21");
		mobiletb.sendKeys("9987651234");
		addressaliastb.sendKeys("Addresss, Alias");
		registerbtn.click();
	}
	
	
	//Login Elements
	public void Login() {
	WebElement emailtb2 = driver.findElement(By.id("email"));
	WebElement psswdtb2= driver.findElement(By.id("passwd"));
    WebElement loginbtn= driver.findElement(By.id("SubmitLogin"));
    
    emailtb2.sendKeys(emailAddress1);
    psswdtb2.sendKeys(password);
    loginbtn.click();
	}
	
	//Selecting Dress and payment process
	public void SelectingDressAndPayment() throws InterruptedException
	{
    
	WebElement womenCategory = driver.findElement(By.xpath("//a[@title='Women']"));
    actions.moveToElement(womenCategory);
    
    WebElement tshirtsEle = driver.findElement(By.xpath("//li[@class='sfHoverForce']//a[@title='T-shirts']"));        	
    tshirtsEle.click();
  
    WebElement product = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/1-home_default.jpg']"));
    actions.moveToElement(product);
    
    WebElement quickview = driver.findElement(By.xpath("//span[text()='Quick view']"));
    quickview.click();
    Thread.sleep(3000);
    
    WebElement AddToCrt = driver.findElement(By.xpath("//span[text()='Add to cart']"));
    AddToCrt.click();
    
    WebElement qntyEle = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']//i[@class='icon-plus']"));
    qntyEle.click();
    
  WebElement qntyValue = driver.findElement(By.xpath("//p//input[@id='quantity_wanted']"));
  String qnty = qntyValue.getAttribute("value");
  Assert.assertTrue(qnty=="2");
  
  WebElement AddToCrt2 = driver.findElement(By.xpath("//span[text()='Add to cart']"));
  AddToCrt2.click();  
  Thread.sleep(8000);
  
  WebElement successMsg = driver.findElement(By.xpath("//h2[contains(text(),'Product successfully added to your shopping cart')]"));
	Assert.assertNotNull(successMsg);
  
	WebElement prcdToCrt = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	prcdToCrt.click();
    
	WebElement prcdToCrt1 = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	prcdToCrt1.click();
    
	WebElement prcdToCrt2 = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
	prcdToCrt2.click();
  
	WebElement iagree = driver.findElement(By.id("cgv"));
	iagree.click();
    
   List<WebElement> prcdToCrt4 = driver.findElements(By.xpath("//span[contains(text(),'Proceed to checkout')] -> list element and select second element]"));
   prcdToCrt4.get(1).click();
    
   WebElement paymentmode = driver.findElement(By.xpath("//a[@title='Pay by check.']"));
   paymentmode.click();
    
   WebElement cnfrmOrdr = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
   cnfrmOrdr.click();
    
   WebElement alertSuccess = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
   Assert.assertNotNull(alertSuccess);
    
   WebElement successMsg2 = driver.findElement(By.xpath("//p[text()='Your order on My Store is complete.']"));
   Assert.assertNotNull(successMsg2);
    
   WebElement custAccntMsg = driver.findElement(By.xpath("//a[@title='View my customer account']"));
   custAccntMsg.click();
   
   WebElement accntOrders = driver.findElement(By.xpath("//a[@title='Orders']"));
   accntOrders.click();
    
   WebElement totalPrice = driver.findElement(By.xpath("//td[@class='history_price']//span[contains(text(),'$150.59')]"));
   Assert.assertNotNull(totalPrice);
	}
}

