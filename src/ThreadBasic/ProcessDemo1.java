package ThreadBasic;

/**
 * 多进程演示 启动允许两次该程序即可，
 * */
public class ProcessDemo1 {
    public static void main(String args[])
    {
        while(true){
            int a = (int)(Math.random()*100);//获取一个0-100的随机数
            System.out.println("main thread is running");
            try {
                Thread.sleep(5000); //休眠5000 毫秒 也就是5秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
