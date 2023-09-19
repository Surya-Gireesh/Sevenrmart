package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
public class ManagePage {
	WebDriver driver;
	PageUtility pageutility= new PageUtility();
    public ManagePage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @class='small-box-footer']")private WebElement managePagesTileMoreInfoButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton ;
	@FindBy (xpath = "//input[@class='form-control']")private WebElement titleField;
	@FindBy(xpath = "//button[@value='sr']")private WebElement newSearchButton;
	@FindAll({@FindBy(xpath = "//table[contains(@class,'table')] //child::td[1]")})private List<WebElement> tablecontent;
    public ManagePage clickOnManagePageMoreInfoButton()
	{
	managePagesTileMoreInfoButton.click();
	return this;
	}

	public boolean verifytheExistanceOfSearchButton()
	{
	boolean searcButtonDisplayedORNot=searchButton.isDisplayed();
	return searcButtonDisplayedORNot;
	}

	public ManagePage clickOnSearchButton()
	{
	searchButton.click();
	return this;
	}

	public ManagePage enterTitleOnTitleField(String searchTitleValue)
	{
	titleField.sendKeys(searchTitleValue);
	return this;
	}
	public ManagePage clickOnNewSearchButton()
	{
	newSearchButton.click();
	return this;
	}

	public boolean verifyThatTheTableDisplaysOnlyRowsWithTheMatchingTitle(String searchTitleValue)
	{
	boolean isSearchElementPresentInTheSearchList =false;
	List<String> titleColumValueList= pageutility.convertToStringList(tablecontent);
	int numberOfrowsAfterSearch =titleColumValueList.size();
    pageutility.getElementTextList(tablecontent, searchTitleValue);
    for(int i=0;i<numberOfrowsAfterSearch;i++)
	{
	if(titleColumValueList.get(i).contains(searchTitleValue))
	{
	isSearchElementPresentInTheSearchList = true;
	}
    }
	return isSearchElementPresentInTheSearchList;
	}
}
