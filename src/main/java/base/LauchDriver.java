package base;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/
public class LauchDriver {
    WebDriver driver;
    PageObjectManager pageObjectManager;


    public  LauchDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.hotstar.com/");
        driver.manage().window().maximize();

    }

    public PageObjectManager getPageObjectManager(){
        return (pageObjectManager == null) ? pageObjectManager = new PageObjectManager(driver) : pageObjectManager;
    }



    public void closeBrowser(){
        driver.quit();
    }

}
