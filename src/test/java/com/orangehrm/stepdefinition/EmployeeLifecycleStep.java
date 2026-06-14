package com.orangehrm.stepdefinition;

import org.junit.Assert;

import com.orangehrm.base.ApiBaseClass;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.EditEmployeePage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.LogoutPage;
import com.orangehrm.pojo.addemployee.AddEmployee_Input_Pojo;
import com.orangehrm.pojo.addemployee.AddEmployee_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class EmployeeLifecycleStep extends BaseClass {
	String employeeIdUpdated;
	ApiBaseClass api = new ApiBaseClass();
	Response response;
	AddEmployee_Output_Pojo output;

	@Given("User launches OrangeHRM application")
	public void user_launches_orange_hrm_application() throws Exception {
		browserLaunch();

		enterApplnUrl("https://opensource-demo.orangehrmlive.com/");

		loadJsonData();

	}

	@When("User logs in with valid credentials from test data")
	public void user_logs_in_with_valid_credentials_from_test_data() {

		LoginPage loginPage = new LoginPage();

		loginPage.login(getJsonData("username"), getJsonData("password"));
	}

	@Then("User should verify dashboard is displayed")
	public void user_should_verify_dashboard_is_displayed() {

		DashboardPage dashboardPage = new DashboardPage();

		Assert.assertTrue(dashboardPage.isDashboardDisplayed());
	}

	@When("User adds a new employee from test data")
	public void user_adds_a_new_employee_from_test_data() {

		AddEmployeePage addEmployeePage = new AddEmployeePage();

		employeeIdUpdated = addEmployeePage.addEmployee(getJsonData("firstName"), getJsonData("lastName"),
				getJsonData("profilePic"));
	}

	@Then("User should verify employee is added successfully")
	public void user_should_verify_employee_is_added_successfully() {

		EmployeeListPage employeeListPage = new EmployeeListPage();

		employeeListPage.searchEmployee(employeeIdUpdated);

		Assert.assertTrue(employeeListPage.isEmployeePresent());
	}

	@When("User searches the employee by employee id from test data")
	public void user_searches_the_employee_by_employee_id_from_test_data() {

		EditEmployeePage editEmployeePage = new EditEmployeePage();

		editEmployeePage.searchEmployee(employeeIdUpdated);
	}

	@When("User updates job title and employment status from test data")
	public void user_updates_job_title_and_employment_status_from_test_data() {

		EditEmployeePage editEmployeePage = new EditEmployeePage();

		editEmployeePage.updateEmployee(getJsonData("jobTitle"), getJsonData("employmentStatus"));
	}

	@Then("User should verify employee details are updated successfully")
	public void user_should_verify_employee_details_are_updated_successfully() {

		EditEmployeePage editEmployeePage = new EditEmployeePage();

		Assert.assertEquals(getJsonData("jobTitle"), editEmployeePage.getSelectedJobTitle());

		Assert.assertEquals(getJsonData("employmentStatus"), editEmployeePage.getSelectedEmploymentStatus());

		System.out.println("Employee details updated successfully");
	}

	@When("User validates the employee details using API")
	public void user_validates_the_employee_details_using_api() {

		AddEmployee_Input_Pojo input = new AddEmployee_Input_Pojo(getJsonData("firstName"), getJsonData("lastName"),
				employeeIdUpdated, getJsonData("jobTitle"), getJsonData("employmentStatus"));

		api.initRequest();

		api.addDefaultHeaders();

		api.addPayload(input);

		response = api.sendRequest("POST", "https://reqres.in/api/users");

		Assert.assertEquals(201, response.getStatusCode());

		output = response.as(AddEmployee_Output_Pojo.class);

		Assert.assertEquals(getJsonData("firstName"), output.getFirstName());

		Assert.assertEquals(getJsonData("lastName"), output.getLastName());

		Assert.assertEquals(employeeIdUpdated, output.getEmployeeId());

		Assert.assertEquals(getJsonData("jobTitle"), output.getJobTitle());

		Assert.assertEquals(getJsonData("employmentStatus"), output.getEmploymentStatus());

		System.out.println("Created Id : " + output.getId());
		System.out.println("Created At : " + output.getCreatedAt());

		System.out.println("API Validation Successful");
	}

	@Then("User should verify API details match with UI data")
	public void user_should_verify_api_details_match_with_ui_data() {

		Assert.assertEquals(getJsonData("firstName"), output.getFirstName());

		Assert.assertEquals(getJsonData("lastName"), output.getLastName());

		Assert.assertEquals(employeeIdUpdated, output.getEmployeeId());

		Assert.assertEquals(getJsonData("jobTitle"), output.getJobTitle());

		Assert.assertEquals(getJsonData("employmentStatus"), output.getEmploymentStatus());

		Assert.assertNotNull(output.getId());
		Assert.assertNotNull(output.getCreatedAt());

		System.out.println("API Validation Successful");
	}

	@When("User deletes the employee from UI")
	public void user_deletes_the_employee_from_ui() {

		EmployeeListPage employeeListPage = new EmployeeListPage();

		employeeListPage.deleteEmployee(employeeIdUpdated);
	}

	@Then("User should verify employee is deleted in UI and API")
	public void user_should_verify_employee_is_deleted_in_ui_and_api() {

		EmployeeListPage employeeListPage = new EmployeeListPage();

		employeeListPage.searchEmployee(employeeIdUpdated);

		Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeIdUpdated));

		api.initRequest();
		api.addDefaultHeaders();

		response = api.sendRequest("DELETE", "https://reqres.in/api/users/" + output.getId());

		Assert.assertEquals(204, response.getStatusCode());

		System.out.println("Employee Deleted Successfully in UI and API");
	}

	@When("User logs out from OrangeHRM")
	public void user_logs_out_from_orange_hrm() {

		LogoutPage logoutPage = new LogoutPage();

		logoutPage.logout();
	}

	@Then("User should verify login page is displayed")
	public void user_should_verify_login_page_is_displayed() {

		Assert.assertTrue(getCurrentUrl().contains("login"));

	}
}