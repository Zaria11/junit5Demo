package test_app.xueqiu.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.StockPage;

public class SearchStockTest {
    static MainPage mainPage;
    static StockPage stockPage;

    @BeforeAll
    static void beforeAll() {
        stockPage = new MainPage().toStock();
    }

    @AfterAll
    static void afterAll(){
        stockPage.quit();
    }

    @Test
    void addStock(){
        stockPage.addStock("alibaba","BABA");
    }

}
