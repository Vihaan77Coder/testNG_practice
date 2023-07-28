package base_library;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import application_utility.ApplicationUtility;
import excel_utility.ExcelUtility;
import property_utility.Property_Utility;
import screenshot_utility.Screenshot_Utility;
import wait_utility.WaitUtility;
public class BaseLibrary implements WaitUtility,ExcelUtility,Property_Utility,ApplicationUtility,Screenshot_Utility
{
  String path = "C:\\Users\\suraj kapri\\My_New_Workspace\\testNG_practice\\test_data\\Testingbaba_Data.xlsx";
  String configpath = "C:\\Users\\suraj kapri\\My_New_Workspace\\testNG_practice\\test_data\\config.properties";
  static public WebDriver driver = null;
  public void launch_URL(String url)
  {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj kapri\\My_New_Workspace\\testNG_practice\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize(); 	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
  }
  /* Methods created under @AfterTest annotation get invoked automatically; we
   * don't need to call them seperately. */
    @AfterTest
	  public void Teardown()
	  {
		 driver.quit();
	  }
	  @Override
	  public String getreaddata(int sheetno, int colno, int rowno) 
	  {
		  String value ="";
		  try
		  {
		  FileInputStream fis = new FileInputStream(path);
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sheet = wb.getSheetAt(sheetno);
		  value = sheet.getRow(rowno).getCell(colno).getStringCellValue();
		  }
		  catch(Exception e)
		  {
	         System.out.println("Some error found in code: "+e);		  
		  }
		  return value;
	  }

	  @Override
	  public String getreaddata(String key) 
	 {
		String value ="";
		try
		{
			FileInputStream fis = new FileInputStream(configpath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println("Issue in getreaddata property file "+ e);
		}
		return value;
	 }
	@Override
	public void doubleclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();		
	}
	@Override
	public void rightclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	@Override
	public void changewindow(int tabno) 
	{
      Set<String> set=driver.getWindowHandles();	
      ArrayList<String>tabs = new ArrayList<String>(set);
      driver.switchTo().window(tabs.get(tabno));
	}
	@Override
	public void fileuploading(String path) 
	{
	  	try
	  	{
          StringSelection sel = new StringSelection(path);
          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          clipboard.setContents(sel, null);
          Robot robot = new Robot();
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);
          robot.keyPress(KeyEvent.VK_CONTROL);
          robot.keyPress(KeyEvent.VK_V);
          robot.keyRelease(KeyEvent.VK_CONTROL);
          robot.keyRelease(KeyEvent.VK_V);
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Error in fileuploading method"+e);
	  	}
	}
	@Override
	public void getScreenshot(String foldername, String filename) 
	{
        try 
        {
		  String loc = System.getProperty("user.dir");
		  String path = loc+"\\screenshot\\"+foldername+"\\"+filename+".png";
		  EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		  File src = efw.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File(path));
		} 
        catch (Exception e) 
        {
		  System.out.println("Error in getScreenshot "+e);
        }		
	}
	@AfterMethod
	public void getAnalysis(ITestResult result)
	{
		String name = result.getMethod().getMethodName();
		try 
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				getScreenshot("passed", name);
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				getScreenshot("Failed", name);
			}
			else
			{
				getScreenshot("Skipped", name);
			}
		} 
		catch (Exception e) 
		{
          System.out.println("Issue in getAnalysis "+ e);
		}
	}
	@Override
	public void elementtobeClickable(WebElement ele, int time) 
	{
     WebDriverWait  wait = new WebDriverWait(driver,time);		
     wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	@Override
	public void clickme(WebElement ele) 
	{
		WebDriverWait  wait = new WebDriverWait(driver, 3);		
	    wait.until(ExpectedConditions.elementToBeClickable(ele));	
	    ele.click();
	}
}









