# FitPeo Automation

## Overview
This project automates the interaction with the FitPeo Homepage and Revenue Calculator Page using Selenium WebDriver in Java. The automation script performs the following tasks:
- Navigates to the FitPeo Homepage.
- Navigates to the Revenue Calculator Page.
- Scrolls to the slider section.
- Adjusts the slider value.
- Updates the text field associated with the slider.
- Selects specific CPT codes.
- Validates the total recurring reimbursement value.

## Prerequisites
- Java Development Kit (JDK) installed.
- Maven installed.
- Chrome browser installed.
- ChromeDriver executable available on your system.

## Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/fitpeo-automation.git
    ```
2. Navigate to the project directory:
    ```bash
    cd fitpeo-automation
    ```
3. Update the `path/to/chromedriver` in `WebDriverManager.java` with the actual path to your ChromeDriver executable.
4. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Running the Automation Script
1. Run the `FitPeoAutomation` class:
    ```bash
    mvn exec:java -Dexec.mainClass="com.fitpeo.automation.FitPeoAutomation"
    ```

## Notes
- Ensure that the FitPeo website is accessible and the element locators (`id`, `linkText`, etc.) are correct.
- Adjust timeouts or waits if necessary to handle any loading delays.
- Modify the paths and URLs in the script as needed for your environment.
