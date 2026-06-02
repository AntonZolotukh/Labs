import java.util.Scanner;

public class CustomInputMismatchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Пожалуйста, введите целое число: ");

        try {
            if (!scanner.hasNextInt()) {
                String invalidInput = scanner.next();
                throw new CustomInputMismatchException("Обнаружен некорректный ввод пользователя: '" + invalidInput + "'. Ожидалось целое число.");
            }
            
            int number = scanner.nextInt();
            System.out.println("Отлично! Вы ввели число: " + number);

        } catch (CustomInputMismatchException e) {
            System.err.println("ОШИБКА: " + e.getMessage());
            ExceptionLogger.logException(e);
            
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } finally {
            scanner.close();
            System.out.println("Сканер закрыт. Программа завершена.");
        }
    }
}
