package com.orangehrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {
				"com.orangehrm.stepdefinition",
				"com.orangehrm.hooks"
		},
		plugin = {
				"pretty",
				"json:target/cucumber.json",
				"html:target/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		dryRun =   false
)
public class TestRunner {

}