package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    private By nameLocator = By.id("name");

    public SearchPage() {
    }

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchPage search(String keyword){
//        MobileElement el5 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
//        el5.sendKeys(keyword);
        sendKeys(By.id("search_input_text"),keyword);
        return this;
    }

    public List<String> getSearchList(){
        List<String> nameList = new ArrayList<>();
//        for (Object element: driver.findElements(nameLocator)){
//            nameList.add(((WebElement)element).getText());
//        }
        driver.findElements(nameLocator).forEach(element -> nameList.add(element.getText()));
        //todo: stream lamda优化
        return nameList;
    }

    public Double getPrice(){
        //todo:独立一个独立的po方法
//        driver.findElement(nameLocator).click();
        click(nameLocator);
        return  Double.valueOf(find(By.id("current_price")).getText());
    }
}
