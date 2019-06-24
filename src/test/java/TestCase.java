import base.LauchDriver;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/


public class TestCase {
    WebDriver driver;
    List<String> login_tray_items=new ArrayList<String>();
    List<String> tray_items = new ArrayList<String>();
    LauchDriver lauchDriver;


    @Test(priority = 1)
    public void trayTitle(){
        lauchDriver = new LauchDriver();
        tray_items = lauchDriver.getPageObjectManager().getHomePage().trayTitle();
    }


    @Test(dependsOnMethods = {"trayTitle"}, priority = 2)
    public void login(){
        lauchDriver.getPageObjectManager().getLoginPage().user_login();

    }


    @Test(priority = 3)
    public void HomePageValidityOnLogin() throws InterruptedException {
        lauchDriver.getPageObjectManager().getLoginPage().validityToBeOnHomePageAfterLogin();
    }


    @Test(dependsOnMethods = {"login"}, priority = 4)
    public void loginTray(){
        login_tray_items = lauchDriver.getPageObjectManager().getLoginPage().loginTrayItems();

    }


    @Test(priority = 5)
    public void comparision(){
        System.out.println("Output : after comparison");
        System.out.println("Additional tray title after login");
        lauchDriver.getPageObjectManager().getHelper().compare(login_tray_items,tray_items);
        System.out.println("Missing tray titles after login when compared to list before login");
        lauchDriver.getPageObjectManager().getHelper().compare(tray_items,login_tray_items);

    }

    @Test(priority = 6)
    public void closeBrowser(){
        lauchDriver.closeBrowser();
    }




}
