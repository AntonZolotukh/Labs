# Лабораторная работа №4: Обработка исключений (Вариант 6 – CustomInputMismatchException)

## Задание 1: ArrayAverage.java

Программа вычисляет среднее арифметическое элементов массива.

- `NumberFormatException` обрабатывает случай, когда элемент не является числом.
- `ArrayIndexOutOfBoundsException` обрабатывает выход за границы массива.

## Задание 2: FileCopy.java

Программа копирует содержимое одного файла в другой.

- `FileNotFoundException` обрабатывает отсутствие файла.
- `IOException` обрабатывает ошибки ввода-вывода.
- Для автоматического закрытия файлов используется `try-with-resources`.

## Задание 3: CustomInputMismatchException.java, ExceptionLogger.java, CustomInputMismatchDemo.java

Программа с пользовательским исключением при нечисловом вводе.

- `CustomInputMismatchException` — собственный класс исключения.
- `ExceptionLogger` записывает информацию об ошибках в `exceptions.log` (временная метка, тип исключения, сообщение, стек вызовов).
- В `CustomInputMismatchDemo` проверяется ввод: если введено не число, выбрасывается `CustomInputMismatchException` и ошибка логируется.
- Запуск: `java CustomInputMismatchDemo`
