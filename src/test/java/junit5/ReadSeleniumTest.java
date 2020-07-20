package junit5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class ReadSeleniumTest {
    WebDriver driver;

    //复用浏览器登录
    @Test
    public void readSeleniumTest(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if(!dt.equals("null")){
                    SimpleDateFormat sdf =new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    expiry = sdf.parse(dt);
                }
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveCookie(WebDriver driver){
        try {
            //进行保存
            //FileWriter每一个读取一个进行写入，造成IO的损耗
            FileWriter fileWriter=new FileWriter("cookie.txt");
            //加快处理速度，用BufferedWriter写。把它统一存起来一次进行，缓冲节省IO操作
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Cookie cookie:driver.manage().getCookies()){
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
