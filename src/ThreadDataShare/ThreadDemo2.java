package ThreadDataShare;

public class ThreadDemo2 {
    public static void main(String args[]) throws InterruptedException {
        TestThread2 t= new TestThread2();
        t.start();
        Thread.sleep(2000);
        t.flag=false;
        System.out.println("main thread is exiting");
    }
}

class TestThread2 extends Thread{
    //boolean flag = true;
    volatile boolean flag = true;

    public void run(){
        int i=0;
        while (flag){
            i++;
        }
        System.out.println("test thread3 is exiting");
    }
}
