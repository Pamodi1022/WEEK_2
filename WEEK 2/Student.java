import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    private String name;
    private String email;
    private int age;
    private String address;
    private int mark;

    public Student(String name, String email, int age, String address, int mark) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.mark = mark;
    }

    public void obtainDetails() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name: ");
            this.name = scanner.nextLine();
            if (this.name.matches("[a-zA-Z]")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid name (letters and spaces only).");
            }
        }

        System.out.print("Enter email: ");
        this.email = scanner.nextLine();

        while (true) {
            System.out.print("Enter age: ");
            try {
                this.age = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number for age.");
                scanner.next();
            }
        }

        System.out.print("Enter address: ");
        this.address = scanner.nextLine();

        while (true) {
            System.out.print("Enter mark: ");
            try {
                this.mark = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number for marks.");
                scanner.next();
            }
        }
    }

    public String calculateGrade() {
        if (this.mark >= 90) {
            return "A";
        } else if (this.mark >= 80) {
            return "B";
        } else if (this.mark >= 70) {
            return "C";
        } else if (this.mark >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Email: " + this.email);
        System.out.println("Student Age: " + this.age);
        System.out.println("Student Address: " + this.address);
        System.out.println("Student Grade: " + calculateGrade());
    }
}
