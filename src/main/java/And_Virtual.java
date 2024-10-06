import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class And_Virtual {


    String userName="belalahmad";
    String accessKey="cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";

    //    String userName = System.getenv("belalahmad") == null ? "username" : System.getenv("LT_USERNAME"); //Add username here
//    String accessKey = System.getenv("cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj") == null ? "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here
//    String app_id = System.getenv("lt://APP1016041711724861920246907") == null ? "lt://proverbial-android" : System.getenv("LT_APP_ID");      //Enter your LambdaTest App ID at the place of lt://proverbial-android
    String grid_url = System.getenv("LT_GRID_URL") == null ? "hub.lambdatest.com" : System.getenv("LT_GRID_URL");

    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "android automation test");
            capabilities.setCapability("name", platform + " " + device + " " + version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion", version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("autoGrantPermissions", true);


            //capabilities.setCapability("geoLocation", "HK");

            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new AppiumDriver(new URL(hub), capabilities);

            // Navigate to the website where location popup needs to be handled
            driver.get("https://belaletech.github.io/allow-location-permission/"); // Replace with your actual URL
            Thread.sleep(2000); // Wait for 2 seconds after loading the page

            // Fill out the form
            MobileElement nameInput = (MobileElement) driver.findElement(By.xpath("//*[@id=\"name\"]")); // Replace with the correct element locator
            nameInput.sendKeys("belal");
            Thread.sleep(2000); // Wait for 2 seconds after entering name

            MobileElement emailInput =(MobileElement) driver.findElement(By.xpath("//*[@id=\"email\"]")); // Replace with the correct element locator
            emailInput.sendKeys("belal@gmail.com");
            Thread.sleep(2000); // Wait for 2 seconds after entering email

            driver.findElement(By.xpath("//*[@id=\"locationForm\"]/button")).click();
//            MobileElement submitButton =(MobileElement) driver.findElement(By.xpath("//*[@id=\"locationForm\"]/button")); // Replace with the correct element locator
//            submitButton.click();

            driver.context("NATIVE_APP");
            Thread.sleep(2000);

            System.out.println(driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).getText());

            driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();

            Thread.sleep(2000); // Wait for 2 seconds after clicking the button


//            Alert savePopupAlert;
//            savePopupAlert = driver.switchTo().alert();
//            String alertText = savePopupAlert.getText();
//            if (alertText.contains("Allow"))
//            { savePopupAlert.accept(); }

//            driver.context("NATIVE_APP");
//            driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
            driver.context("NATIVE").switchTo().alert().accept();
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();


            Thread.sleep(2000);
            System.out.println("Form submitted successfully and popup handled.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
