package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	ExcelUtility excelutility;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class=' nav-link']")private WebElement adminUsers;
    @FindBy(xpath = "//a[@onclick='click_button(1)']")private  WebElement clickOnNewButton;
	@FindBy(xpath = "//input[@id='username']")private WebElement username_AdminUsers;
	@FindBy(xpath = "//input[@id='password']")private  WebElement password_AdminUsers;
	@FindBy(xpath = "//select[@id='user_type']")private WebElement selectUserType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")private WebElement saveButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")private WebElement newuserName;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertFailed;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> userNames;
	
	public AdminUsersPage hitAdminUsers() {
		adminUsers.click();
		return this;
	}
    public AdminUsersPage clickOnNewButton() {
		
		clickOnNewButton.click();
		return this;
	}

	public AdminUsersPage enterUserName(String username) {
		username_AdminUsers.sendKeys(username);
		return this;}

	public AdminUsersPage enterPassword(String password) {
		password_AdminUsers.sendKeys(password);
		return this;
	}
    public AdminUsersPage selectUserType() {
		pageutility = new PageUtility();
		pageutility.selectDropdownbyText(selectUserType, "Admin");
		return this;
		} 
    public AdminUsersPage clickSaveButton() {
		saveButton.click();
		return this;
	}
	public boolean alertMessageDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	public boolean alertMessageFailed()
	{
		return alertFailed.isDisplayed();
	}
	}

