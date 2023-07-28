package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;
public class CheckBox_Page extends BaseLibrary
{
 @FindBy(xpath="//*[text()='check box']")
 private WebElement Check_Box;
 @FindBy(xpath="//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
 private WebElement elements;
 
 @FindBy(xpath="//*[@id=\"tab_2\"]/div/iframe")
 private WebElement iframe;
 
 @FindBy(xpath="//*[@id=\"myCheck\"]")
 private WebElement mobile;
 @FindBy(xpath="//*[@id=\"text\"]")
 private WebElement mobiletext;
 
 @FindBy(xpath="//*[@id=\"mylaptop\"]")
 private WebElement laptop;
 @FindBy(xpath="//*[@id=\"text1\"]")
 private WebElement laptoptext;
 
 @FindBy(xpath="//*[@id=\"mydesktop\"]")
 private WebElement desktop;
 @FindBy(xpath="//*[@id=\"text2\"]")
 private WebElement desktoptext;
 
 public CheckBox_Page()
 {
     PageFactory.initElements(driver, this);
 }
 public void checkboxpage_elements()
 {
	 elements.click();
 }
 public void CheckBox()
 {
	 Check_Box.click();
 }
 public void checkbox_mobile() throws InterruptedException
 {
	 Thread.sleep(3000);
	 driver.switchTo().frame(iframe);
	 mobile.click();
	 System.out.println(mobiletext.getText());
 }
 public void checkbox_laptop()
 {
	 laptop.click();
	 System.out.println(laptoptext.getText());
 }
 public void checkbox_desktop()
 {
	 desktop.click();
	 System.out.println(desktoptext.getText());
	 driver.switchTo().defaultContent();
 }
}
