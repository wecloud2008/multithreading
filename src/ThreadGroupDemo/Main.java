package ThreadGroupDemo;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]){
        //创建线程组 名称为Searcher (the name of the new thread group.)
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();

        //创建一个任务，10个线程完成
        Searcher searchTask = new Searcher(result);
        for(int i=0;i<10;i++){

            //Allocates a new Thread object.
            Thread thread = new Thread(threadGroup,searchTask);
            thread.start();
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("-------华丽丽分割线0---------------");

        //查看线程组信息
        System.out.printf("active 线程数量：%d\n",threadGroup.activeCount());
        System.out.printf("线程组信息明细\n");
        threadGroup.list();
        System.out.println("-------------华丽丽分割线1--------------------");

        //遍历线程组 输出状态价值值
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int i=0;i<threadGroup.activeCount();i++) {
            System.out.printf("THread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        System.out.println("-----------------华丽丽分割线2--------------");
        waitFinish(threadGroup);

        threadGroup.interrupt();

    }

    public static void waitFinish(ThreadGroup threadGroup){
        while (threadGroup.activeCount()>9){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
