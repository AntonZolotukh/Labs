import java.util.Random;

public class MaxInMatrix {
    public static void main(String[] args) throws InterruptedException {
        int rows = 10;
        int cols = 1000;
        int[][] matrix = new int[rows][cols];

        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10_000);
            }
        }

        MaxThread[] threads = new MaxThread[rows];
        for (int i = 0; i < rows; i++) {
            threads[i] = new MaxThread(matrix[i]);
            threads[i].start();
        }

        int globalMax = Integer.MIN_VALUE;
        for (MaxThread t : threads) {
            t.join();
            globalMax = Math.max(globalMax, t.getRowMax());
        }

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}

class MaxThread extends Thread {
    private final int[] row;
    private int rowMax;

    public MaxThread(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        rowMax = row[0];
        for (int val : row) {
            if (val > rowMax) rowMax = val;
        }
    }

    public int getRowMax() {
        return rowMax;
    }
}
