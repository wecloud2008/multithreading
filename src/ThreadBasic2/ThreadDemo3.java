package ThreadBasic2;

/**
 *实现Runnable的类 必须使用Thread包装才可以使用start开始多线程
 * */
public class ThreadDemo3 {
    public static void main(String args[]){
        TestThread3 tt = new TestThread3();
        Thread t = new Thread(tt);
        t.start();

        while(true){
            System.out.println("main thread is running");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class TestThread3 implements Runnable{

    @Override
    public void run() {

        while(true) {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
