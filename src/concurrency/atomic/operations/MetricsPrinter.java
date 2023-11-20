package concurrency.atomic.operations;

public class MetricsPrinter extends Thread{
    private Metrics metrics;

    public MetricsPrinter(Metrics metrics){
        this.metrics = metrics;
    }

    @Override
    public void run(){
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Current Average: " + metrics.getAverage() +" Count: " + metrics.getCount());
        }
    }
}
