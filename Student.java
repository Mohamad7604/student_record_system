import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private Map<String, Double> grades;
    private int attendance;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new HashMap<>();
        this.attendance = 0;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    public void markAttendance() {
        attendance++;
    }

    public int getAttendance() {
        return attendance;
    }

    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber +
                "\nGrades: " + grades + "\nAttendance: " + attendance + " days";
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nStudent Record System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(studentList, scanner);
                    break;
                case 2:
                    addGrade(studentList, scanner);
                    break;
                case 3:
                    markAttendance(studentList, scanner);
                    break;
                case 4:
                    displayStudentDetails(studentList, scanner);
                    break;
                case 5:
                    System.out.println("Exiting Student Record System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    private static void addStudent(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        Student student = new Student(name, rollNumber);
        studentList.add(student);

        System.out.println("Student added successfully!");
    }

    private static void addGrade(ArrayList<Student> studentList, Scanner scanner) {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system. Please add a student first.");
            return;
        }

        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        Student student = findStudentByRollNumber(studentList, rollNumber);

        if (student != null) {
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();

            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();

            student.addGrade(subject, grade);
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    private static void markAttendance(ArrayList<Student> studentList, Scanner scanner) {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system. Please add a student first.");
            return;
        }

        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        Student student = findStudentByRollNumber(studentList, rollNumber);

        if (student != null) {
            student.markAttendance();
            System.out.println("Attendance marked successfully!");
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    private static void displayStudentDetails(ArrayList<Student> studentList, Scanner scanner) {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system. Please add a student first.");
            return;
        }

        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        Student student = findStudentByRollNumber(studentList, rollNumber);

        if (student != null) {
            System.out.println("\nStudent Details:");
            System.out.println(student.toString());
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    private static Student findStudentByRollNumber(ArrayList<Student> studentList, String rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }
}
