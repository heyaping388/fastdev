package com.xhe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Created By Xhe
 * Date: 2018/4/29
 * Time: 16:25
 * Desc: 单元测试基类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    @Test
    public void test(){
        System.out.println("测试...");
    }
}
