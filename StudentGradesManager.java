import java.util.ArrayList;
import java.util.Scanner;

// Student class to hold name and grade
class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Input student names and grades
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade for " + name + ": ");
            double grade = sc.nextDouble();
            sc.nextLine(); // consume leftover newline
            students.add(new Student(name, grade));
        }

        // Calculations
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", bottomStudent = "";

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        // Output
        System.out.println("\n--- Student Grade Summary ---");
        for (Student s : students) {
            System.out.printf("%s: %.2f\n", s.name, s.grade);
        }

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.printf("Highest Score: %.2f (%s)\n", highest, topStudent);
        System.out.printf("Lowest Score: %.2f (%s)\n", lowest, bottomStudent);

        sc.close();
    }
}
