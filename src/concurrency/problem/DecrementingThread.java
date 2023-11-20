package concurrency.problem;

public class DecrementingThread extends Thread{

    private InventoryCounter counter;
    public DecrementingThread(InventoryCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            counter.decrement();
        }
    }
}
