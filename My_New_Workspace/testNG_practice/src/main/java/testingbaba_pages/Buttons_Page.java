package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class Buttons_Page extends BaseLibrary
{
	 @FindBy(xpath="//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	 private WebElement elements;
	 @FindBy(xpath="//*[text()='buttons']")
	 private WebElement button;
	 @FindBy(xpath="//*[@id=\"tab_5\"]/div[1]/button")
	 private WebElement doubleclick;
	 @FindBy(xpath="//*[@id=\"noContextMenu\"]")
	 private WebElement rightclick;
	 @FindBy(xpath="//*[@id=\"tab_5\"]/div[3]/button")
	 private WebElement clickme;
	 
	  public Buttons_Page()
	  {
		 PageFactory.initElements(driver, this);
	  }
	  public void clickon_elements()
	  {
		  elements.click();
	  }
	  public void clickon_button()
	  {
		  button.click();
	  }
	  public void clickondouble_rightclick()
	  {
		  doubleclick(doubleclick);
		  rightclick(rightclick);
	  }
}
