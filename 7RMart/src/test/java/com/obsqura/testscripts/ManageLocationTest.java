package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;
public class ManageLocationTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to add location information")
	public void verifyUserAbleToAddLocationInformation()
	{
		String username = ExcelUtility.getString(0, 0, "Loginpage");
		String password = ExcelUtility.getString(0, 1, "Loginpage");
		String enterLocation=ExcelUtility.getString(0, 7, "Loginpage");
		String enterDeliveryCharge=ExcelUtility.getNumeric(0, 8,"Loginpage");
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
        ManageLocationPage managelocationpage=new ManageLocationPage(driver);
        managelocationpage.manageLocationClick().newButtonClick().enterCountryField().enterStateField();
        managelocationpage.enterLocationField(enterLocation).enterDeliveryChargeField(enterDeliveryCharge).saveClick();
        boolean alertDisplayed=managelocationpage.alertDisplayed();
        assertTrue(alertDisplayed,"Location is not created successfully");
     }
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to delete location information")
	public void verify_UserAbleToDeleteLocation()
	{
		String username = ExcelUtility.getString(0, 0, "Loginpage");
		String password = ExcelUtility.getString(0, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
        ManageLocationPage managelocationpage=new ManageLocationPage(driver);
        managelocationpage.manageLocationClick().deleteClick();
        boolean alertDisplayed=managelocationpage.alertDisplayed();
        assertTrue(alertDisplayed,"Deletion not possible");
	}
}
