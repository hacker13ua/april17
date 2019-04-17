package org.esurovskiy;


public class DataSender extends Thread {
    private MyTestData myTestData;

    public DataSender(final MyTestData myTestData) {
        this.myTestData = myTestData;
    }

    @Override
    public void run() {
        synchronized (myTestData) {
            System.out.println("Thread " + getName() + " started");
            while (!myTestData.ready()) {
                try {
                    System.out.println("Thread " + getName() + " wait");
                    myTestData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread " + getName()
                    + " data = " + myTestData);
        }
    }
}
