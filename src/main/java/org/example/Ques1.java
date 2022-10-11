package org.example;

public class Ques1 {
    public static void main(String[] args) throws InterruptedException {
        //Create Thread using Thread Class

        Thread t1 = new ThreadClass();
        Thread t2 = new ThreadClass();
        Thread t3 = new ThreadClass();

        t1.start();

            for(int i=0;i<5;i++){
                t1.sleep(2000);
                System.out.println("The current thread name is: "+ Thread.currentThread().getName()+" "+i);
            }

            // invoking the join() method
            t1.join();

        // catch block for catching the raised exception

        t2.start();

            System.out.println("The current thread name is: "+ Thread.currentThread().getName());
            // invoking the join() method
            t2.join();

        t3.start();

        //Create Thread using Runnable
        new Thread(new ThreadClass2()).start();

        //Create Thread anonymous inner class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("here in anonymous class thread");
//            }
//        }).start();

        //Create Thread lambda
//        new Thread(() -> System.out.println("here in lambda thread")).start();


    }
}
class ThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Here inside thread class!");
    }
}

class ThreadClass2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Here inside runnable interface!");
    }
}
