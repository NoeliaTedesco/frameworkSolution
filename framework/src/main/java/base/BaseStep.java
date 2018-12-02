package base;

public class BaseStep extends Base{
	
	public static void NavigateToSite(String url) {
		driver.navigate().to(url);
	}
	
}
