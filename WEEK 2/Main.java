import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[5];
        int studentCount = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Input data for a student");
            System.out.println("2. Calculate and display the grade & student details");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    if (studentCount < 5) {
                        Student student = new Student("", "", 0, "", 0);
                        student.obtainDetails();
                        students[studentCount] = student;
                        studentCount++;
                    } else {
                        System.out.println("Maximum student limit reached!");
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println("\nStudent " + (i + 1) + " Details:");
                        students[i].displayDetails();
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
