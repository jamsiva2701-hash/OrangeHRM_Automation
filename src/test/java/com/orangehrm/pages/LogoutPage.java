package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class LogoutPage extends BaseClass {

	private By btnProfile = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By btnLogout = By.xpath("//a[text()='Logout']");

	public void logout() {

		elementClick(btnProfile);
		elementClick(btnLogout);
	}
}