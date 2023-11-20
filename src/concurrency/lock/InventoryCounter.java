package concurrency.lock;

public class InventoryCounter {
    private Object lockObject = new Object();
    private int items = 0;

    public void increment(){
        synchronized (lockObject) {
            items++;
        }
    }

    public void decrement(){
        synchronized (lockObject) {
            items--;
        }
    }

    public int getCount(){
        return items;
    }
}
