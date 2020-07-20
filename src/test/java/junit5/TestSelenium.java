package junit5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestSelenium {
    WebDriver driver;

    @Test
    public  void testSelenium(){
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");

        driver=new ChromeDriver(options);
        System.out.println(driver.manage().getCookies());
        //[wwrtx.refid=01378119; path=/; domain=.work.weixin.qq.com, wxpay.corpid=1970324959151200; path=/; domain=.work.weixin.qq.com, wwrtx.ltype=1; path=/; domain=.work.weixin.qq.com, wwrtx.d2st=a1497735; path=/; domain=.work.weixin.qq.com, _gid=GA1.2.1809671712.1592922182; expires=星期三, 24 六月 2020 10:31:42 CST; path=/; domain=.qq.com, wwrtx.sid=AAJY3C0rzWza8hlo0wDxvhnmJd5jCb_KmvT8s9HoZyG6TfF_nQZG0GmIlN8qDckR; path=/; domain=.work.weixin.qq.com, Hm_lvt_9364e629af24cb52acc78b43e8c9f77d=1592922182; expires=星期三, 23 六月 2021 10:31:38 CST; path=/; domain=.work.weixin.qq.com, ww_rtkey=3535249998; path=/; domain=work.weixin.qq.com, Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d=1592922699; path=/; domain=.work.weixin.qq.com, wxpay.vid=1688850346026650; path=/; domain=.work.weixin.qq.com, _ga=GA1.2.1961709739.1592922182; expires=星期四, 23 六月 2022 10:31:42 CST; path=/; domain=.qq.com, wwrtx.vst=o2Hag_lBJz8kR4JKTltMbgDvMY5z7M3iQmjP4L84ecTxeSacxpU81OfaV9vj4IyYCVxCoATD5doVfJIEw-UsJx0pHGV2_i3cy-gOGMeMIxq1D9otjnpvegpB6cbCr6m9l-MxqYxZzCq5Vr6V159SA4kzJXn2QYEMgRAF8gxbS7r-040YSXKuKkHEUwxek_0vxe8ys0T_Lvdf1HuhsXNo4saeKiKfvGZhAY7R5DQcuf7ZH31wMJEUwFSBzb-GX9Wa0jDpRDUVrZeOBmapkkZVYA; path=/; domain=.work.weixin.qq.com, wwrtx.logined=true; path=/; domain=.work.weixin.qq.com, wwrtx.vid=1688850346026650; path=/; domain=.work.weixin.qq.com, wwrtx.i18n_lan=zh; expires=星期四, 23 七月 2020 10:36:34 CST; path=/; domain=.work.weixin.qq.com, wwrtx.ref=direct; path=/; domain=.work.weixin.qq.com]
        try {
            //进行保存
            //FileWriter每一个读取一个进行写入，造成IO的损耗
            FileWriter fileWriter=new FileWriter("cookie.txt");
            //加快处理速度，用BufferedWriter写。把它统一存起来一次进行，缓冲节省IO操作
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Cookie cookie:driver.manage().getCookies()){
//                cookie.getName();
//                cookie.getDomain();
//                cookie.getValue();
//                cookie.getPath();
//                cookie.getExpiry();
//                cookie.isSecure();

                    bufferedWriter.write(cookie.getName()+';'+
                            cookie.getValue()+';'+
                            cookie.getDomain()+';'+
                            cookie.getPath()+';'+
                            cookie.getExpiry()+';'+
                            cookie.isSecure());
                    bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
