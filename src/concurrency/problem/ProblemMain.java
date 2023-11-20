package concurrency.problem;

public class ProblemMain {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter counter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(counter);
        DecrementingThread decrementingThread = new DecrementingThread(counter);

        incrementingThread.start();
        incrementingThread.join();
        decrementingThread.start();
        decrementingThread.join();

        System.out.println("\nSequential execution of incrementing and decrementing threads.");
        System.out.println("        incrementingThread.start();\n" +
                "        incrementingThread.join();\n" +
                "        decrementingThread.start();\n" +
                "        decrementingThread.join();");
        System.out.println("Expected Count: 0\nActual Count: "+counter.getCount());

        counter.resetCount();
        System.out.println("\ncounter.resetCount()\n");
        incrementingThread = new IncrementingThread(counter);
        decrementingThread = new DecrementingThread(counter);

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

        System.out.println("This is the concurrency problem.\nThis occurs when a shared resource has non-atomic operations executing on concurrently running threads.");

    }
}
