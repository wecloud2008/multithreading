package ThreadMangement;

import java.util.Random;

/**
 * 生产者
 * */
public class Producer implements Runnable{
    private Storage storage;

    public Producer(Storage storage){
        this.storage = storage;
    }


    @Override
    public void run() {
        int i=0;
        Random r= new Random();

        //创建10个产品
        while(i<10){
            i++;
            Product product = new Product(i,"电话"+r.nextInt(100));
            storage.push(product);
        }
    }
}
