package test_app.xueqiu.page;

import org.openqa.selenium.By;

public class MainPage extends BasePage{
    //    AndroidDriver<MobileElement> driver;
//    AppiumDriver<MobileElement> driver;
    //    IOSDriver
//    WebDriverWait wait;
//
//
//    public MainPage() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        caps.setCapability("platformName","Android");
//        //当前设备的名字
//        caps.setCapability("udid","127.0.0.1:7555");
//        //随便填，但不能不填
//        caps.setCapability("deviceName","xxxx");
//        caps.setCapability("appPackage","com.xueqiu.android");
//        caps.setCapability("noReset","true");
//        caps.setCapability("appActivity",".common.MainActivity");
//
//        //appium启动端口的地址，部署在服务器上就是服务器的地址
//        try {
//            driver = new AndroidDriver<>(new URL("http:/localhost:4723/wd/hub"),caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        //隐式等待
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }

    public SearchPage toSearch(){
//        driver.findElementById("com.xueqiu.android:id/home_search").click();
        click(By.id("home_search"));
        return new SearchPage(driver);
    }



    public StockPage toStock(){
        click(By.xpath("//*[@text='行情']"));
        return new StockPage(driver);
    }
}
