package ThreadBasic2;

/**
 * 实现Runnable接口创建多线程，start的时候也需要依赖Thread才可以启动
 * */
public class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String args[]){
        new Thread(new Thread2()).start();
    }
}
