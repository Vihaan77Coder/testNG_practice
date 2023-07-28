package application_utility;

import org.openqa.selenium.WebElement;

public interface ApplicationUtility 
{
  public void doubleclick(WebElement ele);
  public void rightclick(WebElement ele);
  public void changewindow(int index);
  public void fileuploading(String path);
  public void clickme(WebElement ele);
}
