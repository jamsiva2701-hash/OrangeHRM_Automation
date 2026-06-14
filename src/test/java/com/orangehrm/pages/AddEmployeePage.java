package com.orangehrm.pages;

import java.io.File;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class AddEmployeePage extends BaseClass {

	private By btnPim = By.xpath("//span[text()='PIM']");
	private By btnAddEmployee = By.xpath("//a[contains(text(),'Add Employee')]");
	private By txtFirstName = By.name("firstName");
	private By txtLastName = By.name("lastName");
	private By txtEmployeeId = By.xpath("(//input[contains(@class,'oxd-input')])[5]");
	private By btnUploadPhoto = By.cssSelector("input.oxd-file-input");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By successMessage = By.xpath("//p[contains(@class,'oxd-text--toast-message')]");

	public String addEmployee(String firstName, String lastName, String profilePicPath) {

		elementClick(btnPim);
		elementClick(btnAddEmployee);

		elementSendKeys(txtFirstName, firstName);
		elementSendKeys(txtLastName, lastName);
		int randomNum = (int) (Math.random() * 9000) + 1000;
		elementSendKeys(txtEmployeeId, String.valueOf(randomNum));
		String employeeId = findElement(txtEmployeeId).getDomProperty("value");

		String fullPath = new File(profilePicPath).getAbsolutePath();

		File file = new File(fullPath);
		System.out.println("Profile Pic Path : " + fullPath);
		System.out.println("File Exists : " + file.exists());

		if (!file.exists()) {
			throw new RuntimeException("Profile picture not found: " + fullPath);
		}

		uploadFile(btnUploadPhoto, fullPath);

		elementClick(btnSave);
		waitForPresence(successMessage);

		return employeeId;
	}
}