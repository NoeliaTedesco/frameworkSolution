package components;

import initializer.InitilizeHook;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import config.DataSetter;

public class Hook extends InitilizeHook {
	
    @Rule
    public TestName testName = new TestName();
    
	public Hook() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		openConfiguration();
		openLogger();
		openDelivery();
		openReport();
	}
	
	@Before
	public void setUp() {
		openBrowser();
		openContextData(testName.getMethodName());
		
	}
	
	@After
	public void tearDown() {
		closeContextData(testName.getMethodName());
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		closeBrowser();
		closeConfiguration();
		closeReport();
		closeDelivery();
		
		
	}
	
}
