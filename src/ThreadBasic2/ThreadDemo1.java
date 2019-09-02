package ThreadBasic2;
/**
 * 调用start方法来启动run方法 将会是并行运行（多线程运行）
 * */
public class ThreadDemo1 {
    public static void main(String args[]) throws InterruptedException {
        new TestThread0().start();
        while (true){
            System.out.println("main thread is running");
            Thread.sleep(1000);
        }
    }
}

class TestThread1 extends Thread{
    public void run(){
        while (true){
            System.out.println("TestThread1 is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
