package ThreadMangement;

public class Consumer implements Runnable {
    private Storage storage;

   public  Consumer(Storage storage){
        this.storage = storage;
    }

    /**
     * 消耗产品
     * */
    @Override
    public void run() {
        int i=0;
        while (i<10){
            i++;
            storage.pop(); //拿出产品
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
