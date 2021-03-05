package testCases;

import org.openqa.selenium.WebDriver;

import pageObject.HomePage;

public class HomeTest extends HomePage{
	
		public HomeTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void doSearch(String searchString)
	{
		searchBox.sendKeys(searchString);
		searchButton.click();
	}

}
