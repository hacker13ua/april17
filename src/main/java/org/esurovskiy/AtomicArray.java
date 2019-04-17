package org.esurovskiy;


import java.util.concurrent.Semaphore;

public class AtomicArray {
    Semaphore semaphore = new Semaphore(100);
    private String[] array = new String[10];

    public void setString(String s, int  index)  {
        try {
            System.out.println("Write available before acquire " + semaphore.availablePermits());
            semaphore.acquire(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            array[index] = s;
        } finally {
            semaphore.release(100);
            System.out.println("Write available after acquire " + semaphore.availablePermits());

        }
    }

    public String getString(int index)  {
        try {
            semaphore.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Read available " + semaphore.availablePermits());
            return array[index];
        }finally {
            semaphore.release(1);
        }
    }
}
