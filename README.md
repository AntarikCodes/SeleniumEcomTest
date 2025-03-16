**#Project Overview**
This is a Selenium TestNG Automation Framework built to test the OpenCart Demo site. The framework automates end-to-end flows, including login, product selection, cart validation, checkout, and order confirmation.

**#Tech Stack**
Java (Automation Scripting)
Selenium WebDriver (Browser Automation)
TestNG (Test Execution & Assertions)
Extent Reports (Test Reporting)
WebDriverManager (Driver Management)

**#Project Structure**
📂 src/main/java
base/ → Handles WebDriver setup & common utilities.
pageElements/ → Stores locators for all web pages.
pageEvents/ → Contains actions & interactions with web elements.
utils/ → Stores helper classes like listeners & configurations.

📂 src/test/java
Testcase/ → Contains all the TestNG test cases.

**#Test Cases Covered**
⚪ Complete purchase flow – It validates correct login functionality,cart functionality,Checks total price matches expected calculation, Completes the full order process.
⚪ Invalid Login – Displays error for incorrect credentials.

**Setup & Execution**
Prerequisites
🔹 Install Java 11+
🔹 Install Maven
🔹 Clone this repository:

git clone https://github.com/YOUR_USERNAME/ECommerceTesting.git
cd ECommerceTesting

Run Tests

To execute all test cases, run:

mvn test

Generate Reports

After execution, Extent Reports will be available in:

target/extent-reports/
