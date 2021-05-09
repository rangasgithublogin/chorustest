package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class homePage extends basePage {
    public homePage(WebDriver driver){
        super(driver);
    }

    public void searchAddress(String address){
        driver.findElement(By.id("wialus-search-input")).sendKeys(address);
        String xpath = "//div[contains(@class, 'selected') and text() = '" + address + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public WebElement networkCapSection(){
        String hXPATH = "//div[@class='location-details-now']//h3[text()='Network capability at this address now']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hXPATH)));
        return driver.findElement(By.xpath(hXPATH));
    }

    public List<WebElement> listOfServices(){
        return driver.findElements(By.xpath("//div[@class='location-details-now']//ul"));
    }
}
