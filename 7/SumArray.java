public class SumArray {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[200_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int half = array.length / 2;

        SumThread t1 = new SumThread(array, 0, half);
        SumThread t2 = new SumThread(array, half, array.length);

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long total = t1.getSum() + t2.getSum();
        long endTime = System.currentTimeMillis();

        System.out.println("Sum: " + total);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}

class SumThread extends Thread {
    private final int[] array;
    private final int start, end;
    private long sum = 0;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
