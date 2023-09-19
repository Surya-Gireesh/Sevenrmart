package com.obsqura.testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.LoginPage;
import utilities.ExcelUtility;
public class FileUploadTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether user is able to upload the image")
	public void verifyTheUseIsAbleToUpladTheImage() {
        String username=ExcelUtility.getString(0, 0, "Loginpage");
	    String password=ExcelUtility.getString(0, 1, "Loginpage");
	    String addlink=ExcelUtility.getString(0, 2, "Loginpage"); 
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterUserNameOnUserNameField(username).enterPassWordOnPassWordField(password).clickOnSignInButton();
	    FileUploadPage fileuploadpage=new FileUploadPage(driver);
	    fileuploadpage.clickOnManageSlider().clickOnNewButton().addTheLinkOnLinkField(addlink).clickOnSaveButton();   
	    boolean successAlert=fileuploadpage.successAlertIsDisplayed();
	    assertTrue(successAlert,  "file not uploaded ");
	    }
}
