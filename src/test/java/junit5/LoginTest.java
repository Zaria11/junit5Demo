package junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoginTest {
    private static HashMap<String,Object> dataMap=new HashMap<String, Object>();

    @Test
    void loginTest(){
        dataMap.put("Login","登录成功");
    }

    @Nested
    class payTest{
        @Test
        void payTest(){
            if(null!=dataMap.get("buy")){
                System.out.println("正在支付，请等待");
            }else{
                System.out.println("你还没购买课程了，请先购买");
            }
        }
    }

    @Nested
    class BuyTest{

        @Test
        void buyTest(){
            if (dataMap.get("Login").equals("登录成功")){
                System.out.println("登录成功啦，可以购买东西了");
                dataMap.put("buy","购买了");
            }else{
                System.out.println("登录失败，重新登录吧");
            }
        }
    }
}
