package LoginBaseWebLocators;

import Base.LaunchWebsite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreenWebelement extends LaunchWebsite {

private WebDriver driver;




    // if we taking directly input then this is valid...but we doing data driven testing
    //create constructior to call driver in each testcase
        public  LoginScreenWebelement(WebDriver driver){
            this.driver=driver;

        }
        public void UsernameMethod(String EnterUsername){
             driver.findElement(By.id("username")).sendKeys(EnterUsername);        }
        public void PasswordMethod(String EnterPassword) {
        driver.findElement(By.name("password")).sendKeys(EnterPassword);       }
        public void LoginMethod(){
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        }


}
