package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.EnterTimeTrackPage;
import pages.LicensesPage;
import pages.LoginPage;

public class TestProductEdition extends BaseTest
{
	@Test
	public void testProductEdition() throws InterruptedException
	{
		String username=FWUtils.read_XL_Data(XL_DATA_PATH, "CheckProductionDate", 1, 0);
		String password=FWUtils.read_XL_Data(XL_DATA_PATH, "CheckProductionDate", 1, 1);
		String etitle=FWUtils.read_XL_Data(XL_DATA_PATH, "EnterTimeTrack", 1, 2);
		String etitlelcp=FWUtils.read_XL_Data(XL_DATA_PATH, "CheckProductionDate", 1, 2);
		String expectedProductionDate=FWUtils.read_XL_Data(XL_DATA_PATH, "CheckProductionDate", 1, 3);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUN(username);
		lp.setPW(password);
		lp.clickLoginBtn();
		
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		Thread.sleep(2000);
		FWUtils.verifyPage(driver, etitle);
		etp.clickonSettings();
		etp.clickonLicenses();
		
		LicensesPage lcp=new LicensesPage(driver);
		Thread.sleep(3000);
		FWUtils.verifyPage(driver, etitlelcp);
		lcp.prodEdition(expectedProductionDate);
		lcp.clickOnLogoutBtn();
	}

}
