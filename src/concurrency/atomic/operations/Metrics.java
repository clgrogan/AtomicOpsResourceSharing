package concurrency.atomic.operations;

public class Metrics {
    private long count;
    private volatile double average;

    public synchronized void addSample(long sample){
        double currentSum = average * count;
        count++;
        average = (currentSum + sample) / count;
    }

    public double getAverage() {
        return average;
    }

    public long getCount() {
        return count;
    }
}
