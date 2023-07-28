package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.LoginPage;
public class LoginPage_Test extends BaseLibrary
{
  LoginPage ob;
  @Parameters("env")
  @BeforeTest
  public void launch_url(String env)
  {
	launch_URL(getreaddata(env));
	ob = new LoginPage();
  }
  @Test(priority=1)
  public void getTitle_test() 
  {
	ob.get_title();  
  }
  @Test(priority=2)
  public void clickon_element()
  {
	ob.click_elementss();
  }
}














