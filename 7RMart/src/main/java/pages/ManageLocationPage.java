package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage {
	WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
    public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and contains(@class,'nav-link')]")
	private WebElement manageLocationClick;
	@FindBy(name = "country_id")
	private WebElement enterCountry;
	@FindBy(name = "state_id")
	private WebElement enterState;
	@FindBy(name = "location")
	private WebElement enterLocation;
	@FindBy(name = "delivery")
	private WebElement enterDeliveryCharge;
	@FindBy(name = "create")
	private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement alertMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement newSearchButton;
	@FindAll({ @FindBy(xpath = "//table[contains(@class,'table')] //child::td[1]") })
	List<WebElement> tablecontent;
	@FindBy(xpath="//span[text()='Inactive']") private WebElement status;
	@FindBy(xpath="//button[contains(@class,'btn-danger') and text()='Update']")private WebElement updateButton;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newButton;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/delete?del=1451&page_ad=1']")private WebElement deleteButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/edit?edit=1452&page_ad=1'and contains(@class,'btn-primary')]")private WebElement clickButton;
	public ManageLocationPage manageLocationClick() {
		manageLocationClick.click();
		return this;
	}
	public ManageLocationPage newButtonClick()
	{
		newButton.click();
		return this;
	}
    public ManageLocationPage enterCountryField() {
		pageutility.selectDropdownbyText(enterCountry,"United Kingdom");
		return this;
	}
    public ManageLocationPage enterStateField() {
		pageutility.selectDropdownbyText(enterState,"Berkshire");
		return this;
	}
    public ManageLocationPage enterLocationField(String location) {
		enterLocation.sendKeys(location);
		return this;
	}
    public ManageLocationPage enterDeliveryChargeField(String deliveryCharge) {
		enterLocation.sendKeys(deliveryCharge);
		return this;
	}
	public ManageLocationPage saveClick() {
		saveButton.click();
		return this;
	}
	public boolean alertDisplayed()
	{
	  return alertMessage.isDisplayed();
	}
	public ManageLocationPage clickButton()
	{
		clickButton.click();
		return this;
	}
	public ManageLocationPage enterLocationForUpdate(String newLocation)
	{
		enterLocation.sendKeys(newLocation);
		waitutility.fluentwaitForElement(driver, enterLocation);
		return this;
	}
	public boolean clickButtonDisplayed()
	{
	  return clickButton.isDisplayed();
	}
	public ManageLocationPage enterDeliveryChargeForUpdate(String newDeliveryCharge)
	{
		enterDeliveryCharge.sendKeys(newDeliveryCharge);
		return this;
	}
	public ManageLocationPage updateClick()
	{   
		waitutility.waitForElementClickable(driver, updateButton);
		updateButton.click();
		return this;
	}
	public ManageLocationPage deleteClick()
	{   
		deleteButton.click();
		pageutility.alertHandlingaccept(driver);
		return this;
	}
}
	
