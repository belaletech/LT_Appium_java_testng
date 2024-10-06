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

public class GeoLocationTest {


    String userName="belalahmad";
    String accessKey="cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";

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


            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new AppiumDriver(new URL(hub), capabilities);

            driver.get("https://www.gps-coordinates.net/my-location"); // Replace with your actual URL
//            Thread.sleep(2000);

            driver.context("NATIVE_APP");
            Thread.sleep(2000);

            System.out.println(driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).getText());

            driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();

            driver.context("NATIVE_APP");

            Thread.sleep(2000); // Wait for 2 seconds after clicking the button
            System.out.println("Form submitted successfully and popup handled.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
