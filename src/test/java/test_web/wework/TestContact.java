package test_web.wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.wework.page.ContactPage;
import test_web.wework.page.MainPage;

public class TestContact {
    static MainPage main;
    static ContactPage contact;

    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddMember(){
        contact.addMember("4","4","15600111211");
        //todo:assert
    }

    @Test
    void testSearch(){
        contact.search("4").delete();
    }

    @Test
    void testImportFile(){
        contact.importFile(this.getClass().getResource("/通讯录批量导入模板.xlsx"));
    }

    @Test
    void testAddPart(){
        contact.addPart("产品部");
    }

    @Test
    void testSetPart(){
        contact.setPart("产品部");
    }

    @AfterAll
    static void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.quit();
    }
}
