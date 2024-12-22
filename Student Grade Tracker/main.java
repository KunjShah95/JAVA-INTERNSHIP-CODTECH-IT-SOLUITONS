
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class main {

    private static final String FILE_NAME = "grades.txt";
    private static final String CSV_FILE_NAME = "grades_summary.csv";

    // GPA Scale Mapping
    public static double getGpaFromLetter(String letterGrade) {
        return switch (letterGrade) {
            case "A" ->
                4.0;
            case "B" ->
                3.0;
            case "C" ->
                2.0;
            case "D" ->
                1.0;
            default ->
                0.0; // F
        };
    }

    // Function to calculate average grade
    public static double calculateAverage(HashMap<String, Double> grades) {
        double total = 0.0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return !grades.isEmpty() ? total / grades.size() : 0.0;
    }

    // Function to determine letter grade
    public static String determineLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Function to calculate GPA
    public static double calculateGpa(HashMap<String, Double> grades) {
        double totalGpa = 0.0;
        for (double grade : grades.values()) {
            String letterGrade = determineLetterGrade(grade);
            totalGpa += getGpaFromLetter(letterGrade);
        }
        return !grades.isEmpty() ? totalGpa / grades.size() : 0.0;
    }

    // Function to save grades to file
    public static void saveGradesToFile(String studentName, HashMap<String, Double> grades) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Student Name:" + studentName);
            writer.newLine();
            for (String subject : grades.keySet()) {
                writer.write(subject + ":" + grades.get(subject));
                writer.newLine();
            }
        }
    }

    // Function to load grades from file
    public static HashMap<String, Double> loadGradesFromFile() throws IOException {
        HashMap<String, Double> grades = new HashMap<>();
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Student Name:")) {
                        continue; // Skip student name line
                    }
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        grades.put(parts[0], Double.valueOf(parts[1]));
                    }
                }
            }
        }
        return grades;
    }

    // Function to export grades and summary to CSV
    public static void exportToCsv(String studentName, HashMap<String, Double> grades) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_NAME))) {
            writer.write("Student Name," + studentName);
            writer.newLine();
            writer.write("Subject,Grade");
            writer.newLine();
            for (String subject : grades.keySet()) {
                writer.write(subject + "," + grades.get(subject));
                writer.newLine();
            }
            double average = calculateAverage(grades);
            String letterGrade = determineLetterGrade(average);
            double gpa = calculateGpa(grades);
            writer.newLine();
            writer.write("Average Grade," + average);
            writer.newLine();
            writer.write("GPA," + gpa);
            writer.newLine();
            writer.write("Overall Letter Grade," + letterGrade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> grades;
        String studentName;

        // Load grades from file
        try {
            grades = loadGradesFromFile();
            System.out.println("Grades loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading grades: " + e.getMessage());
            grades = new HashMap<>();
        }

        System.out.print("Enter student name: ");
        studentName = scanner.nextLine();

        while (true) {
            System.out.println("\nStudent Grade Tracker Menu:");
            System.out.println("1. Add/Update Grade");
            System.out.println("2. Add Multiple Grades");
            System.out.println("3. Remove Grade");
            System.out.println("4. Display Grades");
            System.out.println("5. Display Student Summary");
            System.out.println("6. Save and Exit");
            System.out.println("7. Export to CSV");
            System.out.println("8. Search for a Specific Grade");
            System.out.println("9. Update Student Name");
            System.out.println("10. Clear All Grades");
            System.out.println("11. Load Grades for a Specific Student");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Add or Update Grade
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter grade (0-100): ");
                    double grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    } else {
                        grades.put(subject, grade);
                        System.out.println("Grade added/updated for subject: " + subject);
                    }
                }

                case 2 -> {
                    // Add Multiple Grades
                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter subject name: ");
                        String subject = scanner.nextLine();
                        System.out.print("Enter grade (0-100): ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (grade < 0 || grade > 100) {
                            System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                        } else {
                            grades.put(subject, grade);
                            System.out.println("Grade added/updated for subject: " + subject);
                        }
                    }
                }

                case 3 -> {
                    // Remove Grade
                    System.out.print("Enter subject name to remove: ");
                    String subject = scanner.nextLine();
                    if (grades.containsKey(subject)) {
                        grades.remove(subject);
                        System.out.println("Grade removed for subject: " + subject);
                    } else {
                        System.out.println("Subject not found.");
                    }
                }

                case 4 -> {
                    // Display Grades
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded yet.");
                    } else {
                        System.out.println("Grades:");
                        for (String sub : grades.keySet()) {
                            System.out.println(sub + ": " + grades.get(sub));
                        }
                    }
                }

                case 5 -> {
                    // Display Student Summary
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded yet.");
                    } else {
                        double average = calculateAverage(grades);
                        String letterGrade = determineLetterGrade(average);
                        double gpa = calculateGpa(grades);

                        System.out.println("\n--- Student Academic Summary ---");
                        System.out.println("Student Name: " + studentName);
                        System.out.printf("Average Grade: %.2f%n", average);
                        System.out.printf("GPA: %.2f%n", gpa);
                        System.out.println("Overall Letter Grade: " + letterGrade);
                        System.out.println("--------------------------------");
                    }
                }

                case 6 -> {
                    // Save and Exit
                    try {
                        saveGradesToFile(studentName, grades);
                        System.out.println("Grades saved to file. Exiting program.");
                    } catch (IOException e) {
                        System.out.println("Error saving grades: " + e.getMessage());
                    }
                    scanner.close();
                    return;
                }

                case 7 -> {
                    // Export to CSV
                    try {
                        exportToCsv(studentName, grades);
                        System.out.println("Grades and summary exported to CSV file.");
                    } catch (IOException e) {
                        System.out.println("Error exporting to CSV: " + e.getMessage());
                    }
                }

                case 8 -> {
                    // Search for a Specific Grade
                    System.out.print("Enter subject name to search: ");
                    String subject = scanner.nextLine();
                    if (grades.containsKey(subject)) {
                        System.out.println(subject + ": " + grades.get(subject));
                    } else {
                        System.out.println("Subject not found.");
                    }
                }

                case 9 -> {
                    // Update Student Name
                    System.out.print("Enter new student name: ");
                    studentName = scanner.nextLine();
                    System.out.println("Student name updated to: " + studentName);
                }

                case 10 -> {
                    // Clear All Grades
                    grades.clear();
                    System.out.println("All grades cleared.");
                }

                case 11 -> {
                    // Load Grades for a Specific Student
                    System.out.print("Enter student name to load grades: ");
                    String nameToLoad = scanner.nextLine();
                    try {
                        grades = loadGradesFromFile();
                        studentName = nameToLoad;
                        System.out.println("Grades loaded for student: " + studentName);
                    } catch (IOException e) {
                        System.out.println("Error loading grades: " + e.getMessage());
                    }
                }

                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
