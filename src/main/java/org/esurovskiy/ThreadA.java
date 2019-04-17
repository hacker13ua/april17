package org.esurovskiy;

public class ThreadA extends Thread {
    @Override
    public void run() {
        System.out.println("Thread A started");
        synchronized (DeadLockExample.obj1){
            System.out.println("Thread A lock obj1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread A wait obj2");
            synchronized (DeadLockExample.obj2){
                System.out.println("Thread A lock obj2");
            }
        }
        System.out.println("ThreadA finish");
    }
}
