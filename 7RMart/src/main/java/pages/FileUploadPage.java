package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;
public class FileUploadPage {
	WebDriver driver;
	GeneralUtility generalutility;
	FileUploadUtility fileuploadutility;
	WaitUtility waitutility;
	public FileUploadPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	       
	    }
	@FindBy(xpath="//p[text()='Manage Slider']") private WebElement manageslider;  
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newbutton;
	@FindBy(xpath="//input[@id='main_img']")private WebElement choosefile;
	@FindBy(xpath="//input[@id='link']")private WebElement link;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertMessage;
    public FileUploadPage clickOnManageSlider()
	{
	manageslider.click();
	return this;
	}
    public FileUploadPage  clickOnNewButton()
	{
	newbutton.click();
	return this;
	}
    public FileUploadPage uploadFile()
    {
    	fileuploadutility.fileUploadUsingSendKeys(choosefile,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
    	waitutility.fluentwaitForElementSelected(driver,choosefile);
    	return this;
    }
    public FileUploadPage  clickOnSaveButton()
	{
	savebutton.click();
	return this;
	}
    public boolean successAlertIsDisplayed()

	{ 
     return alertMessage.isDisplayed();
	}
    public FileUploadPage  addTheLinkOnLinkField(String httplink)
   	{

   	   link.sendKeys(httplink);
   	   return this;
   	}

}
