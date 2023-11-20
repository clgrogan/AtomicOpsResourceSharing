package concurrency.problem;

public class InventoryCounter {
    private int items = 0;

    public void increment(){
        items++;
    }

    public void decrement(){
        items--;
    }

    public int getCount(){
        return items;
    }

    public void resetCount(){
        items = 0;
    }
}
