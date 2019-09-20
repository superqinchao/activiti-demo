package com.example.lambda;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestABCDemo
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/20 18:15
 */
public class TestABCDemo {
    public static void main(String[] args) {
        TestADB testADB = new TestADB();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                testADB.threadA(i);
            }
        }, "A").start();

        new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    testADB.threadB(i);
                }
        }, "B").start();
        new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    testADB.threadC(i);
                }
        }, "C").start();
    }
}

class TestADB {
    private int i = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void threadA(int totleNum) {
        lock.lock();
        try {
            if (i != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " :" + totleNum);
            i = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void threadB(int totleNum) {
        lock.lock();
        try {
            if (i != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " :" + totleNum);
            i = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void threadC(int totleNum) {
        lock.lock();
        try {
            if (i != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " :" + totleNum);
            i = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }

    }
}
