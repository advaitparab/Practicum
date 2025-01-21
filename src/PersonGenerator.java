import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class PersonGenerator {

        public static void main(String[] args) {
            ArrayList<String> personRecords = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            boolean morePersons = true;

            while (morePersons) {
                String id = SafeInput.getNonZeroLenString(scanner, "Enter ID:");
                String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name:");
                String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name:");
                String title = SafeInput.getNonZeroLenString(scanner, "Enter Title (Mr., Mrs., etc.):");
                int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth:");

                personRecords.add(String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth));
                morePersons = SafeInput.getYNConfirm(scanner, "Add another person? (Y/N)");
            }

            String fileName = SafeInput.getNonZeroLenString(scanner, "Enter file name to save data:");
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                for (String record : personRecords) {
                    fileWriter.write(record + "\n");
                }
                System.out.println("Data saved to " + fileName);
            } catch (IOException e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }
    }


