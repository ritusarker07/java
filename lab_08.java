// Thread Priority



class MyThread extends Thread{
    public void run(){
        System.out.println(getName() + " is running");
        System.err.println(getName() + " Priority is " + getPriority());
    }
}


public class Main{
    public static void main(String[] args){

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

    }
}
