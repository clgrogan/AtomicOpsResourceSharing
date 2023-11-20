package stack;

public class StackMemoryApp {
    /*
        Application used to demonstrate how the stack memory is handled in general and
        with multiple threads.
        Will be using debugging to view the application memory usage information
    */

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int result = sum(x,y);
    }

    private static int sum(int a, int b) {
        int result = a + b;
        return result;
    }

}
