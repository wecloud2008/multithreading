package ThreadBasic2;

/**
 * 继承Thread创建多线程
 * */
public class Thread1 extends Thread{
    public void run(){
        System.out.println("hello");
    }

    public static void main(String args[]){
        new Thread1().start();
    }
}
