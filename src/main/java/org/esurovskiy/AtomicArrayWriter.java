package org.esurovskiy;

import java.util.Random;

public class AtomicArrayWriter extends Thread {

    private AtomicArray atomicArray;

    public AtomicArrayWriter(final AtomicArray atomicArray) {
        this.atomicArray = atomicArray;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() +  " Start write");
        final int index = new Random().nextInt(10);
        atomicArray.setString("" + index, index);
        System.out.println(getName() + " end write");

    }
}
