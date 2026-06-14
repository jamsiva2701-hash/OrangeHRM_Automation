package com.orangehrm.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static JSONObject testData;

	public void waitForPageLoad() {

		for (int i = 0; i < 20; i++) {

			String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();

			if (readyState.equals("complete")) {
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

	public void elementClick(WebElement element) {
		element.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForInvisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.ignoring(StaleElementReferenceException.class);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement waitForPresence(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void elementClickWithRetry(By locator) {
		try {
			findElement(locator).click();
		} catch (StaleElementReferenceException e) {
			findElement(locator).click();
		}
	}

	public String takeScreenshot(String fileName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = "target/screenshots/" + fileName + ".png";

		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return System.getProperty("user.dir") + "/" + path;
	}

	public void clickWithRetry(By by) {

		int attempts = 0;

		while (attempts < 3) {
			try {
				WebElement element = findElement(by);
				element.click();
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("Retrying click due to stale element...");
			}
		}

		throw new RuntimeException("Unable to click element: " + by);
	}

	public WebElement presenceOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void uploadFile(By locator, String filePath) {
		presenceOfElement(locator).sendKeys(filePath);
	}

	public void enterApplnUrl(String url) {
		driver.get(url);
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void elementSendKeys(By locator, String value) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void elementClick(By locator) {
		findElement(locator).click();
	}

	public String elementGetText(By locator) {
		return findElement(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return findElement(locator).isDisplayed();
	}

	public boolean isElementNotPresent(By locator) {
		try {
			return driver.findElements(locator).isEmpty();
		} catch (Exception e) {
			return true;
		}
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void waitForOrangeHRMLoader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-form-loader')]")));
	}

	public void loadJsonData() throws Exception {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src/test/resources/testdata/EmployeeData.json");
		testData = (JSONObject) jsonParser.parse(reader);
		reader.close();
	}

	public String getJsonData(String key) {
		return testData.get(key).toString();
	}
}