package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:target/HtmlReports",
				"json:target/Cucumber.json",
				"junit:target/JunitReports/Reports.xml"},
		features="src\\test\\resources\\Features\\SearchForDucks.feature",
		glue= "\\stepDefinitions"		
		)
public class TestRunner {

}
