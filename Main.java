import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Выберите вариант работы программы:");
        System.out.println("1. Чтение из файла example.txt");
        System.out.println("2. Ввод пользователем слов для сортировки и последующее сохранение в result.txt");
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    String filePath = "example.txt";

                    List<String> lines = readFileLines(filePath);

                    List<String> sortedLines = sortLines(lines);

                    System.out.println("Результат после сортировки:");
                    for (String line : sortedLines) {
                        System.out.println(line);
                    }
                    scanner.close();
                    return;
                }
                case "2": {
                    List<String> lines = inputLines();

                    List<String> sortedLines = sortLines(lines);

                    storeResultToFile(sortedLines);
                    readFileLines("result.txt");

                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Неверный ввод.");
                }
            }
        }

    }

    private static void storeResultToFile(List<String> sortedLines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            for (String str : sortedLines) {
                writer.write(str);
                writer.newLine();
            }
            System.out.println("Результаты успешно сохранены в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static List<String> readFileLines(String filePath) {
        System.out.println("Прочитано из файла " + filePath + ":");
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return lines;
    }

    private static List<String> sortLines(List<String> list) {
        return list.stream()
                .sorted(String::compareTo)
                .toList();
    }

    private static List<String> inputLines() {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Введите строки для сортировки (введите 'exit' для завершения ввода):");

        // Ввод строк от пользователя
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) { // Завершаем ввод, если пользователь ввёл 'exit'
                break;
            }
            strings.add(input); // Добавляем введённую строку в список
        }
        scanner.close();
        return strings;
    }
}
