package com.project.fitpeo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Final {

    public static void main(String[] args) throws InterruptedException {

        // Defining flag variable to see if there is any bug in the website or not
        int flag = 0; 

        // Defining WebDriver and initializing ChromeDriver
        WebDriver dr = new ChromeDriver(); 
        
        // Defining WebDriverWait element with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10)); 

        
        // 1. Navigate to the FitPeo Homepage
        dr.get("https://www.fitpeo.com/");

        // Maximize the browser window
        dr.manage().window().maximize(); 

        // Wait for 1 second
        Thread.sleep(1000);

        
        // 2. Navigate to the Revenue Calculator Page
        dr.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
        
        // Wait for 1 second
        Thread.sleep(1000);

        // 3. Scroll to the slider section
        
        // Wait until the slider section is visible
        WebElement sliderSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 crimsonPro css-12siehf']")));
        // Scroll the slider section into view
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("arguments[0].scrollIntoView(true);", sliderSection);

        // 4. Adjust the Slider to 820
        // Locate the slider element
        WebElement slider = dr.findElement(
                By.xpath("//span[contains(@class, 'MuiSlider-thumb')]"));

        // Initialize Actions class for performing complex actions
        Actions actions = new Actions(dr);

        // Wait for 1 second
        Thread.sleep(1000);
        // Calculate the offset needed to move the slider
        double calculatedOffset = 93; 

        // Convert the calculated offset to an integer
        int xOffset = (int) calculatedOffset;

        // Click and hold the slider, move by the calculated offset, release, and send additional right arrow keys
        actions.clickAndHold(slider).moveByOffset(xOffset, 0).release()
                .sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();

        // Validate the text field value
        // Locate the text field element
        WebElement textField = dr.findElement(By.id(":r0:"));
        try {
            // Assert that the text field value is 820
            Assert.assertEquals(textField.getAttribute("value"), "820");
        } catch (AssertionError e1) {
            System.out.println("Error:: The slider is set to 820, but the textfield value is showing as " + textField.getAttribute("value"));
            flag = 1; // Set the flag to 1 if there is an error
        }

        // 5. Update the text field to 560
        // Wait for 1 second
        Thread.sleep(1000);

        // Clear the text field and enter the value 560
        textField.sendKeys(Keys.CONTROL + "A");
        textField.sendKeys(Keys.DELETE);
        textField.sendKeys("560");

        // 6. Validate the slider value if it is 560 or not
        try {
            // Assert that the text field value is 560
            Assert.assertEquals(textField.getAttribute("value"), "560");
        } catch (AssertionError e2) {
            System.out.println("Error:: The slider is set to 560, but the textfield value is showing as " + textField.getAttribute("value"));
            flag = 1; // Set the flag to 1 if there is an error
        }

        // Wait for 1 second
        Thread.sleep(1000);

        // Reset the text field value to 820
        textField.sendKeys(Keys.CONTROL + "A");
        textField.sendKeys(Keys.DELETE);
        textField.sendKeys("820");
        // Wait for 1 second
        Thread.sleep(1000);

        // 7. Select CPT Codes
        // Select the checkboxes for the specified CPT codes
        dr.findElement(By.xpath("((//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3'])[1])")).click();
        // Wait for 1 second
        Thread.sleep(1000);
        dr.findElement(By.xpath("((//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3'])[2])")).click();
        // Wait for 1 second
        Thread.sleep(1000);
        dr.findElement(By.xpath("((//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3'])[3])")).click();
        // Wait for 1 second
        Thread.sleep(1000);
        dr.findElement(By.xpath("((//input[@type='checkbox' and @class='PrivateSwitchBase-input css-1m9pwf3'])[8])")).click();
        // Wait for 1 second
        Thread.sleep(1000);

        // 8. Validate Total Recurring Reimbursement if it is $110700 or not
        // Locate the total reimbursement element
        WebElement totalReimbursement = dr.findElement(By.xpath("((//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4])"));

        try {
            // Assert that the total reimbursement value is $110700
            Assert.assertEquals(totalReimbursement.getText(), "$110700");
        } catch (AssertionError e3) {
            System.out.println("Error:: Total Recurring Reimbursement for all Patients Per Month is actually $110700, but the website shows the value as " + totalReimbursement.getText());
            flag = 1; // Set the flag to 1 if there is an error
        }

        // Wait for 1 second
        Thread.sleep(1000);

        // Quit the driver
        dr.quit();

        // Check if there were any errors
        if (flag == 0) {
            System.out.println("No Error found in the website"); 
        }

    }
}
