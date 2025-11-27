package Multithreading.virtualThread;

public class Main {

    public static void main(String[] args) {
        Thread vthread = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Virtual thread count : "+i);
                try { Thread.sleep(1000); } catch (InterruptedException _) {}
            }
        });

        System.out.println("Test.Main thread ends");

        // Wait for virtual thread to finish
        try {
            vthread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
