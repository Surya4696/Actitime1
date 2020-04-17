package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FWUtils extends BaseTest
{
	public static void verifyPage(WebDriver driver,String etitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleContains(etitle));
		String atitle=driver.getTitle();
		Assert.assertEquals(atitle, etitle);
		System.out.println("Expected page is: "+etitle);
	}
	
	public static String read_XL_Data(String path,String sheet,int r,int c) 
	{
		String s="";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			 s = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	public static void write_XL_Data(String path,String sheet,int r,int c,int s) 
	{
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(s);
			wb.write(new FileOutputStream(path));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
       	public static int xL_Row_count(String path,String sheet) 
	{
		int s=0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			 s = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static void takesScreenShot(WebDriver driver,String path)
	{
		try
		{
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path);
			FileUtils.copyDirectory(src, des);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
