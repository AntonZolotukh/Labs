import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл успешно скопирован из '" + sourceFile + "' в '" + destFile + "'.");

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: один из файлов не найден.");
            System.err.println("Подробности: " + e.getMessage());
            if (!new File(sourceFile).exists()) {
                System.err.println("Проверьте наличие исходного файла: " + sourceFile);
            }

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при чтении или записи файла.");
            System.err.println("Сообщение исключения: " + e.getMessage());
            if (e instanceof FileNotFoundException) {
            } else {
                System.err.println("Возможно, проблемы с правами доступа или диск переполнен.");
            }
        }
    }
}
