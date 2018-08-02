package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Page.HomePage;

public class HomeTest extends TestBase{

	@Test
	public void homePageTest()
	{
		HomePage hp = new HomePage();
		hp.testHomePage1();
		assertEquals(findObject(".//div[@id ='tabs-3']/p[2]","xpath",true).getText(),"The content could contain anything text page or submit form or any other HTML objects.");
	}
}
