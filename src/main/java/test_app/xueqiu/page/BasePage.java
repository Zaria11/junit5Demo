package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public BasePage() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName","Android");
        //当前设备的名字
        caps.setCapability("udid","127.0.0.1:7555");
        //随便填，但不能不填
        caps.setCapability("deviceName","xxxx");
        caps.setCapability("appPackage","com.xueqiu.android");
        caps.setCapability("noReset","true");
        caps.setCapability("appActivity",".common.MainActivity");

        //appium启动端口的地址，部署在服务器上就是服务器的地址
        try {
            driver = new AndroidDriver<>(new URL("http:/localhost:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //隐式等待
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    public MobileElement find(By by){
        return driver.findElement(by);
    }

    public void quit() {
        driver.quit();
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }
}
