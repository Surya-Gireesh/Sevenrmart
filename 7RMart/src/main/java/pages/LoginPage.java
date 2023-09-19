package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(name="username") private WebElement userNameField;
	@FindBy(name="password")  private WebElement passWordField;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signInButton;
	@FindBy(xpath="//a[text()='Home']")private WebElement isNavigatedToHomeField;
	@FindBy(xpath="//div[contains(@class,'dismissible')]") private WebElement alertMessage;
	public LoginPage enterUserNameOnUserNameField(String username)

	{
		userNameField.sendKeys(username);
		return this;
		
	}
	public LoginPage enterPassWordOnPassWordField(String password)

	{
		passWordField.sendKeys(password);
		return this;
	}
	public LoginPage clickOnSignInButton()
	{
		signInButton.click();
		return this;
	}
	public boolean isNavigatedToHomePage()
	{
		return isNavigatedToHomeField.isDisplayed();
	}
	public boolean isNotNavigatedToHomePage()
	{
		return alertMessage.isDisplayed();
	}
	}
