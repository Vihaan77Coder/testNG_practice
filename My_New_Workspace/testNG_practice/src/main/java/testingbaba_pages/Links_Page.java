package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_library.BaseLibrary;

public class Links_Page extends BaseLibrary 
{
  public Links_Page() 
  {
	  PageFactory.initElements(driver, this);
  }
  String file = "C:\\Users\\suraj kapri\\My_New_Workspace\\testNG_practice\\test_data\\Testingbaba_Data.xlsx";
  @FindBy(xpath="//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
  private WebElement elements;

  @FindBy(xpath="//*[text()='links']")
  private WebElement links;
  
  @FindBy(xpath="//*[text()='Demo Page']")
  private WebElement newtab;
  @FindBy(xpath="//*[text()='×']")
  private WebElement closebtn;
  @FindBy(xpath="//*[text()='upload and download']")
  private WebElement click_upld_dwnld;
  @FindBy(xpath="//*[text()='Select a file']")
  private WebElement selectfile;
  
  public void clickonelements()
  {
	  elements.click();
	  getScreenshot("passed", "clickonelements");
  }
  public void clickonlinks()
  {
	 clickme(links);
  }
  public void clickonnewtab()
  {
	  newtab.click();
  }
  public void closebtn_backtohomepage() 
  {
	  changewindow(1);
	  clickme(closebtn);
	  driver.close();
	  changewindow(0);
  }
  public void click_uploaddownload() throws InterruptedException
  {
	  click_upld_dwnld.click();
	  Thread.sleep(3000);
	  selectfile.click();
	  fileuploading(file);
  }
}
