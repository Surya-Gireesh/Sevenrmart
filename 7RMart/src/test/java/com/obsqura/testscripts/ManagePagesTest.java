package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;
import pages.ManagePage;
public class ManagePagesTest extends Base {
	
	@Parameters({"userName","password"})
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to search the presence of search button")
	public void verifyThePresenceOfASearchButtonInManagePage(String userName, String password)
	{
	LoginPage loginpage= new LoginPage(driver);
	ManagePage managepage= new ManagePage(driver);
	loginpage.enterUserNameOnUserNameField(userName);
	loginpage.enterPassWordOnPassWordField(password);
	loginpage.clickOnSignInButton();
	managepage.clickOnManagePageMoreInfoButton();
	boolean searchButtonDisplayedOrNot = managepage.verifytheExistanceOfSearchButton();
	assertTrue(searchButtonDisplayedOrNot, "Search button is not present in manage pages");
	}
    @Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to search a matching title")
    public void verifyThatTheTableDisplaysOnlyRowsWithTheMatchingTitleWhenUsingTheSearchFuncitonality()
	{
	String username= ExcelUtility.getString(0,0,"ManageUserpage");
    String password = ExcelUtility.getString(0,1,"ManageUserpage");
	String searchTitle= ExcelUtility.getString(0,2,"ManageUserpage");
	LoginPage loginpage= new LoginPage(driver);
	ManagePage managepage= new ManagePage(driver);
	boolean isSearchElementPresentInTheSearchList;
	loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
	managepage.clickOnManagePageMoreInfoButton().clickOnSearchButton().enterTitleOnTitleField(searchTitle).clickOnNewSearchButton();
	isSearchElementPresentInTheSearchList= managepage.verifyThatTheTableDisplaysOnlyRowsWithTheMatchingTitle(searchTitle);
	assertTrue(isSearchElementPresentInTheSearchList, "Values other than "+ searchTitle+ " exist in the search list");
 }
}
