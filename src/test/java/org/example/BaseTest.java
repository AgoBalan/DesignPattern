package org.example;

import org.example.DataLoads.DataProvider;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverManager;

public class BaseTest extends DataProvider {

    WebDriver driver;
    TravelHomePage travelHomePage;
//    public WebDriver initiateDriver() {
//        System.getProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//       // WebDriver driver = new ChromeDriver();
//        return DriverManager.getDriver();
//    }
    @BeforeTest
    public void setup() {
        driver = DriverManager.getDriver();
        travelHomePage = new TravelHomePage(driver);
      }

    @AfterTest()
    public void tearDown(){
        driver.quit();
    }
}

