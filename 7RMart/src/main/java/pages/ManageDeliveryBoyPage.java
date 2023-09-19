package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ManageDeliveryBoyPage {
	WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath ="//i[@class='nav-icon fas fa-user-plus']")private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")private WebElement deliveryBoyPageConfirmelement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement clickNew;
	@FindBy(xpath = "//input[@id='name']")private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")private WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@id='address']")private WebElement address;
	@FindBy(xpath = "//input[@id='username']")private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")private WebElement password;
	@FindBy(xpath = "//button")private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")private WebElement alertMessage;
	@FindBy(xpath = "//div[contains(@class,'alert-success ')]")private WebElement alertMessageOfsameUsername;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")private WebElement searchWithName;
	@FindBy(xpath = "//input[@id='ut']")private WebElement searcheWithEmail;
	@FindBy(xpath = "//input[@id='ph']")private WebElement searchWithphoneno;
	@FindBy(xpath = "//button[@type='submit']")private WebElement tableSearchButton;
	@FindBy(xpath = "//tbody//tr[1]//td[2]")private WebElement existingEmail;
	@FindBy(xpath = "//tbody//tr//td/span[@id='res']")private WebElement resultNotFound;
    @FindBy(xpath = "//button[@type='submit']")private WebElement resetButton;
	@FindBy(xpath="//table/tbody/tr/td[1]")private List<WebElement> userNamesFromTable;
	@FindBy(xpath="//table/tbody/tr/td[5]") private WebElement userNamesFromSearchTable;
    
	public ManageDeliveryBoyPage hit_ManageDeliveryBoyLink() {
		manageDeliveryBoy.click();
		return this;
	}
	   public ManageDeliveryBoyPage clickOn_CreateNewButton() {
		clickNew.click();
		return this;
	}
   public ManageDeliveryBoyPage enterName_DeliveryBoy(String name) {
		nameField.sendKeys(name);
		return this;
	}
   public ManageDeliveryBoyPage enterEmail_DeliveryBoy(String email) {
		emailField.sendKeys(email);
		return this;
	}
	public ManageDeliveryBoyPage enterPhonenumber_DeliveryBoy(String number) {
		phoneNumber.sendKeys(number);
		return this;
	}
	public ManageDeliveryBoyPage enterAddress_DeliveryBoy(String addressdetails) {
		address.sendKeys(addressdetails);
		return this;
	}
	public ManageDeliveryBoyPage enterUserName_DeliveryBoy(String userNamedetails) {
		userName.sendKeys(userNamedetails);
		return this;
	}
  public ManageDeliveryBoyPage enterPassword_DeliveryBoy(String passwordDetails) {
		password.sendKeys(passwordDetails);
		return this;
	}
	public ManageDeliveryBoyPage clickOnSaveButton_DeliveryBoy() {
		saveButton.submit();
		return this;
	}
    public boolean alertMessageOfUsernameAlreadyExist() {
		return alertMessageOfsameUsername.isDisplayed();
		}
	public boolean alertMessageSuccessfullDeliveryBoyCreated() {
		 return alertMessage.isDisplayed();
	}
	}
