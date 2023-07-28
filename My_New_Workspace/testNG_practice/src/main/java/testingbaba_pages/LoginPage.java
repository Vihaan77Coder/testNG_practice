package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;
public class LoginPage extends BaseLibrary
{
  public LoginPage()
  {
   PageFactory.initElements(driver,this);	  
  }
  
  @FindBy(xpath="//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
  private WebElement elementClick;

  public void get_title()
  {
	String title = driver.getTitle();
	System.out.println(title);
  }
  public void click_elementss()
  {
	elementClick.click();
  }
}
