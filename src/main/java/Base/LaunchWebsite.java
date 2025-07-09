package Base;

import org.apache.commons.lang3.time.DurationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LaunchWebsite {
protected WebDriver driver;
@BeforeClass
public void setBaseURl()  {
     //Class level driver
  driver =new ChromeDriver();
  //Implicit wait for load each webelement
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

driver.manage().deleteAllCookies();
driver.manage().window().maximize();

    driver.get("https://the-internet.herokuapp.com/login");

System.out.println(driver.getTitle());

 }

@AfterClass
    public void CloseBrowser(){
  if(driver != null){
         driver.quit();
         System.out.println("All open browser are closed succesfully");
     }
}
}
