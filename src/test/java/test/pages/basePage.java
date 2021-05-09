package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
    WebDriver driver;
    WebDriverWait wait;
    basePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 4);
    }
}
