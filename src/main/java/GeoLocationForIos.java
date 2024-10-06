import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class GeoLocationForIos {

    String userName="belalahmad";
    String accessKey="cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";

    String grid_url = System.getenv("LT_GRID_URL") == null ? "hub.lambdatest.com" : System.getenv("LT_GRID_URL");

//    AppiumDriver driver;

    AppiumDriver<IOSElement> driver;

    @Test
    @Parameters(value = {"device", "version", "platform"})
    public void iOSGeoLocationTest(String device, String version, String platform) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("build", "Ios test");
            caps.setCapability("platformName", "ios");
            caps.setCapability("deviceName", "iPhone 15 Pro");
            caps.setCapability("platformVersion", "17.0");
            caps.setCapability("name", platform + " " + device + " " + version);

            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new IOSDriver<>(new URL(hub), caps);

            driver.get("https://the-internet.herokuapp.com/geolocation");
            driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
            Thread.sleep(5000);

            // Switch to native app context to handle the permission popup
            driver.context("NATIVE_APP");
            driver.findElement(MobileBy.name("Allow Once")).click();

            Thread.sleep(5000); // Waiting after handling the popup
            System.out.println("Geolocation permission popup handled successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
