package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user already exists")
	public void Verify_AdminUsersAlreadyExist() {

		String username = ExcelUtility.getString(0, 0,"Loginpage");
		String password = ExcelUtility.getString(0, 1,"Loginpage");
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers().clickOnNewButton().enterUserName(username).enterPassword(password).selectUserType().clickSaveButton();
		boolean alertFailure = adminuserspage.alertMessageFailed();
		assertTrue(alertFailure, "New user is added");
	}
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether add new Adminusers")
	public void Verify_AddNewAdminUsers() {

		String username = ExcelUtility.getString(0, 0,"Loginpage");
		String password = ExcelUtility.getString(0, 1,"Loginpage");
		String new_username=ExcelUtility.getString(1, 0, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers().clickOnNewButton().enterUserName(new_username).enterPassword(password).selectUserType().clickSaveButton();
		boolean alertSuccess = adminuserspage.alertMessageDisplayed();
		assertTrue(alertSuccess,"User already exist");
	}
}
