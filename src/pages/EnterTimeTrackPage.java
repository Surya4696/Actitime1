package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage
{
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settings;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonSettings()
	{
		settings.click();
	}
	public void clickonLicenses()
	{
		licenses.click();
	}
	
	
}
