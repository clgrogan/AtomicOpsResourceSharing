package concurrency.atomic.operations.nested;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();

        BusinessLogic t1 = new BusinessLogic(metrics);
        BusinessLogic t2 = new BusinessLogic(metrics);

        MetricsPrinter mp = new MetricsPrinter(metrics);

        t1.start();
        t2.start();
        mp.start();
    }

    private static class Metrics {
        private long count;
        private double average;

        public synchronized void addSample(long sample){
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }
    }

    public static class MetricsPrinter extends Thread{
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

                System.out.println("Current Average: " + metrics.getAverage());
            }
        }
    }

    public static class BusinessLogic extends Thread{
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics){
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

}
