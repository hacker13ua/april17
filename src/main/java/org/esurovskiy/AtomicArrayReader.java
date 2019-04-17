package org.esurovskiy;

import java.util.Random;

public class AtomicArrayReader extends Thread {
    private AtomicArray atomicArray;

    public AtomicArrayReader(final AtomicArray atomicArray) {
        this.atomicArray = atomicArray;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int index = new Random().nextInt(10);
        System.out.println("Read " + atomicArray.getString(index));
    }
}
