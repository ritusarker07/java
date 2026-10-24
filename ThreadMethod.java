class MyThread extends Thread {
    boolean suspend = false, stop = false;

    public void run() {
        while (!stop) {
            synchronized (this) {
                while (suspend) {
                    try { wait(); } catch (Exception e) {}
                }
            }
            System.out.println("Thread is running...");
            try { sleep(1000); } catch (Exception e) {}
        }
    }

    synchronized void suspendThread() { suspend = true; }

    synchronized void resumeThread() {
        suspend = false;
        notify();
    }

    synchronized void stopThread() {
        stop = true;
        resumeThread();
    }
}

public class ThreadMethod {
    public static void main(String[] args) throws Exception {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(2000);
        t.suspendThread();
        Thread.sleep(2000);
        t.resumeThread();
        Thread.sleep(2000);
        t.stopThread();
    }
}