// Java program to illustrate suspend, resume and stop operation of thread.

class MyThread extends Thread {
    boolean suspended = false;
    boolean stopped = false;

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                while (suspended && !stopped) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                if (stopped) {
                    break;
                }
            }

            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    synchronized void suspendThread() {
        suspended = true;
    }

    synchronized void resumeThread() {
        suspended = false;
        notifyAll();
    }

    synchronized void stopThread() {
        stopped = true;
        suspended = false;
        notifyAll();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();

        t.start();

        Thread.sleep(1000);
        t.suspendThread();

        Thread.sleep(1000);
        t.resumeThread();

        Thread.sleep(1000);
        t.stopThread();
    }
}
