package components;

import initializer.InitilizeHook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import config.DataSetter;

public class Hook extends InitilizeHook {
	
    @Rule
    public TestName testName = new TestName();
    
	public Hook() {
	}
	
	@BeforeSuite
	public static void setUpClass() {
		openConfiguration();
		openLogger();
		openDelivery();
		openReport();
	}
	
	@BeforeClass
	public void setUp() {
		openBrowser();
		openContextData(testName.getMethodName());
		
	}
	
	@AfterClass
	public void tearDown() {
		closeContextData(testName.getMethodName());
		
	}
	
	@AfterSuite
	public static void tearDownClass() {
		closeBrowser();
		closeReport();
		closeDelivery();
		closeConfiguration();
		
		
		
	}
	
}
