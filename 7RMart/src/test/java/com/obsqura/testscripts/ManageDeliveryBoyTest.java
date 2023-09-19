package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
public class ManageDeliveryBoyTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to add the new deliveryboy details")
	public void verifyManageDeliveryBoySuccessCreation() {
		String loginusername = ExcelUtility.getString(0, 0, "Loginpage");
		String loginpassword = ExcelUtility.getString(0, 1, "Loginpage");
		String name = ExcelUtility.getString(0, 0, "ManageDeliveryBoyPage");
		String email = ExcelUtility.getString(0, 1, "ManageDeliveryBoyPage");
		String number = ExcelUtility.getNumeric(0, 2, "ManageDeliveryBoyPage");
		String address = ExcelUtility.getString(0, 3, "ManageDeliveryBoyPage");
		String username = ExcelUtility.getString(0, 4, "ManageDeliveryBoyPage");
		String password = ExcelUtility.getString(0, 5, "ManageDeliveryBoyPage");
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(loginusername).enterPassWordOnPassWordField(loginpassword).clickOnSignInButton();
        ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.hit_ManageDeliveryBoyLink().clickOn_CreateNewButton().enterName_DeliveryBoy(name).enterEmail_DeliveryBoy(email).enterPhonenumber_DeliveryBoy(number).enterAddress_DeliveryBoy(address);
		managedeliveryboypage.enterUserName_DeliveryBoy(username).enterPassword_DeliveryBoy(password).clickOnSaveButton_DeliveryBoy();
		boolean alertMessage=managedeliveryboypage.alertMessageSuccessfullDeliveryBoyCreated();
		assertTrue(alertMessage,"New Deliveryboy creation failed");
     }
}