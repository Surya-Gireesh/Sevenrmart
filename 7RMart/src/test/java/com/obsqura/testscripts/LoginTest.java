package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "Verify whether user is able to login using valid credentials")
	public void verifyUserAbleToLoginValidCredentials() {
		String username = ExcelUtility.getString(0, 0,"LOGIN");
		String password = ExcelUtility.getString(0, 1,"LOGIN");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		boolean isNavigatedHome = loginpage.isNavigatedToHomePage();
		assertTrue(isNavigatedHome, "User cannot redirected to Home page");
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify whether user is unable to login using invalid credentials",priority=1,groups = {"regression"})
	@Parameters({ "username", "password" })
	public void verifyUserUnableToLoginInValidUserNameValidPassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		boolean isNotNavigatedHome = loginpage.isNotNavigatedToHomePage();
		assertTrue(isNotNavigatedHome, "User can redirected to Home page");
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify whether user is unable to login using invalid credentials",priority=2,groups = {"smoke"})
	public void verifyUserUnableToLoginValidUserNameInvalidPassword() {
		String username = ExcelUtility.getString(1, 0, "LOGIN");
		String password = ExcelUtility.getString(1, 1, "LOGIN");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		boolean isNotNavigatedHome = loginpage.isNotNavigatedToHomePage();
		assertTrue(isNotNavigatedHome, "User can redirected to Home page");
	}

	@Test(dataProvider = "LoginProvider")
	public void verifyUserUnableToLoginInValidCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		String username = "surya";
		String password = "surya";
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		boolean isNotNavigatedHome = loginpage.isNotNavigatedToHomePage();
		assertTrue(isNotNavigatedHome, "User can redirected to Home page");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] {
				{ ExcelUtility.getString(2, 0, "LOGIN"), ExcelUtility.getString(2, 1, "LOGIN") }, };
	}

}
