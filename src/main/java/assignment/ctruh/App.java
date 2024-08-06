package assignment.ctruh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class App 
{
    private static WebDriver driver;

    public static void main(String[] args)
    {
        String facebookXPath ="/html/body/div[2]/div[2]/div/div[1]/div[2]";
        String googleXPath = "/html/body/div[2]/div[2]/div/div[1]/div[1]";
        String githubXPath = "/html/body/div[2]/div[2]/div/div[1]/div[3]";
        String linkedInXPath = "/html/body/div[2]/div[2]/div/div[1]/div[4]";
        String manualXPath = "//*[@id=\"test-7b9fdb1c-4151-4dfd-a98e-eefb882f0136\"]";
        System.out.println("Hello World!");
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Set options if needed
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Run in headless mode if desired

        driver = new ChromeDriver(options);
        driver.get("https://www.ctruh.com/sign-up");

        clickButton(googleXPath);
        sleep(2000);
        clickButton(facebookXPath);
        sleep(2000);
        clickButton(githubXPath);
        sleep(2000);
        clickButton(linkedInXPath);
        sleep(2000);
        clickButton(manualXPath);
        sleep(2000);
        
        driver.quit();
    }
    
    static void sleep(int milliseconds) {
        // Pause for the specified amount of milliseconds
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    static void clickButton(String xpath) {
        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        
        // Click the element using JavaScript to avoid interception
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        // Pause for 5 seconds
        sleep(5000);
        
        // Navigate back to the previous page
        driver.navigate().back();
    }
}
