package ThreadDataShare;
/**
 * static 变量共享信息
 * */
public class ThreadDemo0 {
    public static void main(String args[]){
        new TestThread0().start();
        new TestThread0().start();
        new TestThread0().start();
        new TestThread0().start();
    }
}
class TestThread0 extends Thread{
    //private int tickets = 100;
    private static int tickets =100; //static变量是共享的，所有线程共享
    public void run(){
        while(true){
            if(tickets>0){
                System.out.println(Thread.currentThread().getName()+
                        " is selling ticket "+ tickets);
                tickets = tickets-1;
            }else{
                break;
            }
        }
    }
}
