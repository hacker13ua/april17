package org.esurovskiy;

/**
 * TODO: write javadoc
 *
 * @author Evgeniy Surovskiy
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("Thread B started");
        synchronized (DeadLockExample.obj2){
            System.out.println("Thread B lock obj2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread B wait obj1");
            synchronized (DeadLockExample.obj1){
                System.out.println("Thread B lock obj1");
            }
        }
        System.out.println("ThreadB finish");
    }
}
