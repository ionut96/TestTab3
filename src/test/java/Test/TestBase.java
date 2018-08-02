package Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Page.BasePage;


public class TestBase extends BasePage{
	
	@BeforeClass
	public void initSet()
	{
			initSetPage();
	}
	
	@AfterClass
	public void tearDown()
	{
		tearDownPage();
	}
}
