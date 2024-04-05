import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Student> listOfStudent = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    Apublic static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("-----Student Management-----");
            System.out.println("---1. Enter student list");
            System.out.println("---2. Find students by last name");
            System.out.println("---3. Find and edit students by full name");
            System.out.println("---4. End of the application");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentsByFullName();
                    break;
                case 4:
                    running = false;
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Please re-enter numbers from 1 to 4!");
            }
        }
    }

    private static void enterStudentList() {
        System.out.print("Please enter the number of students: ");
        int numOfStu = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numOfStu; i++) {
            System.out.print("Please enter first name of student " + i + " : ");
            String firstName = scanner.nextLine();
            System.out.print("Please enter last name of student  " + i + " : ");
            String lastName = scanner.nextLine();
            listOfStudent.add(new Student(firstName, lastName));
        }
    }

    private static void findStudentsByLastName() {
        System.out.print("Please enter the last name you want to find: ");
        String lastName = scanner.next();
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : listOfStudent) {
            if (student.getLastName().equals(lastName)) {
                foundStudents.add(student);
            }
        }
        if (foundStudents.isEmpty()) {
            System.out.println("No student found with last name " + lastName);
        } else {
            System.out.println("Found students with last name " + lastName + ":");
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        }
    }

    private static void findAndEditStudentsByFullName() {
        System.out.print("Please enter first name to search: ");
        String firstName = scanner.next();
        System.out.print("Please enter last name to search: ");
        String lastName = scanner.next();
        Student foundStudent = null;
        for (Student student : listOfStudent) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                foundStudent = student;
                break;
            }
        }
        if (foundStudent != null) {
            System.out.println("Found student with full name " + firstName + " " + lastName + ":");
            System.out.println(foundStudent);
            System.out.print("Please enter new first name: ");
            foundStudent.setFirstName(scanner.next());
            System.out.print("Please enter new last name: ");
            foundStudent.setLastName(scanner.next());
            System.out.println("Updated successfully!");
        } else {
            System.out.println("No student found with full name " + firstName + " " + lastName);
        }
    }
}
