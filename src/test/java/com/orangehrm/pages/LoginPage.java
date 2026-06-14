package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class LoginPage extends BaseClass {

	private By txtUserName = By.name("username");
	private By txtPassword = By.name("password");
	private By btnLogin = By.xpath("//button[@type='submit']");

	public void login(String userName, String password) {
		elementSendKeys(txtUserName, userName);
		elementSendKeys(txtPassword, password);
		elementClick(btnLogin);
	}
}