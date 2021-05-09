package cucumber.test.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.homePage;

public class MyStepdefs {
    String url = "https://www.chorus.co.nz/broadband-map";
    WebDriver driver;
    homePage home;

    @Before
    public void loadDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I navigate to broadband map")
    public void i_navigate_to_broadband_map() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("I search for the given address {}")
    public void i_search_for_the_given_address(String address) {
        home = new homePage(driver);
        home.searchAddress(address);
    }

    @Then("the map displays the list of available services at the address")
    public void the_map_displays_the_list_of_available_services_at_the_address() {
        Assert.assertTrue(home.networkCapSection().isDisplayed());
        Assert.assertTrue(home.listOfServices().size() > 0);
    }

    @After
    public void unloadDriver(){
        driver.close();
        driver.quit();
    }
}
