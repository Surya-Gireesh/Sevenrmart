package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagePaymentMethodsPage;
import utilities.ExcelUtility;
public class ManagePaymentMethodsTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to update paylimit")
	public void verifyUserAbleToUpdatePayLimit()
	{
		String username=ExcelUtility.getString(0, 0, "Loginpage");
		String password=ExcelUtility.getString(0, 1, "Loginpage");
		String title_Enter=ExcelUtility.getString(0, 5, "Loginpage");
		String payLimit_Enter=ExcelUtility.getNumeric(0,6, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
		ManagePaymentMethodsPage managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.managePaymentMethodsClick().buttonClick().enterTitle(title_Enter).enterPayLimit(payLimit_Enter).updatePayLimit();
		boolean alertMsg=managepaymentmethodspage.alertIsDisplayed();
		assertTrue(alertMsg,"Updation not Possible");
	}

}
