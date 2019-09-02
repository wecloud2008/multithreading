package ThreadBasic2;
/**
 * main线程可以早于子线程提前结束
 *
 * */
public class ThreadDemo2 {
    public static void main(String args[])
    {
        new TestThread2().start();
    }
}

class TestThread2 extends Thread{
    public void run(){
        while(true){
            System.out.println("TestThread2 is running");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}
