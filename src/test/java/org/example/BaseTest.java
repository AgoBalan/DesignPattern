package org.example;

import org.example.DataLoads.DataProvider;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverManager;

public class BaseTest {

    protected  WebDriver driver;
    protected TravelHomePage travelHomePage;
//    public WebDriver initiateDriver() {
//        System.getProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//       // WebDriver driver = new ChromeDriver();
//        return DriverManager.getDriver();
//    }
    @BeforeMethod
    public void setup() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Setup");
        driver = DriverManager.getDriver();
        travelHomePage = new TravelHomePage(driver);
      }

    @AfterMethod()
    public void tearDown(){
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Teardown");
        DriverManager.quitDriver();
    }
}

