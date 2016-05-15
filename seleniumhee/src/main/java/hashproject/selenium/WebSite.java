package hashproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebSite {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "/html/body/nav/div/div/a")
	private WebElement mainButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/nav/div/ul/li")
	private WebElement signUpMainButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/nav/div/ul/li[2]")
	private WebElement logInMainButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/form/div[1]/input")
	private WebElement emailSignUpInput;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/form/div[2]/input")
	private WebElement passwordSignUpInput;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/form/div[3]/input")
	private WebElement passwordConfirmSignUpInput;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form//input[3]")
	private WebElement signUpSignUpButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/a[1]")
	private WebElement logInSignUpLink;
	
	@FindBy(how = How.XPATH, using = "html/body/div/a[2]")
	private WebElement forgottenPasswordSignUpLink;
	
	@FindBy(how = How.XPATH, using = "html/body/div/h4")
	private WebElement successFlash;
	
	@FindBy(how = How.XPATH, using = "html/body/nav/div/ul/li/a")
	private WebElement signOutMainButton;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div[2]/form/div[1]/input")
	private WebElement emailLogInInput;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div[2]/form/div[2]/input")
	private WebElement passwordLogInInput;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div[2]/form/input[3]")
	private WebElement signInLogInButton;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/form/div[1]/input")
	private WebElement itemNewItemInput;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/form/div[2]/textarea")
	private WebElement descriptionNewItemInput;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/form/input[3]")
	private WebElement createNewItemButton;
	
	@FindBy(how = How.XPATH, using = "html/body/nav/div/a")
	private WebElement newItemLink;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div/div[2]/div[3]/a")
	private WebElement firstItemDeleteButton;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div/div[2]/div[1]/h2")
	private WebElement firstItemNameText;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div/div[2]/div[1]/p[1]")
	private WebElement firstItemDescriptionButton;
	
	@FindBy(how = How.XPATH, using = "html/body/div/div/div/div[2]/h3")
	private WebElement emptyListText;
	
	
	
	
	public WebSite(WebDriver driver) {
		this.driver = driver;
		driver.get("https://checklist-wojtasssss.c9users.io/");
		PageFactory.initElements(driver, this);
	}
	
	public void newUserRegister(String email, String password, String confirmPassword){
		signUpMainButton.click();
		emailSignUpInput.sendKeys(email);
		passwordSignUpInput.sendKeys(password);
		passwordConfirmSignUpInput.sendKeys(confirmPassword);
		signUpSignUpButton.click();
	}
	
	public void logInToAccount(String user, String password) {
		logInMainButton.click();
		emailLogInInput.sendKeys(user);
		passwordLogInInput.sendKeys(password);
		signInLogInButton.click();
	}
	
	public void addNewItem(String itemName, String itemDescription) {
		newItemLink.click();
		itemNewItemInput.sendKeys(itemName);
		descriptionNewItemInput.sendKeys(itemDescription);
		createNewItemButton.click();
	}
	
	public void deleteItem() {
		firstItemDeleteButton.click();
	}
	
	public void signOut() {
		signOutMainButton.click();
	}
	
	public WebElement getSignUpMainButton() {
		return this.signUpMainButton;
	}
	
	public WebElement getEmailSignUpInput() {
		return this.emailSignUpInput;
	}
	
	public WebElement getFirstItemDeleteButton() {
		return firstItemDeleteButton;
	}
	
	public WebElement getEmptyListText() {
		return this.emptyListText;
	}
	
	public WebElement getFirstItemNameText() {
		return firstItemNameText;
	}
	
	public WebElement getFirstItemDescriptionButton() {
		return firstItemDescriptionButton;
	}
}
