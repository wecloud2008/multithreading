package ThreadBasic2;
/**
 * 调用run方法来启动run方法，将会是串行运行
 * */
public class ThreadDemo0 {
    public static void main(String args[]) throws InterruptedException {
        new TestThread0().run();
        while (true){
            System.out.println("main thread is running");
            Thread.sleep(1000);
        }
    }
}

class TestThread0 extends Thread{
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
