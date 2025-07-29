import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = students.removeIf(student -> student.getRollNumber() == rollNumber);
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();

                    sc.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Name and Grade cannot be empty!");
                        break;
                    }

                    sms.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = sc.nextInt();
                    sms.removeStudent(rollToRemove);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    sms.searchStudent(rollToSearch);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting Student Management System.");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}