package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class StockPage extends BasePage{

    public StockPage() {
    }

    public StockPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isEmpty(){
        try {
            find(By.id("portfolio_stockName"));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }

    public StockPage addStock(String keyword,String code){
        if(isEmpty()){
            click(By.id("edit_group"));
            click(By.id("check_all"));
            click(By.id("cancel_follow"));
            click(By.id("tv_right"));
            click(By.id("action_close"));
        }
        click(By.id("action_search"));
        sendKeys(By.id("search_input_text"),keyword);
        click(By.xpath("//*[@text='"+code+"']"));
        click(By.id("follow_btn"));
        return this;
    }
}
