package com.example.lambda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockDemo
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/20 9:30
 */
public class LockDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();

    }
}

class Ticket implements Runnable {

    private int sum = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
//            lock.lock();
//            try {
            synchronized (this) {
                if (sum > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "当前电影票剩余 ：" + --sum);
                } else {
                    break;
                }

            }
//            }finally {
//                lock.unlock();
//            }


        }
    }
}
