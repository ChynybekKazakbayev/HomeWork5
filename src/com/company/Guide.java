package com.company;


import java.util.concurrent.CountDownLatch;

public class Guide extends Thread {
    private CountDownLatch LATCH;
    private int personNumber;

    public Guide(int personNumber, CountDownLatch LATCH) {
        this.personNumber = personNumber;
        this.LATCH = LATCH;
    }

    public void run() {
        try {
            System.out.printf("Человек %d собрался\n", personNumber);
            // Уменьшаем счетчик на 1
            LATCH.countDown();
            LATCH.await();
        } catch (InterruptedException e) {
        }
    }
}