package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.CheckBox_Page;
public class CheckBox_Test extends BaseLibrary
{
	CheckBox_Page ob;
	@Parameters("env")
	@BeforeTest
	public void checkbox_urllaunch(String env)
	{
	  launch_URL(getreaddata(env));
	  ob = new CheckBox_Page();
	}
	@Test(priority=1)
	public void checkbox_elements()
	{
		ob.checkboxpage_elements();
	}
	@Test(priority=2)
   public void check_box_test()
   {
	  ob.CheckBox();
   }
	@Test(priority=3)
	public void check_box_mobile() throws InterruptedException
	{
		ob.checkbox_mobile();
	}
	@Test(priority=4)
	public void check_box_latpop()
	{
		ob.checkbox_laptop();
	}
	@Test(priority=5)
	public void check_box_desktop()
	{
		ob.checkbox_desktop();
	}
}
