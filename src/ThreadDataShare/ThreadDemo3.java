package ThreadDataShare;

public class ThreadDemo3 {
    public static void main(String args[]){
        TestThread3 t = new TestThread3();
        new Thread(t,"Thread-0").start();
        new Thread(t,"Thread-1").start();
        new Thread(t,"Thread-2").start();
        new Thread(t,"Thread-3").start();

    }
}
class TestThread3 implements Runnable{
    private volatile int tickets = 100; //多个线程在共享的
    String lock = new String("");
    @Override
    public void run() {
        while(true){
            synchronized (lock){//同步代码块
                sale();
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            if(tickets<=0){ //没有票了直接跳出程序
                break;
            }
        }
    }

    /**
     * 如果票大于0，开始销售 并且减1
     * */
    public synchronized void sale(){//同步函数
        if(tickets>0){
            System.out.println(Thread.currentThread().getName()+" is selling ticket " + tickets--);
        }
    }
}
