package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/
public class HomePage {

    WebDriver driver;
    Helper helper;
    List<String> tray_items= new ArrayList<String>();


    @FindBy(className ="tray-link")
    List<WebElement> tray_link;


    public HomePage(WebDriver driver, Helper helper){
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);

    }


    public List<String> trayTitle(){
        int size= Integer.valueOf(System.getProperty("size"));
        helper.codeToScroll();
        List<WebElement> tray=tray_link;
        System.out.println("List of tray title retrieved before login :");
        for(int i=0;i<size;i++){
            System.out.println(tray.get(i).getText());
            tray_items.add(tray.get(i).getText());
        }
        return tray_items;
    }


}
