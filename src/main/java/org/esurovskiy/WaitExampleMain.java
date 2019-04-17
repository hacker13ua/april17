package org.esurovskiy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaitExampleMain {
    public static void main(String[] args) {
        MyTestData data = new MyTestData();
        System.out.println(data.ready());
        List<DataSender> senders =
                Arrays.asList(new DataSender(data),
                        new DataSender(data),
                        new DataSender(data));
        for (final DataSender sender : senders) {
            sender.start();
        }
        DataGenerator generator = new DataGenerator(data);
        generator.start();
    }
}
