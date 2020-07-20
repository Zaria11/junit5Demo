package junit5;


import org.junit.jupiter.api.*;

public class Junit5DemoTest {
    @BeforeAll
    public static void before(){
        System.out.println("before");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @Test
    void fun1(){
        System.out.println("fun1");
    }

    @Test
    void fun2(){
        System.out.println("fun2");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @AfterAll
    public static void after(){
        System.out.println("after");
    }
}
