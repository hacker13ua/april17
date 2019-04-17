package org.esurovskiy;


import java.util.Arrays;

public class MyTestData {
    private volatile byte[] data;

    public void setData(final byte[] data) {
        this.data = data;
    }

    public boolean ready() {
        return data != null;
    }

    @Override
    public String toString() {
        return "MyTestData{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
