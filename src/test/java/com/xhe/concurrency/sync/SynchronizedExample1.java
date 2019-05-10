package com.xhe.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author xhe
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/12/31
 */
@Slf4j
public class SynchronizedExample1 {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for(int i=0; i <10; i++){
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(int j){
        for(int i=0; i <10; i++){
            log.info("test1 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example12 = new SynchronizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            example1.test2(1);
        });

        executorService.execute(() ->{
            example12.test2(2);
        });

        executorService.shutdown();
    }
}
