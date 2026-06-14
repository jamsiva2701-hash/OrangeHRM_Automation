package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.BaseClass;

public class DashboardPage extends BaseClass {

	private By txtDashboard = By.xpath("//h6[text()='Dashboard']");

	public boolean isDashboardDisplayed() {
		return isElementDisplayed(txtDashboard);
	}

	public String getDashboardText() {
		return elementGetText(txtDashboard);
	}
}