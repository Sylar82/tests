package chuser.autotest;
import com.google.common.base.Verify;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class FirstTest {

    private static WebDriver driver;

     @BeforeClass
    public static void setup()


    {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://wltest.chuser.ru:9001/index.xhtml");
    }
         @Test
         public void UserLogin() {


             WebElement loginButton = driver.findElement(By.cssSelector("#body > div.app > header > div.join > nav > a:nth-child(2)"));
             loginButton.click();

             WebElement loginField = driver.findElement(By.id("loginForm:emailLogin"));
             loginField.sendKeys("admin");

             WebElement PasswordField = driver.findElement(By.id("loginForm:passwordLogin"));
             PasswordField.sendKeys("chuserman");

             WebElement EnterButton = driver.findElement(By.cssSelector("#loginForm\\3a loginButton > span"));
             EnterButton.click();


            WebElement Profiletext = driver.findElement(By.xpath("//*[@id=\"j_idt72:bids_content\"]/p[3]/a"));
            WebElement Text = Profiletext.findElement(By.xpath("//*[@id=\"j_idt72:bids_content\"]/p[3]/a"));
            Assert.assertEquals(Profiletext, Text);




        }

           @AfterClass
        public static void TearDown() throws InterruptedException {

          WebElement SliderButton = driver.findElement(By.cssSelector("#profile-options > i"));
          SliderButton.click();

               WebDriverWait wait = new WebDriverWait(driver, 10);
               WebElement LogOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menuform\\3a j_idt62")));
               driver.quit();
    }






}
