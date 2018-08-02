package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static String url;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public void initSetPage()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		wait =  new WebDriverWait(driver, 30);
		driver.navigate().to("http://demoqa.com");
	}

	public void tearDownPage()
	{
		driver.close();
		if(!driver.equals(null))
			driver.quit();
	}
	
	public WebElement findObject(String elementName,String elementLocatorType, boolean mandatory)
	{
		By findBy = null;
		WebElement element=null;

		if(elementLocatorType == "id")
		{
			findBy = By.id(elementName);
		}
		if(elementLocatorType == "xpath")
		{
			findBy = By.xpath(elementName);
		}
		if(elementLocatorType == "cssSelector")
		{
			findBy = By.cssSelector(elementName);
		}
		if(elementLocatorType == "class")
		{
			findBy = By.className(elementName);
		}
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
			element = driver.findElement(findBy);
		} catch(Exception e) {
			System.out.println("Element    "+elementName+"  NOT FIND");				
		}
		if(mandatory && element != null)
			System.out.println("Element    "+elementName+"  FIND");
		return element;
	}

	public void clickObject(String elementName,String elementLocatorType, boolean mandatory)
	{
		WebElement element = null;
		element = findObject(elementName,elementLocatorType,mandatory);
		if(element !=null && element.isDisplayed())
		{	try {
			element.click();
		} catch(Exception e){ }
		}
		else	
			System.out.println("Element is not displayed or can not be clicked");	
	}

	public String getValue(String elementName,String elementLocatorType,boolean mandatory, String typeValue)
	{

		WebElement element = null;
		element = findObject(elementName,elementLocatorType,mandatory);
		String value = null;
		if(element != null)
		{
			try {
				switch (typeValue) {
				case "attribute":
					value = element.getAttribute(elementName).toString();
					break;
				case "location":
					value =  element.getLocation().toString();
					break;
				case "class":
					value =  element.getClass().toString();
					break;
				case "size":
					value =  element.getSize().toString();
					break;
				case "text":
					value =  element.getText();
					break;
				case "tagname":
					value =  element.getTagName();
					break;
				case "displayed":
					value =  String.valueOf(element.isDisplayed());
					break;
				}
			} catch(Exception e) {}
		}

		else
		{
			System.out.println("No value!");
		}
		return value;
	}
}
