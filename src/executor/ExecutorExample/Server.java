package executor.ExecutorExample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server(){
        executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        //executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    /**
     * 向线程池提交任务
     * */
    public void submitTask(Task task){
        System.out.printf("Server: A new task has arrived \n");
        executor.execute(task); // 执行 无返回值

        System.out.printf("Server: Pool size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d \n",executor.getActiveCount());
        System.out.printf("Server: Complated Tasks: %d \n",executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
}
