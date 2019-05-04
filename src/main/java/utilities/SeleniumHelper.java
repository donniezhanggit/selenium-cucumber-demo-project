package utilities;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {
	

    public static boolean isElementPresent(WebElement webElement) {
        try {
            boolean isPresent = webElement.isDisplayed();
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }
        
    }
    
    public static String getCurrentPageURL() {
		return SeleniumDriver.getDriver().getCurrentUrl();
	}
    
    public static String getPopupTxt()
	{
		String actualBoxMsg = "";
	 	Alert alt = SeleniumDriver.getDriver().switchTo().alert();
		actualBoxMsg = alt.getText(); // get content of the Alter Message
		alt.accept();
		
		return actualBoxMsg;
	}
    
    public static String getConfirmPopupMsg()
  	{
  		String actualBoxMsg = "";
  	 	Alert alt = SeleniumDriver.getDriver().switchTo().alert();
  		actualBoxMsg = alt.getText(); // get content of the Alter Message
  		alt.dismiss();
  		return actualBoxMsg;
  	}
    
    public static void  confirmOrDismissPopup(String option)
  	{
    	
	 	Alert alt = SeleniumDriver.getDriver().switchTo().alert();
		if(option.equalsIgnoreCase("confirm"))
		{
			alt.accept();
		}else
		{
			alt.dismiss();
		}
		
  	}
    
    public static String getPageTitle()
    {
    	return SeleniumDriver.getDriver().getTitle();
    }
    
   
	
}
