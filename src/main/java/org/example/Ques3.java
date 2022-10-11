package org.example;

public class Ques3 {
    private Integer integer = 10;
    private synchronized void increment() {
        this.integer++;
    }
    private synchronized void decrement() {
        this.integer--;
    }

    public static void main(String[] args) throws InterruptedException {
        Ques3 instanceMethodSynchronized = new Ques3();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                synchronized(lock) {
                    instanceMethodSynchronized.increment();
                }
            }
        }, "IncrementThread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                synchronized(lock) {
                    instanceMethodSynchronized.increment();
                }
            }
        }, "DecrementThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(10000);
        System.out.println(instanceMethodSynchronized.integer);
    }
}
