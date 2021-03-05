package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObject.SearchResultsPage;

public class SearchResultsTest extends SearchResultsPage{
	
	public SearchResultsTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void checkResultsAsDucks()
	{
		for(WebElement links : resultsLink)
		{
			String resultText=links.getText().toLowerCase().trim();
			System.out.println(resultText);
			if(resultText.length()>3)
			{
						if(resultText.contains("duck"))
						{
							Assert.assertTrue(true);
						}else
						{
							Assert.assertTrue(false);
						}
			}
		}
	}

}
