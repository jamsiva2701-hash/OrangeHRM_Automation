package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class EditEmployeePage extends BaseClass {

	private By menuPim = By.xpath("//span[text()='PIM']");
	private By employeeListTab = By.xpath("//a[text()='Employee List']");

	private By txtEmployeeId = By.xpath("(//label[text()='Employee Id']/following::input)[1]");
	private By btnSearch = By.xpath("//button[@type='submit']");

	private By employeeRecord = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
	private By formLoader = By.xpath("//div[contains(@class,'oxd-form-loader')]");

	private By drpJobTitle = By.xpath("(//div[contains(@class,'oxd-select-text')])[1]");
	private By drpEmploymentStatus = By.xpath("(//div[@class='oxd-select-text-input'])[5]");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By btnJob = By.xpath("//a[text()='Job']");

	private By selectedJobTitle = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");

	private By selectedEmploymentStatus = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[5]");

	public void searchEmployee(String employeeId) {

		elementClick(menuPim);
		elementClick(employeeListTab);

		waitForInvisibility(formLoader);

		elementSendKeys(txtEmployeeId, employeeId);
		elementClick(btnSearch);

		// waitForInvisibility(formLoader);
		waitForPresence(employeeRecord);
		// Click first result row
		elementClick(employeeRecord);
	}

	public void updateEmployee(String jobTitle, String employmentStatus) {

		elementClick(btnJob);
		waitForOrangeHRMLoader();
		elementClick(drpJobTitle);
		elementClick(By.xpath("//div[@role='option']//span[text()='" + jobTitle + "']"));
		waitForOrangeHRMLoader();
		elementClick(drpEmploymentStatus);
		elementClick(By.xpath("//div[@role='option']//span[text()='" + employmentStatus + "']"));
		waitForOrangeHRMLoader();
		elementClick(btnSave);

		waitForOrangeHRMLoader();
	}

	public String getSelectedJobTitle() {
		return elementGetText(selectedJobTitle);
	}

	public String getSelectedEmploymentStatus() {
		return elementGetText(selectedEmploymentStatus);
	}
}