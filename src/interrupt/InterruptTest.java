package interrupt;
/**
 * 主动和被动管理线程
 * */
public class InterruptTest {
    public static void main(String args[]) throws InterruptedException {
        TestThread1 t1= new TestThread1();
        TestThread2 t2 = new TestThread2();

        t1.start();
        t2.start();

        Thread.sleep(2000);
        t1.interrupt();
        t2.flag=false;
        System.out.println("main thread is running");
    }
}

class TestThread1 extends Thread{
    public void run(){
        /**
         * interrupted()是Thread类的方法 用来测试当前线程是否收到一个INTERRUPT的信号，如果收到，该方便
         * 返回true 否额返回false
         * */
        while(!interrupted()){
            System.out.println("test thread1 is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
        System.out.println("test thread1 is exiting");
    }
}

class TestThread2 extends Thread{
    public volatile boolean flag = true;
    public void run(){
        while(flag){
            System.out.println("test thread2 is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("test thread2 is exiting");
    }
}
