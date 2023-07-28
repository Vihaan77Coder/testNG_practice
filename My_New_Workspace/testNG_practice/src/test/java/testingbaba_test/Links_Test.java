package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.Links_Page;

public class Links_Test extends BaseLibrary
{
	Links_Page ob;
	@Parameters("env")
	@BeforeTest
	public void LaunchURL(String env)
	{
		launch_URL(getreaddata(env));
		ob = new Links_Page();
	}
  @Test(priority=1)
    public void clickon_element()
    {
	 ob.clickonelements();
    } 
  @Test(priority=2)
  public void clickon_links() 
  {
	  ob.clickonlinks();
  } 
  @Test(priority=3)
  public void clickon_newtab() throws InterruptedException
  {
	  Thread.sleep(3000);
	  ob.clickonnewtab();
  } 
  @Test(priority=4)
  public void closebtn_backtohomepage()
  {
	  
	ob.closebtn_backtohomepage();
  }
  @Test(priority=5)
  public void clickupload_download() throws InterruptedException
  {
	  ob.click_uploaddownload();
  }
}
