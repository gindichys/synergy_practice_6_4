import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "example.txt";

        List<String> lines = readFileLines(filePath);

        List<String> sortedLines = sortLines(lines);

        System.out.println("Результат после сортировки:");
        for (String line : sortedLines) {
            System.out.println(line);
        }
    }

    private static List<String> readFileLines(String filePath) {
        System.out.println("Прочитано из файла:");
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
}
