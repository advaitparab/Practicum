import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductWriter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> products = new ArrayList<>();
            boolean addMore = true;

            while (addMore) {
                String id = SafeInput.getNonZeroLenString(scanner, "Enter Product ID:");
                String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name:");
                String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description:");
                double cost = SafeInput.getDouble(scanner, "Enter Product Cost:");

                products.add(String.format("%s, %s, %s, %.2f", id, name, description, cost));
                addMore = SafeInput.getYNConfirm(scanner, "Add another product? (Y/N)");
            }

            // Save products to a file
            try (FileWriter writer = new FileWriter("ProductTestData.txt")) {
                for (String product : products) {
                    writer.write(product + "\n");
                }
                System.out.println("Products saved to ProductTestData.txt");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }


