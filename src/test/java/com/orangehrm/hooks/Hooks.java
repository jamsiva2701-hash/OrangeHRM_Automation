package com.orangehrm.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangehrm.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@AfterStep
	public void attachScreenshotForEachStep(Scenario scenario) {

		try {

			waitForPageLoad();

			byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);

			scenario.attach(
					screenshot,
					"image/png",
					"Screenshot");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void afterScenario() {

		if (driver != null) {
			driver.quit();
		}
	}
}