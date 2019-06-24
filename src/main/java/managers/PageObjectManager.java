package managers;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/
public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private Helper helper;
    private LoginPage loginPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public  HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver,getHelper()) : homePage;
    }

    public  LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage(driver,getHelper()) : loginPage;
    }


    public  Helper getHelper(){
        return (helper == null) ? helper = new Helper(driver) : helper;
    }



}
