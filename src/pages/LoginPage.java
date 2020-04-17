package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage
{
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement lgnBtn;
	
	@FindBy(xpath="//span[contains(text(),'invalid.')]")
	private WebElement errMSG;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUN(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPW(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginBtn()
	{
		lgnBtn.click();
	}
	
	public void verifyErrMsg()
	{
		Assert.assertTrue(errMSG.isDisplayed());
		Reporter.log("Error message is displayed",true);
	}

}
