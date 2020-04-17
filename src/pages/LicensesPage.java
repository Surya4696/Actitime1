package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensesPage 
{
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement productEdition;
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issueDate;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	public LicensesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void prodEdition(String expectedPE)
	{
		String actualPE=productEdition.getText();
		
		
		Assert.assertEquals(actualPE, expectedPE);
		Reporter.log("Expected product edition is: "+expectedPE,true);
	}
	
	public void issueDATE(String expectedissuedate)
	{
		String actualDate=issueDate.getText();
		
		Assert.assertEquals(actualDate, expectedissuedate);
		Reporter.log("Expected Issue Date is: "+expectedissuedate,true);
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn.click();
	}
	
	

}
