package test_web.wework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeWork {

    @Test
    void chrome(){
        String url="https://work.weixin.qq.com/wework_admin/frame";
        ChromeDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan","zh"));
        driver.manage().addCookie(new Cookie(" _ga","GA1.2.226261788.1593357105"));
        driver.manage().addCookie(new Cookie(" _gid","GA1.2.480968715.1593357105"));
        driver.manage().addCookie(new Cookie(" _gat","1"));
        driver.manage().addCookie(new Cookie(" wwrtx.d2st","a7822641"));
        driver.manage().addCookie(new Cookie(" wxpay.corpid","1970324959151200"));
        driver.manage().addCookie(new Cookie(" wxpay.vid","1688850346026650"));
        driver.manage().addCookie(new Cookie(" wwrtx.vid","1688850346026650"));
        driver.manage().addCookie(new Cookie(" wwrtx.logined","true"));

        System.out.println(driver.manage().getCookies());
        driver.get(url);

    }
}
