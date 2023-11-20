package concurrency.monitor;

public class InventoryCounter {
    private int items = 0;

    public synchronized void increment(){
        items++;
    }

    public synchronized void decrement(){
        items--;
    }

    public synchronized int getCount(){
        return items;
    }
}
