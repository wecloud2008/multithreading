package ThreadBasic2;

/**
 * 1.一个线程对象不能多次start 多次start将会报异常
 * 2.多个线程对象都start后 哪一个先执行 完全有jvm和操作系统来主导，程序员无法指定
 * */
public class ThreadDemo4 {
    public static void main(String args[]){
        TestThread4 t = new TestThread4();
        t.start();
        //t.start(); 不能多次启动start

        TestThread4 t1 = new TestThread4();
        t1.start();
    }
}


class TestThread4 extends  Thread{
    public void run(){
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
