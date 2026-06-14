package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class EmployeeListPage extends BaseClass {

	private By noRecordsFound = By.xpath("//span[text()='No Records Found']");
	private By employeeRecord = By.xpath("//div[@role='rowgroup']//div[@role='row']");

	private By btnPim = By.xpath("//span[text()='PIM']");

	private By txtEmployeeId = By.xpath("(//input[contains(@class,'oxd-input')])[2]");

	private By btnSearch = By.xpath("//button[@type='submit']");

	private By btnDelete = By.xpath("(//button[i[contains(@class,'bi-trash')]])[1]");

	private By btnConfirmDelete = By.xpath("//button[contains(@class,'oxd-button--label-danger')]");

	public void searchEmployee(String employeeId) {

		elementClick(btnPim);

		findElement(txtEmployeeId).clear();

		elementSendKeys(txtEmployeeId, employeeId);

		elementClick(btnSearch);

		findElement(employeeRecord);
	}

	public boolean isEmployeePresent() {

		return isElementDisplayed(employeeRecord);
	}

	public void deleteEmployee(String employeeId) {

		searchEmployee(employeeId);

		clickWithRetry(btnDelete);

		clickWithRetry(btnConfirmDelete);
	}

	public boolean isEmployeeDeleted(String employeeId) {
		try {
			return findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}