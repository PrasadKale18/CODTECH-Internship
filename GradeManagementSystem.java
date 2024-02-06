import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int[] subjectMarks;

    public Student(String name, int rollNumber, int[] subjectMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = subjectMarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setSubjectMarks(int[] subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    
    public int getRollNumber() {
        return rollNumber;
    }

    public double calculatePercentage() {
        int totalMarks = 0;
        for (int mark : subjectMarks) {
            totalMarks += mark;
        }
        return (double) totalMarks / subjectMarks.length;
    }


    public char calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }


    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Subject Marks: " + arrayToString(subjectMarks));
        System.out.println("Overall Percentage: " + calculatePercentage() + "%");
        System.out.println("Grade: " + calculateGrade());
        System.out.println();
    }


    private String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}

public class GradeManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] subjectMarks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();
        }

        Student newStudent = new Student(name, rollNumber, subjectMarks);
        studentList.add(newStudent);

        System.out.println("Student added successfully.\n");
    }

    private static void updateStudent() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the roll number of the student to update: ");
        int rollNumber = scanner.nextInt();
    
        int index = findStudentIndex(rollNumber);
    
        if (index != -1) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
    
            int[] subjectMarks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter new marks for subject " + (i + 1) + ": ");
                subjectMarks[i] = scanner.nextInt();
            }
    
            Student studentToUpdate = studentList.get(index);
            studentToUpdate.displayStudentInfo(); 
    
        
            studentToUpdate.setRollNumber(rollNumber);
            studentToUpdate.setSubjectMarks(subjectMarks);
    
            System.out.println("Student information updated successfully.\n");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.\n");
        }
    }
    

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();

        int index = findStudentIndex(rollNumber);

        if (index != -1) {
            studentList.remove(index);
            System.out.println("Student deleted successfully.\n");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.\n");
        }
    }

    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.\n");
        } else {
            for (Student student : studentList) {
                student.displayStudentInfo();
            }
        }
    }

    private static int findStudentIndex(int rollNumber) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNumber() == rollNumber) {
                return i;
            }
        }
        return -1;
    }
}
