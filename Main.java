import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "example.txt";

        List<String> lines = readFileLines(filePath);

        List<String> sortedLines = lines.stream()
                .sorted(String::compareTo)
                .toList();
        for (String line : sortedLines) {
            System.out.println(line);
        }
    }

    private static List<String> readFileLines(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return lines;
    }
}
