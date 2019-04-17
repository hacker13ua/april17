package org.esurovskiy;


public class DeadLockExample {
    public final static Object obj1 = new Object();
    public final static Object obj2 = new Object();

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}
