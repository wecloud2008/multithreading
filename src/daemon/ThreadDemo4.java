package daemon;

/**
 *
 * 守护线程是跟着main函数是心连心的，main结束了，守护线程也结束了。
 * 另外守护线程不要访问资源：文件或者数据库等，
 * */
public class ThreadDemo4 {
    public static void main(String args[]) throws InterruptedException {
        TestThread4 t = new TestThread4();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
        System.out.println("main thread is exiting");
    }
}

class TestThread4 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("TestThread4 is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
