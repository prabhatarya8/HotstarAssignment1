package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by Prabhat Arya on  Jun,20 2019
 **/


public class Helper {
    WebDriver driver;

    public Helper(WebDriver driver){
        this.driver= driver;
    }

    public void codeToScroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void compare(List<String> list1, List<String> list2) {
        if (list2.containsAll(list1)) {
            System.out.println("Both data matched ");
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (!list2.contains(list1.get(i))) {
                    System.out.println(list1.get(i));
                }
            }
        }
    }



}
