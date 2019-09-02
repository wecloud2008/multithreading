package ForkJoinExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class SumTest {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //创建执行线程池
        ForkJoinPool pool = new ForkJoinPool();
        //ForkJoinPool pool = new ForkJoinPool(4);

        //创建任务
        SumTask task = new SumTask(1,1000000000);

        //提交任务
        ForkJoinTask<Long> result = pool.submit(task);

        //等待结果
        do {
            System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }while (!task.isDone());
        System.out.println(result.get().toString());
    }
}
