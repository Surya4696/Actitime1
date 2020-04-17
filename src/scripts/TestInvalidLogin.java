package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.LoginPage;

public class TestInvalidLogin extends BaseTest
{
	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		int rc=FWUtils.xL_Row_count(XL_DATA_PATH, "InvalidLogin");
		
		LoginPage lp=new LoginPage(driver);
		
		for (int i = 1; i <=rc; i++) 
		{
			String username = FWUtils.read_XL_Data(XL_DATA_PATH, "InvalidLogin", i, 0);
			String passwword = FWUtils.read_XL_Data(XL_DATA_PATH, "InvalidLogin", i, 1);
			lp.setUN(username);
			lp.setPW(passwword);
			lp.clickLoginBtn();
			Thread.sleep(1000);
			lp.verifyErrMsg();
			
		}
	}

}
