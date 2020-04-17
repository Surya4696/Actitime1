package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class TestValidLogin extends BaseTest
{
	@Test
	public void testValidLoginPage()
	{
		String username=FWUtils.read_XL_Data(XL_DATA_PATH, "ValidLogin", 1, 0);
		String password=FWUtils.read_XL_Data(XL_DATA_PATH, "ValidLogin", 1, 1);
		
		String etitle=FWUtils.read_XL_Data(XL_DATA_PATH, "EnterTimeTrack", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUN(username);
		lp.setPW(password);
		lp.clickLoginBtn();
		
		EnterTimeTrackPage etp =new EnterTimeTrackPage(driver);
		FWUtils.verifyPage(driver, etitle);
	}
	
}
