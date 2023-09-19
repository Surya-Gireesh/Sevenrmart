package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PushNotificationPage;
import utilities.ExcelUtility;
public class PushNotificationTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to send notifications")
	public void verifyUserIsAbleToSendNotifications()
	{   
		LoginPage loginpage=new LoginPage(driver);
		String username=ExcelUtility.getString(0, 0, "PushPage");
		String password=ExcelUtility.getString(0, 1, "PushPage");
		String newTitle=ExcelUtility.getString(0, 2, "PushPage");
		String newDescription=ExcelUtility.getString(0, 3, "PushPage");
		PushNotificationPage pushnotificationpage=new PushNotificationPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		pushnotificationpage.pushNotificationClick().enterTitleOnTitleField(newTitle).enterDescription(newDescription).sendButtonClick();
		pushnotificationpage.alertMessageDisplayed();
		boolean alertMessage=pushnotificationpage.alertMessageDisplayed();
		assertTrue(alertMessage,"User cannot send notifications");
	}
	}
