package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\subas\\eclipse-workspace\\RLL_Firstcry_Project\\src\\test\\java\\features\\ShorList.feature",
                          
                 glue= {"steps"},//steps is a package name
                 plugin = {"html:target/FirstCryShortList.html",
                		   "json:target/FirstCryShortList.json",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //to generate extent report and give path where it reside
           			     "timeline:test-output-thread/"})

public class TestShortListPage {

}
