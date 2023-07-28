package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.TextBox_Page;
public class TextBox_Test extends BaseLibrary
{
	TextBox_Page ob;
	@Parameters("env")
	
	
	@BeforeTest
	public void LaunchURL(String env)
	{
		launch_URL(getreaddata(env));
		ob = new TextBox_Page();
	}
  @Test(priority=1)
    public void clickon_element()
    {
	 ob.click_elements();
    } 
  
  @Test(priority=2)
  public void clickon_textbox()
  {
	  ob.textbox_click();
  }
  
  @Test(priority=3)
  public void filldetails()
  {
	  ob.filldetails();
  }
  @Test(priority=4)
  public void getverifydetails()
  {
	  ob.getverifydetails();
  }
}

