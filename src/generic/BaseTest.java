package generic;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.repackage.Repackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	
	static int passcount=0,failcount=0;
	static
	{
		System.setProperty(CHROM_KEY,CHROM_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	@BeforeMethod
	public void openApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@AfterMethod
	public void closeApp(ITestResult res)
	{
		int status=res.getStatus();
		String testname=res.getName();
		System.out.println(testname);
		String filename=PHOTO_PATH+testname;
		if(status==1)
		{
			passcount++;
		}
		else
		{
			FWUtils.takesScreenShot(driver, filename+".png");
			failcount++;
		}
		driver.close();
	}
	
	@AfterSuite
	public void generateReport()
	{
		Reporter.log("Pass:"+passcount,true);
		Reporter.log("Fail:"+failcount,true);
		FWUtils.write_XL_Data(XL_REPORT_PATH, "sheet1", 1, 0, passcount);
		FWUtils.write_XL_Data(XL_REPORT_PATH, "sheet1", 1, 1, failcount);
	}

}
