package com.example.lambda;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/19 15:15
 */
public class CASDemo {

    public static void main(String[] args) {
        CASDemoTest com = new CASDemoTest();
        for (int i = 0 ;i < 10 ;i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   int expecteValue = com.get();
                   boolean b = com.compareAndSet(expecteValue, (int) (Math.random() * 101));
                   System.out.println(b);
               }
           }).start();
        }
    }
}

class CASDemoTest{
    //内存值
    private int value;

    //获取内存值
    public synchronized int get(){
        return value;
    }
    //比较值
    public synchronized int CASDemoTest(int expecteValue,int newValue){
        int oldValue = value;
        if (oldValue == expecteValue){
            this.value = newValue;
        }
        return oldValue;
    }
    //设置值
    public synchronized boolean compareAndSet(int expecteValue,int newValue){
        return expecteValue == CASDemoTest(expecteValue,newValue);
    }
}
