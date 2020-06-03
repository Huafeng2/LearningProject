package com.zuo.springmvc.util;

import java.util.concurrent.atomic.AtomicLong;

public class Main extends Thread {
    private static AtomicLong count = new AtomicLong(0);

    @Override
    public void run() {
        super.run();
        count.incrementAndGet();
        System.out.println("count =" + count);
    }

    public static void main(String[] a){
        int number = 500;
        for (int i = 0; i < number; i++) {
            Thread t1 = new Main();
            t1.start();
        }
    }
}
