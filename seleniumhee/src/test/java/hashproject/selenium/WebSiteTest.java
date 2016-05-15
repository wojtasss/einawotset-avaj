package hashproject.selenium;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSiteTest {

	private static WebDriver driver;
	static WebSite webSite;
	WebElement webElement;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wojtas\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webSite = new WebSite(driver);
	}
	/*
	@Test
	public void NewUserRegister() {
		webSite.newUserRegister("beka111@wp.pl", "siema123", "siema123");
		String text = driver.findElement(By.xpath("/html/body/div[1]/h4")).getText();
		
		assertEquals("Welcome! You have signed up successfully.", text);
		webSite.signOut();
	}
	
	@Test
	public void TryDuplicateNewUserRegister() {
		webSite.newUserRegister("beka126523@wp.pl", "siema123", "siema123");
		webSite.newUserRegister("beka126523@wp.pl", "siema123", "siema123");
		String text = driver.findElement(By.xpath("html/body/div/div/ul/li[1]")).getText();
		
		assertEquals("Email has already been taken", text);
	}
	
	@Test
	public void TryShortPasswordNewUserRegiter() {
		webSite.newUserRegister("beka299@wp.pl", "ds", "ds");
		String text = driver.findElement(By.xpath("html/body/div/div/ul/li[1]")).getText();
		
		assertEquals("Password is too short (minimum is 8 characters)", text);
	}
	
	@Test public void TryBlankEmailNewUserRegister() {
		webSite.newUserRegister("", "siema123", "siema123");
		String text = driver.findElement(By.xpath("html/body/div/div/ul/li[1]")).getText();
		
		assertEquals("Email can't be blank", text);
	}
	
	@Test 
	public void TryDifferentPasswordsNewUserRegister() {
		webSite.newUserRegister("beka123@wp.pl", "siema123", "siema321");
		String text = driver.findElement(By.xpath("html/body/div/div/ul/li[1]")).getText();
		
		assertEquals("Password confirmation doesn't match Password", text);
	}
	
	@Test
	public void LogInSuccess() {
		webSite.logInToAccount("beka111@wp.pl", "siema123");
		String text = driver.findElement(By.xpath("html/body/div[1]/h4")).getText();
		
		assertEquals("Signed in successfully.", text);
		webSite.signOut();
	}
	
	@Test
	public void LogInFailed() {
		webSite.logInToAccount("wojtek@wp.pl", "haslo321");
		String text = driver.findElement(By.xpath("html/body/div[1]/h4")).getText();
		
		assertEquals("Invalid email or password.", text);
	}
	
	@Test
	public void SignOut(){
		webSite.logInToAccount("beka111@wp.pl", "siema123");
		webSite.signOut();
		String text = driver.findElement(By.xpath("html/body/div[1]/h4")).getText();
		
		assertEquals("Signed out successfully.", text);
	}
	
	@Test
	public void AddNewItem() {
		webSite.logInToAccount("beka111@wp.pl", "siema123");
		webSite.addNewItem("Wyrzucić śmieci", "Jak nie wyrzucisz śmieci to matka obiadu nie da!");
		String itemName = driver.findElement(By.xpath("html/body/div/div/div/div[2]/div[1]/h2")).getText();
		String itemDescription = driver.findElement(By.xpath("html/body/div/div/div/div[2]/div[1]/p[1]")).getText();
		
		assertEquals("Wyrzucić śmieci", itemName);
		assertEquals("Jak nie wyrzucisz śmieci to matka obiadu nie da!", itemDescription);
		
		webSite.signOut();
	} */
	
	@Test
	public void DeleteItem() {
		webSite.logInToAccount("beka111@wp.pl", "siema123");
		webSite.addNewItem("Wyrzucić śmieci", "Bo tak smarkaczu!");
		
		assertEquals(webSite.getFirstItemNameText().getText(), "Wyrzucić śmieci");
		assertEquals(webSite.getFirstItemDescriptionButton().getText(), "Bo tak smarkaczu!");
		
		webSite.deleteItem();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		try {
			WebElement emptyList = driver.findElement(By.xpath("html/body/div/div/div/div[2]/h3"));
			assertEquals(emptyList.getText(), "Yout Checklist is empty!");
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			if(!driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/h2")).getText().equals("Wyrzucić śmieci")) {
				assertTrue(true);
			}
		}
		
		webSite.signOut();
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}
}
