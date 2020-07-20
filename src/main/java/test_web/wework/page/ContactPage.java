package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class ContactPage extends BasePage{
    By addMember=By.linkText("添加成员");
    By username=By.name("username");
    By delete=By.linkText("删除");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo:
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        //显式等待
//        new WebDriverWait(driver,10)
//                .until(ExpectedConditions.elementToBeClickable(addMember));

        while (driver.findElements(this.username).size()==0){
//            driver.findElement(addMember).click();
            click(addMember);
        }

//        driver.findElement(this.username).sendKeys(username);
//        driver.findElement(By.name("acctid")).sendKeys(acctid);
//        driver.findElement(By.name("mobile")).sendKeys(mobile);
//        driver.findElement(By.cssSelector(".js_btn_save")).click();
        sendKeys(this.username,username);
        sendKeys(By.name("acctid"),acctid);
        sendKeys(By.name("mobile"),mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    public ContactPage search(String keyword){
//        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        sendKeys(By.id("memberSearchInput"),keyword);
//        click(delete);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ContactPage delete(){
       click(delete);
       click(By.linkText("确认"));
       click(By.id("clearMemberSearchInput"));
//        driver.findElement(delete).click();
//        driver.findElement(By.linkText("确认")).click();
//        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }

    public ContactPage importFile(URL path){
        System.out.println(path);

        String pathFile="";
        try {
          String  path_utf= URLDecoder.decode(path.getFile(), "UTF-8");
            pathFile=path_utf.substring(1,path_utf.length());
            System.out.println(path_utf);
            System.out.println(pathFile);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        upload(By.name("file"),pathFile);
        click(By.linkText("确认导入"));
        click(By.linkText("前往查看"));
        return this;
    }

    public ContactPage addPart(String part){
        click(By.linkText("添加子部门"));
        sendKeys(By.name("name"),part);
        click(By.linkText("确定"));
        return this;
    }

    public ContactPage setPart(String part){
        click(By.xpath("(//input[@type='checkbox'])[4]"));
        click(By.linkText("设置所在部门"));
        click(By.linkText(part));
        click(By.linkText("确认"));
        return this;
    }
}
