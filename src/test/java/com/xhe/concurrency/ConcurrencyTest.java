package com.xhe.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author xhe
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/12/31
 */
@Slf4j
public class ConcurrencyTest {

    //请求总和
    private static final int clientTotal = 5000;
    //并发执行线程数
    private static final int threadTotal = 200;

    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args)throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i= 0; i < clientTotal; i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count.get());
    }

    private static void add(){
        count.incrementAndGet();
    }
}
