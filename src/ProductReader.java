import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ProductReader {

        public static void main(String[] args) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select the Product Data File");

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("File selected: " + selectedFile.getAbsolutePath());

                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    System.out.printf("%-10s %-20s %-30s %-10s%n", "ID", "Name", "Description", "Cost");
                    System.out.println("===============================================================");

                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",\\s*");
                        if (parts.length == 4) {
                            System.out.printf("%-10s %-20s %-30s %-10s%n",
                                    parts[0], parts[1], parts[2], parts[3]);
                        } else {
                            System.out.println("Invalid record: " + line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("File selection canceled.");
            }
        }
    }


