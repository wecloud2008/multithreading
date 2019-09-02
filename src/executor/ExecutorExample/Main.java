package executor.ExecutorExample;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Server  server = new Server();

        for(int i=0;i<100;i++){
            Task task = new Task("Task "+i);
            Thread.sleep(10);
            server.submitTask(task);
        }
        server.endServer();
    }
}
