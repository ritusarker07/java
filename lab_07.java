// yield(), stop() and sleep() method using thread.

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": " + i);

            try {
                if (i == 2) {
                    Thread.yield();
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();

        Thread.sleep(1200);

        t1.interrupt();

        System.out.println("Main thread finished waiting.");
    }
}
