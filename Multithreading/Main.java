package Multithreading;

public class Main {

    static void main() {

        Thread thread =  new Thread(){


            @Override
            public void run() {
                for (int i = 1; i <=10 ; i++) {
                    System.out.println("thread is running count : "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();

        // Main thread can also do something
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: Count " + i);
            try {
                Thread.sleep(700); // Slightly longer pause
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
