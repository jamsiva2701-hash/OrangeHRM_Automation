===========================================
ORANGEHRM EMPLOYEE LIFECYCLE AUTOMATION
===========================================

Project Name:
OrangeHRM Employee Lifecycle Automation Framework

Author:
Jamuna

Framework Type:
Hybrid Automation Framework (UI + API)

Technology Stack:
--------------------------------------------------
Language            : Java 21
Build Tool          : Maven
UI Automation       : Selenium WebDriver
API Automation      : Rest Assured
BDD Framework       : Cucumber
Design Pattern      : Page Object Model (POM)
Reporting           : Cucumber Report
Test Data           : JSON
Logging             : Console Logs
Version Control     : Git & GitHub

Project Objective:
--------------------------------------------------
Automate complete Employee Lifecycle Management
using UI and API validation.

Scenario Covered:
--------------------------------------------------

1. Login
   - Launch OrangeHRM Application
   - Login using valid credentials
   - Verify Dashboard page

2. Add Employee
   - Navigate to PIM Module
   - Click Add Employee
   - Enter Employee Details
   - Upload Profile Picture
   - Save Employee
   - Verify Employee Creation

3. Edit Employee
   - Search Employee using Employee ID
   - Update Job Title
   - Update Employment Status
   - Save Changes
   - Verify Updated Details

4. Validate Employee Using API
   - Retrieve Employee Details
   - Compare API Response with UI Data
   - Validate Employee Information

5. Delete Employee
   - Search Employee
   - Delete Employee Record
   - Verify Employee Deletion

6. Logout
   - Logout from Application
   - Verify Successful Logout

Framework Structure:
--------------------------------------------------

src/test/java

com.orangehrm.base
    BaseClass.java
    ApiBaseClass.java

com.orangehrm.pages
    LoginPage.java
    DashboardPage.java
    AddEmployeePage.java
    EmployeeListPage.java
    JobPage.java

com.orangehrm.pojo
    Employee.java

com.orangehrm.stepdefinition
    EmployeeLifecycleStep.java

com.orangehrm.hooks
    Hooks.java

com.orangehrm.utility
    JsonReader.java

src/test/resources

features
    EmployeeLifeCycle.feature

testdata
    EmployeeData.json

profile
    profile.png

Configuration:
--------------------------------------------------

Application URL:
https://opensource-demo.orangehrmlive.com/

Username:
Admin

Password:
admin123

Sample Test Data:
--------------------------------------------------

First Name         : Jamuna
Last Name          : M
Job Title          : Account Assistant
Employment Status  : Freelance
Profile Picture    : src/test/resources/profile/profile.png

Source Code Repository:
--------------------------------------------------

GitHub Repository:
https://github.com/jamsiva2701-hash/OrangeHRM_Automation/

Clone Command:

git clone https://github.com/jamsiva2701-hash/OrangeHRM_Automation.git

Execution Steps:
--------------------------------------------------

1. Clone the Project

2. Open the Project in Eclipse

3. Update Maven Dependencies

4. Execute the Test

   mvn test

OR

   Run the Cucumber Runner Class

Expected Outcome:
--------------------------------------------------

✓ User Login Successful

✓ Employee Created Successfully

✓ Employee Updated Successfully

✓ API Validation Successful

✓ Employee Deleted Successfully

✓ User Logout Successful

Framework Features:
--------------------------------------------------

✓ Selenium WebDriver

✓ Rest Assured API Automation

✓ Cucumber BDD

✓ JSON Data Driven Testing

✓ Reusable Base Class

✓ Page Object Model (Without PageFactory)

✓ Screenshot Capture for Execution

✓ UI and API Validation

✓ Maven Build Management

Notes:
--------------------------------------------------

- Framework follows Page Object Model (POM) design pattern.
- Page classes contain only By locators and business methods.
- Selenium reusable methods are maintained in BaseClass.
- API reusable methods are maintained in ApiBaseClass.
- Test data is maintained in JSON files.
- Screenshots are attached to Cucumber reports.
- Employee details are validated through both UI and API.
- Single end-to-end scenario covers complete employee lifecycle.

===========================================
END OF DOCUMENT
===========================================