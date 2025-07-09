package LoginTestCase;
import Base.LaunchWebsite;
import LoginBaseWebLocators.LoginScreenWebelement;
import Utils.CSVUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login_Multiple_Scenario_TC01 extends LaunchWebsite {


//    private  WebDriver driver;

  @Test (dataProvider = "LoginData", dataProviderClass = CSVUtils.class)
    public void SetActionUsername(String EnterUsername, String EnterPassword, String expectedResult) {

      LoginScreenWebelement loginpage = new LoginScreenWebelement(driver);
      loginpage.UsernameMethod(EnterUsername);
      loginpage.PasswordMethod(EnterPassword);
      loginpage.LoginMethod();

      String actualMessage = driver.findElement(By.id("flash")).getText().trim(); // Adjust locator

      if (actualMessage.contains("Your username is invalid!")) {
          Assert.assertTrue(actualMessage.contains("Your username is invalid!"),
                  "Fields are required and not allowblank " + expectedResult);
      } else {
          Assert.assertTrue(actualMessage.contains("You logged into a secure area!"),
                  "You logged into a secure area! " + expectedResult);

      }

  }
  @DataProvider(name="LoginData")
    public Object[][] readCSV() throws IOException {
        String filePath = "C:/Users/Akshata/IdeaProjects/DataDrivenTestProject/TestData/UserNamePassword.csv";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        List<Object[]> data = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            data.add(fields);
        }
        reader.close();

        return data.toArray(new Object[0][]);
    }
    }








