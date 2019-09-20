package com.example.lambda;

import java.security.PrivateKey;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName JucTest
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/16 15:39
 */
public class JucTest {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        while (true){
            if (demo.isFlag()){
                System.out.println("---------------");
                break;
            }
        }
    }

}
class ThreadDemo implements Runnable{
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("数据为ok？" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
