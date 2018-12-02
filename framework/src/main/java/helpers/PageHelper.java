package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static base.Base.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static base.BasePage.wait;;

public class PageHelper {
	
	public static void ScrollingToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void WaitForPageLoading() throws InterruptedException {
		Boolean r = false;
		int iterator = 0;
		while (iterator <= 15) {
			Thread.sleep(5000);
			r = wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply (WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					return (Boolean)js.executeScript("return document.readyState").toString().equals("complete");
				}
			});
			iterator++;
		}
		
	}
	
	public static void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public static void switchToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public static void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public static void switchToWindow(WebDriver driver, String window) {
		driver.switchTo().window(window);
	}


}
