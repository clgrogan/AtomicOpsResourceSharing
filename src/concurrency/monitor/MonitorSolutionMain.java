package concurrency.monitor;

public class MonitorSolutionMain {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter counter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(counter);
        DecrementingThread decrementingThread = new DecrementingThread(counter);

        incrementingThread.start();
        decrementingThread.start();
        incrementingThread.join();
        decrementingThread.join();

        System.out.println("\nConcurrent execution of incrementing and decrementing threads.");
        System.out.println("        incrementingThread.start();\n" +
                "        incrementingThread.join();\n" +
                "        decrementingThread.start();\n" +
                "        decrementingThread.join();");
        System.out.println("Expected Count: 0\nActual Count: "+counter.getCount());

        System.out.println();

        System.out.println("Adding the synchronized modifier to the critical methods resolves the concurrency problem.");

    }
}
