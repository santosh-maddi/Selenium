package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCases.HomeTest;
import testCases.SearchResultsTest;

public class SearchImplementation {
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	HomeTest homeTest;
	SearchResultsTest searchResultsTest;
	
	@Before
	public void init() {
		report = new ExtentReports(System.getProperty("user.dir")+"\\Results.html");
		test = report.startTest("trial");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vijayma\\Downloads\\SeleniumJars\\LatestDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		homeTest= new HomeTest(driver);
		searchResultsTest = new SearchResultsTest(driver);
	}

@Given("Open browser and launch the appln {string}")
public void open_browser_and_launch_the_appln(String url) {
	driver.navigate().to(url);
}

@When("I enter string {string} to search and I click google Search Button")
public void i_enter_string_to_search(String searchString) {
	test.log(LogStatus.INFO, "Search for Ducks Started");
	homeTest.doSearch("ducks");
	test.log(LogStatus.INFO, "Search for Ducks -Results displayed");

}

@Then("verify the results matches the search string")
public void verify_the_results_matches_the_search_string() {
	test.log(LogStatus.INFO, "Verify search Results");
	searchResultsTest.checkResultsAsDucks();
}

@After
//close browser
public  void tearDownDriver() {
	driver.close();
	report.endTest(test);
	report.flush();

}

}
