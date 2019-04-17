package org.esurovskiy;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    static Object o = new Object();

    ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        final Bank privatBank = new Bank();
        privatBank.changeBalance(new User());
        privatBank.changeBalance(new User());
    }

    void changeBalance(User user) {
        lock.lock();
        try{
            //
        }finally {
            lock.unlock();
        }
    }
}
