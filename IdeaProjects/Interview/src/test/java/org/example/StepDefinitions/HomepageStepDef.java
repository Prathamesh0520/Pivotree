package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class HomepageStepDef  {

        private WebDriver driver;

        @Before
        public void setup(){
            driver=new ChromeDriver();
        }

        @After
        public void tearDown(){
            if(driver!=null){
                driver.quit();
            }
        }

        @Given(value = "User Open Chrome")
        public void user_open_chrome() {
            driver.get("https://spartacus-demo.eastus.cloudapp.azure.com/electronics-spa/en/USD/");

        }

        @When("User enter URL")
        public void user_enter_url() {
            driver.manage().window().maximize();
        }

        @Then("Hompage will be Open")
        public void hompage_will_be_open() {
            driver.getTitle();
             Assert.assertEquals(driver.getTitle(),"Homepage");
        }

        @Given("User is on Homepage")
        public void user_is_on_homepage() {
        }

        @When("User click on Product")
        public void user_click_on_product() {
            List<WebElement> products = driver.findElements(By.xpath("//h3[@class='cx-product-name']"));
            for (WebElement product:products){
                System.out.println(product.getText());
                if (product.getText()=="Photosmart E317 Digital Camera"){
                    product.click();
                    // Assert.assertEquals(product.getText(),"Photosmart E317 Digital Camera");
                }
            }
        }

        @Then("User navigate to Product Details page")
        public void user_navigate_to_product_details_page() {

        }

        @Given("User is on Product Page")
        public void user_is_on_product_page() {

        }

        @When("User click on Show Reviews Button")
        public void user_click_on_show_reviews_button() {
            WebElement Rating = driver.findElement(By.xpath("//div[@class='rating'].button[@class='btn btn-link cx-action-link']"));
            Rating.click();
        }

        @Then("User Navigate to the Reviews Tab")
        public void user_navigate_to_the_reviews_tab() {
            WebElement Heading = driver.findElement(By.xpath("//h3[text()='Overall Rating']"));
             Assert.assertEquals(Heading,"Overall Rating");
        }

    }

