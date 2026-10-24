// Write a program to create a Thread Class

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
}

public class Main{
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
