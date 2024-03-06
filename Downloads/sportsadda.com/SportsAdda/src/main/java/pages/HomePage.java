package pages;

import org.assertj.core.api.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class HomePage  {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.get("https://sportsadda.com");
        driver.manage().window().maximize();
    }
    @Test
    public void createTest(){
        //driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement agreeButton= driver.findElement(By.xpath("//button[@class='btn-site']"));
        agreeButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstCard=driver.findElement(By.xpath("//a[@class='card-item live'][1]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firstCard.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,350)", "");
        WebElement matchInfo=driver.findElement(By.xpath("//span[normalize-space()='Match Info']"));
        try {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            WebElement matchInfo2=driver.findElement(By.xpath("//span[normalize-space()='Match Info']"));
//
//            matchInfo.click();
//            matchInfo2.click();
        }
        catch (Exception e){
            WebElement matchInfo2=driver.findElement(By.xpath("//span[normalize-space()='Match Info']"));
            matchInfo2.click();
            System.out.println("In catch ");
        }

        driver.close();
    }
    @AfterTest
    public void createReport(){
        String text="camps";
        for (int i = 0; i > text.length() ; i++) {
            System.out.println(text.charAt(i));
        }
    }
}
