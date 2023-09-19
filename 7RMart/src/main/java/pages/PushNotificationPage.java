package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;
public class PushNotificationPage {
	WebDriver driver;
	WaitUtility waitutility;
	By alert=By.xpath("//div[contains(@class,'alert-dismissible')]");
	public PushNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="username") private WebElement userNameField;
	@FindBy(name="password")  private WebElement passWordField;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signInButton;
    @FindBy(xpath="//p[text()='Push Notifications']") private  WebElement pushNotificationButton;
    @FindBy(xpath="//input[@id='title']") private WebElement title;
    @FindBy(xpath="//input[@id='description']") private WebElement description;
    @FindBy(name="create") private WebElement sendButton;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
    public PushNotificationPage pushNotificationClick()
    {
    	pushNotificationButton.click();
    	return this;
    }
    public PushNotificationPage enterTitleOnTitleField(String titlename)
    {
    	title.sendKeys(titlename);
    	return this;
    }
    public PushNotificationPage enterDescription(String descriptionz)
    {
    	description.sendKeys(descriptionz);
    	return this;
    }
    public PushNotificationPage sendButtonClick()
    {
    	sendButton.click();
    	return this;
    }
    public boolean alertMessageDisplayed()
    {   
    	return alertMessage.isDisplayed();
    }
}
