package scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.EnterTimeTrackPage;
import pages.LicensesPage;
import pages.LoginPage;

public class TestMethods extends BaseTest
{
	@Test
	public void testMethods() throws InterruptedException 
	{
		int count = FWUtils.xL_Row_count("./data/input.xlsx", "InvalidLogin");
		Reporter.log("Row count: "+count,true);
		
		String un=FWUtils.read_XL_Data("./data/input.xlsx", "InvalidLogin", 1, 0);
		String pw=FWUtils.read_XL_Data("./data/input.xlsx", "InvalidLogin", 1, 1);
		
		Assert.fail();
		
		LoginPage lp=new LoginPage(driver);
		for (int i = 0; i < count; i++)
		{
			lp.setUN(un);
			lp.setPW(pw);
			Thread.sleep(1000);
			lp.clickLoginBtn();
			Thread.sleep(1000);
			lp.verifyErrMsg();
		}
		
		
//		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
//		Thread.sleep(3000);
//		FWUtils.read_XL_Data("./data/input.xlsx", "EnterTimeTrack", 1, 2);
//		et.clickonSettings();
//		Thread.sleep(1000);
//		et.clickonLicenses();
//		
//		LicensesPage lcp=new LicensesPage(driver);
//		FWUtils.read_XL_Data("./data/input.xlsx", "Licenses", 1, 2);
//		lcp.prodEdition();
//		lcp.issueDATE();
	}	
}
