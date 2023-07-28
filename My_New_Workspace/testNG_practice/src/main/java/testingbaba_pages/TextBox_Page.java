package testingbaba_pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import base_library.BaseLibrary;

public class TextBox_Page extends BaseLibrary

{
	public TextBox_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	  @FindBy(xpath="//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	  private WebElement elementsclick;
	  
	  @FindBy(xpath="//*[text()='text box']")
	  private WebElement textbox;
	  
	  @FindBy(xpath="//*[@id=\"fullname1\"]")
	  private WebElement fullname ;
	  
	  @FindBy(xpath="//*[@id=\"fullemail1\"]")
	  private WebElement email ;
	  
	  @FindBy(xpath="//*[@id=\"fulladdresh1\"]")
	  private WebElement currentaddress;
	  
	  @FindBy(xpath="//*[@id=\"paddresh1\"]")
	  private WebElement permanent_address;
	  
	  @FindBy(xpath="//*[@id=\"tab_1\"]/div/div[1]/form/input[3]")
	  private WebElement submit;
	  
	  public void click_elements()
	  {
		  elementsclick.click();
	  }
	  public void textbox_click()
	  {
		  textbox.click();
	  }
	  
	  public void filldetails()
	  {
		 fullname.sendKeys(getreaddata(0, 0, 1));  
		 email.sendKeys(getreaddata(0, 1, 1));
		 currentaddress.sendKeys(getreaddata(0, 2, 1));
		 permanent_address.sendKeys(getreaddata(0, 3, 1));
		 submit.click();
	  }
	 public void getverifydetails()
	 {
		 ArrayList<String> expected = new ArrayList<String>();
		 ArrayList<String> actual = new ArrayList<String>();
		 List<WebElement> li = driver.findElements(By.xpath("//*[@class=\"col-md-6 mt-5\"]/label"));
		 for(int i=1; i<=li.size()-1;i=i+2)
		 {
			 actual.add(li.get(i).getText());
		 }

		 expected.add(getreaddata(0,0,1));
		 expected.add(getreaddata(0,1,1));
		 expected.add(getreaddata(0,2,1));
		 expected.add(getreaddata(0,3,1));
		 SoftAssert sf = new SoftAssert();
		 for(String dd:expected)
		 {
			 for(String dd1:actual)
			 {
				 sf.assertEquals(dd,dd1);
				 actual.remove(dd1);
				 break;
			 }
		 }
		 sf.assertAll();
	 }
}
