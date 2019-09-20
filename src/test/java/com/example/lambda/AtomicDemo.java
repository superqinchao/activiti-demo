package com.example.lambda;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicDemo
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/19 14:39
 */
public class AtomicDemo {

    public static void main(String[] args) {
        AtomicThreadDemo atomicThreadDemo = new AtomicThreadDemo();
        for (int i = 0; i < 20 ;i++){
            new Thread(atomicThreadDemo).start();
        }
    }
}
class AtomicThreadDemo implements Runnable {
    private AtomicInteger number = new AtomicInteger(100);

    @Override
    public void run() {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(getNumber());
    }

    public int getNumber() {
        return number.getAndIncrement();
    }

    public void setNumber(AtomicInteger number) {
        this.number = number;
    }
}

