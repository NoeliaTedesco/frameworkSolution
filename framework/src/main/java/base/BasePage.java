package base;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage extends Base {

	public static WebDriverWait wait;
	public static Actions Actions;
	public static Select Select;
	
	public BasePage() {
		wait = new WebDriverWait(driver,30);
		Actions = new Actions(driver);
		
	}
	
	public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
		Object obj = PageFactory.initElements(driver, page);
		return page.cast(obj);
	}
	

	@SuppressWarnings("unchecked")
	public <TPage extends BasePage> TPage As(Class<TPage> instancia) {
		try {
			return (TPage) this;
		}catch (Exception ex) {
			ex.getStackTrace();
		}
		return null;
	}
}
