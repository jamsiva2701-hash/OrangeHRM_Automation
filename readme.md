# OrangeHRM Employee Lifecycle Automation Framework

A comprehensive **Java + Selenium WebDriver + Rest Assured + Cucumber BDD** automation framework for validating the complete Employee Lifecycle Management process in OrangeHRM.

---

# 📋 Overview

This framework automates end-to-end testing of the OrangeHRM application using both UI and API validation.

### Employee Lifecycle Covered

* User Login
* Employee Creation
* Profile Picture Upload
* Employee Search
* Job Details Update
* Employment Status Update
* Employee Validation through API
* Employee Deletion
* User Logout

The framework follows the **Page Object Model (POM)** design pattern and supports reusable automation components for scalable test development.

---

# ✨ Key Features

## UI Automation

✓ Selenium WebDriver

✓ Cross Browser Support

✓ Page Object Model (POM)

✓ Reusable Base Framework

✓ Screenshot Capture

✓ Data-Driven Testing using JSON

---

## API Automation

✓ Rest Assured Integration

✓ API Request & Response Validation

✓ UI and API Data Comparison

✓ Reusable API Utility Methods

---

## Reporting

✓ Cucumber HTML Reports

✓ Execution Logs

✓ Failure Screenshots

✓ Step-Level Execution Details

---

# 📁 Framework Structure

```text
OrangeHRM_Automation/

src/test/java

com.orangehrm.base
├── BaseClass.java
└── ApiBaseClass.java

com.orangehrm.pages
├── LoginPage.java
├── DashboardPage.java
├── AddEmployeePage.java
├── EmployeeListPage.java
└── JobPage.java

com.orangehrm.pojo
└── Employee.java

com.orangehrm.stepdefinition
└── EmployeeLifecycleStep.java

com.orangehrm.hooks
└── Hooks.java

com.orangehrm.utility
└── JsonReader.java

src/test/resources

features
└── EmployeeLifeCycle.feature

testdata
└── EmployeeData.json

profile
└── profile.png

target/
└── Cucumber Reports
```

---

# 🚀 Setup Instructions

## Prerequisites

* Java 21 or higher
* Maven 3.9+
* Eclipse / IntelliJ IDEA
* Git

---

## Clone Repository

```bash
git clone https://github.com/jamsiva2701-hash/OrangeHRM_Automation.git
```

Navigate to project:

```bash
cd OrangeHRM_Automation
```

---

## Install Dependencies

```bash
mvn clean install
```

---

# ⚙️ Configuration

### Application URL

```text
https://opensource-demo.orangehrmlive.com/
```

### Login Credentials

```text
Username : Admin
Password : admin123
```

### Sample Test Data

```json
{
  "firstName": "Jamuna",
  "lastName": "M",
  "jobTitle": "Account Assistant",
  "employmentStatus": "Freelance"
}
```

---

# 🧪 Running Tests

## Run Complete Test Suite

```bash
mvn test
```

---

## Run Specific Tagged Scenario

```bash
mvn test -Dcucumber.filter.tags="@EmployeeLifecycle"
```

---

## Run from Eclipse

1. Import Maven Project
2. Update Maven Dependencies
3. Open Runner Class
4. Run As → JUnit Test

---

# 📝 Automated Test Scenario

```gherkin
Feature: Employee Lifecycle Management

Scenario: Verify complete employee lifecycle using UI and API

Given User launches OrangeHRM application
When User logs in with valid credentials
Then Dashboard should be displayed

When User adds a new employee
Then Employee should be created successfully

When User updates employee details
Then Updated details should be displayed

When User validates employee details using API
Then API data should match UI data

When User deletes employee
Then Employee should be removed successfully

When User logs out
Then Login page should be displayed
```

---

# 📊 Expected Results

✓ Login Successful

✓ Employee Created Successfully

✓ Employee Updated Successfully

✓ API Validation Successful

✓ Employee Deleted Successfully

✓ Logout Successful

---

# 📚 Dependencies Used

| Dependency         | Purpose           |
| ------------------ | ----------------- |
| Selenium WebDriver | UI Automation     |
| Rest Assured       | API Automation    |
| Cucumber Java      | BDD Framework     |
| Cucumber JUnit     | Test Execution    |
| Maven              | Build Management  |
| Jackson Databind   | JSON Parsing      |
| WebDriverManager   | Driver Management |
| JUnit              | Assertions        |
| Apache Commons IO  | File Utilities    |

---

# 🔧 Framework Components

## BaseClass.java

Contains:

* Browser Initialization
* Driver Management
* Wait Utilities
* Screenshot Utilities
* Reusable Selenium Methods

---

## ApiBaseClass.java

Contains:

* API Request Setup
* API Execution Methods
* Response Validation
* Reusable Rest Assured Methods

---

## Page Objects

Each page class contains:

* Web Element Locators
* Page Actions
* Business Methods

Example:

```java
public void addEmployee() {
    // Employee creation logic
}
```

---

# 📈 Reporting

After execution, reports are available in:

```text
target/cucumber-reports/
```

Report Includes:

* Scenario Status
* Passed/Failed Steps
* Execution Summary
* Failure Screenshots

---

# 🏆 Framework Highlights

* Hybrid Framework (UI + API)
* Page Object Model (POM)
* JSON Data-Driven Testing
* Reusable Components
* End-to-End Employee Lifecycle Validation
* Cucumber BDD Reporting
* Scalable and Maintainable Design
* Industry Standard Framework Structure

---

# 👩‍💻 Author

**Jamuna**

Senior QA Automation Engineer

**Version:** 1.0.0

**Technology Stack:** Java | Selenium | Rest Assured | Cucumber | Maven

**Status:** Production Ready ✓
