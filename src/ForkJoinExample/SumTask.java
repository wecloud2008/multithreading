package ForkJoinExample;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private int start;
    private int end;

    public SumTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    public static final int threadhold = 5;

    @Override
    protected Long compute() {
        Long sum = 0L;

        //如果任务足够小，就直接执行
        boolean canCompute = (end-start)<=threadhold;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum = sum+i;
            }
        }else{
            int middle = (start+end)/2;
            SumTask subTask1 = new SumTask(start,middle);
            SumTask sumTask2 = new SumTask(middle+1,end);

            invokeAll(subTask1,sumTask2);

            Long sum1 = subTask1.join();
            Long sum2 = sumTask2.join();

            //结果合并
            sum = sum1+sum2;
        }
        return sum;
    }
}
