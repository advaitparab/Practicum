import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                System.out.printf("%-10s %-10s %-10s %-10s %-4s%n", "ID", "FirstName", "LastName", "Title", "YOB");
                System.out.println("==========================================");
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    System.out.printf("%-10s %-10s %-10s %-10s %-4s%n", parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

    }
}
