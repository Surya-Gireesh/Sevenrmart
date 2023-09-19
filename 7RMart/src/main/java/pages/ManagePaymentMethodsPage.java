package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePaymentMethodsPage {
	WebDriver driver;
	public ManagePaymentMethodsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[text()='Manage Payment Methods']")private WebElement managePaymentMethodClick;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods?edit=2&page_ad=1']")private WebElement clickButton;
	@FindBy(name="name")private WebElement title;
	@FindBy(name="limit")private WebElement payLimit;
    @FindBy(name="Update")private WebElement updateButton;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertMessage;
    public ManagePaymentMethodsPage managePaymentMethodsClick()
    {
    	managePaymentMethodClick.click();
    	return this;
    }
    public ManagePaymentMethodsPage buttonClick()
    {
    	clickButton.click();
    	return this;
    }
    public ManagePaymentMethodsPage enterTitle(String enterTitleField)
    {
    	title.sendKeys(enterTitleField);
    	return this;
    }
    public ManagePaymentMethodsPage enterPayLimit(String enterLimit)
    {
    	payLimit.sendKeys(enterLimit);
    	return this;
    }
    public ManagePaymentMethodsPage updatePayLimit()
    {
    	updateButton.click();
    	return this;
    }
    public boolean alertIsDisplayed()
    {
    	return alertMessage.isDisplayed();
    }
}
