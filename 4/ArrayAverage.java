public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i].trim());
                sum += num;
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: выход за границы массива.");
            System.err.println("Сообщение исключения: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: элемент не является числом.");
            System.err.println("Сообщение исключения: " + e.getMessage());
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } else {
            System.out.println("Нет данных для вычисления.");
        }
    }
}
