import java.io.*;
import java.util.*;

public class StudentRecordManagementSystem {
    private static final String FILE_NAME = "student_records.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add New Student Record");
            System.out.println("2. View All Student Records");
            System.out.println("3. Update Student Record");
            System.out.println("4. Delete Student Record");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    addStudentRecord(scanner);
                    break;
                case 2:
                    viewAllStudentRecords();
                    break;
                case 3:
                    updateStudentRecord(scanner);
                    break;
                case 4:
                    deleteStudentRecord(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new student record
    private static void addStudentRecord(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Student Roll Number: ");
            String rollNumber = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Grade: ");
            String grade = scanner.nextLine();

            if (isValidInput(rollNumber, name, grade)) {
                writer.write(rollNumber + "," + name + "," + grade);
                writer.newLine();
                System.out.println("Student record added successfully.");
            } else {
                System.out.println("Invalid input. Please provide valid roll number, name, and grade.");
            }
        } catch (IOException e) {
            System.out.println("Error while adding the student record: " + e.getMessage());
        }
    }

    // View all student records
    private static void viewAllStudentRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            System.out.println("\n--- Student Records ---");
            while ((record = reader.readLine()) != null) {
                String[] details = record.split(",");
                System.out.println("Roll Number: " + details[0] + ", Name: " + details[1] + ", Grade: " + details[2]);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the student records: " + e.getMessage());
        }
    }

    // Update a student record
    private static void updateStudentRecord(Scanner scanner) {
        List<String> records = new ArrayList<>();
        String rollNumberToUpdate;
        boolean found = false;

        System.out.print("Enter the Roll Number of the student to update: ");
        rollNumberToUpdate = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = reader.readLine()) != null) {
                String[] details = record.split(",");
                if (details[0].equals(rollNumberToUpdate)) {
                    System.out.println("Current Record: Roll Number: " + details[0] + ", Name: " + details[1] + ", Grade: " + details[2]);
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    records.add(details[0] + "," + newName + "," + newGrade);
                    found = true;
                } else {
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while updating the student record: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String rec : records) {
                    writer.write(rec);
                    writer.newLine();
                }
                System.out.println("Student record updated successfully.");
            } catch (IOException e) {
                System.out.println("Error while saving the updated records: " + e.getMessage());
            }
        } else {
            System.out.println("Student record not found.");
        }
    }

    // Delete a student record
    private static void deleteStudentRecord(Scanner scanner) {
        List<String> records = new ArrayList<>();
        String rollNumberToDelete;
        boolean found = false;

        System.out.print("Enter the Roll Number of the student to delete: ");
        rollNumberToDelete = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = reader.readLine()) != null) {
                String[] details = record.split(",");
                if (details[0].equals(rollNumberToDelete)) {
                    found = true;
                } else {
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while deleting the student record: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String rec : records) {
                    writer.write(rec);
                    writer.newLine();
                }
                System.out.println("Student record deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error while saving the updated records: " + e.getMessage());
            }
        } else {
            System.out.println("Student record not found.");
        }
    }

    // Validate input
    private static boolean isValidInput(String rollNumber, String name, String grade) {
        return rollNumber != null && !rollNumber.trim().isEmpty() &&
                name != null && !name.trim().isEmpty() &&
                grade != null && !grade.trim().isEmpty();
    }
}
