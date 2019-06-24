package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    Helper helper;
    List<String> login_tray_items = new ArrayList<String>();


    @FindBy(className = "signIn")
    WebElement signInButton;

    @FindBy(className = "modal-body")
    WebElement box;

    @FindBy(className = "email-fb-button")
    WebElement emailButton;

    @FindBy(id = "emailID")
    WebElement emailIdBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(className="dropdown-container")
    WebElement profileImg;




    public LoginPage(WebDriver driver, Helper helper){
        this.driver = driver;
        this.helper = helper;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);

    }



    public void user_login(){
        String username =System.getProperty("username");
        String password =System.getProperty("password");
        signInButton.click();
        emailButton.click();
        emailIdBox.sendKeys(username);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        passwordBox.sendKeys(password);
        new Actions(driver).sendKeys(Keys.ENTER).perform();

    }



    public void validityToBeOnHomePageAfterLogin() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(profileImg));
        Thread.sleep(1000);
        driver.navigate().to("https://www.hotstar.com/");
    }



    public List<String> loginTrayItems(){
        int size =Integer.parseInt(System.getProperty("size"));
        helper.codeToScroll();
        List<WebElement> login_tray=driver.findElements(By.className("tray-link"));
        System.out.println("List of trays after login");
        for(int i=0;i<size;i++){
            System.out.println(login_tray.get(i).getText());
            login_tray_items.add(login_tray.get(i).getText());
        }
        return login_tray_items;

    }



}
