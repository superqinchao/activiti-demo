package com.example.lambda;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LcokAndProductorAndConsumer
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/20 10:27
 */
public class LcokAndProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor, "生产者A").start();
        new Thread(consumer, "消费者A").start();
        new Thread(productor, "生产者B").start();
        new Thread(consumer, "消费者B").start();
    }
}

class Clerk {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void get() {
        lock.lock();
        try {
            while (product >= 5) {
                System.out.println("产品已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}

class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            clerk.get();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            clerk.sale();
        }
    }
}