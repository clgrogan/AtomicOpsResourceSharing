package concurrency.monitor;

public class IncrementingThread extends Thread{

    private InventoryCounter counter;
    public IncrementingThread(InventoryCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
