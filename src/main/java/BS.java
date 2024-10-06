import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import java.net.URL;
import java.util.Set;

public class BS {
    public static final String AUTOMATE_USERNAME = "mobileautoservic_w86Uka";
    public static final String AUTOMATE_KEY = "SeW8HQo2LzzoUw9qsDK8";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "14");
        caps.setCapability("device", "iPhone 15");
        caps.setCapability("realMobile", "true");

        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("https://"+AUTOMATE_USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub"), caps);
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
        Thread.sleep(5000);
        // To accept/block the popup, you need to switch the context to “NATIVE_APP“ and click on the Allow/Block button.
        driver.context("NATIVE_APP");
        driver.findElement(By.name("Allow")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
