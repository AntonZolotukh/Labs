import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {

    private static final String LOG_FILE = "exceptions.log";

    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            writer.println("----- Exception Log Entry -----");
            writer.println("Timestamp: " + timestamp);
            writer.println("Exception Type: " + e.getClass().getName());
            writer.println("Message: " + e.getMessage());
            writer.print("StackTrace: ");
            e.printStackTrace(writer);
            writer.println("-------------------------------");
            writer.println();

            System.out.println("Информация об исключении записана в файл: " + LOG_FILE);

        } catch (IOException ioException) {
            System.err.println("КРИТИЧЕСКАЯ ОШИБКА: не удалось записать лог исключения в файл.");
            ioException.printStackTrace();
        }
    }
}
