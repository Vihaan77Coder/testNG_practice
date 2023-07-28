package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.Buttons_Page;

public class Buttons_test extends BaseLibrary
{
  Buttons_Page ob;
  @Parameters("env")
  @BeforeTest
  public void launchURL(String env)
  {
	  launch_URL(getreaddata(env));
	  ob = new Buttons_Page();
  }
  @Test(priority=0)
  public void elements_click()
  {
	  ob.clickon_elements();
  }
  @Test(priority=1)
  public void buttonsclick() 
  {
	  ob.clickon_button();
  }
  @Test(priority=2)
  public void clickondoubleclick_rightclick()
  {
	  ob.clickondouble_rightclick(); 
  }
}














