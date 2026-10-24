
class MyThread extends Thread {
    public void run() {
        System.out.println("Child Thread Started");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
        }

        System.out.println("Child Thread Finished");
    }
}

public class MyThreads {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();

        System.out.println("Main Thread Started");
        t.start();
        t.join();

        System.out.println("Main Thread Finished");
    }
}
