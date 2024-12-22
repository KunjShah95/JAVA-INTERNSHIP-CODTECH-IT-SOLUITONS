# Student Grade Tracker

This project is a simple Java application to track student grades, calculate GPA, and provide a summary of academic performance.

## Features

- Add or update grades for individual subjects.
- Add multiple grades at once.
- Remove grades for specific subjects.
- Display all recorded grades.
- Display a summary of the student's academic performance, including average grade, GPA, and overall letter grade.
- Save grades to a file and load them on startup.
- **New Feature**: Calculate and display the highest and lowest grades.
- **New Feature**: Display grades sorted by subject name or grade.
- **New Feature**: Export grades and summary to a CSV file.
- **New Feature**: Import grades from a CSV file.
- **New Feature**: Generate a detailed report card in PDF format.

## Usage

1. **Add/Update Grade**: Enter the subject name and the grade (0-100).
2. **Add Multiple Grades**: Enter the number of subjects, then enter the subject names and grades.
3. **Remove Grade**: Enter the subject name to remove the grade.
4. **Display Grades**: View all recorded grades.
5. **Display Student Summary**: View the average grade, GPA, and overall letter grade.
6. **Save and Exit**: Save the grades to a file and exit the program.
7. **Calculate Highest/Lowest Grade**: View the highest and lowest grades.
8. **Sort Grades**: Sort grades by subject name or grade.
9. **Export to CSV**: Export grades and summary to a CSV file.
10. **Import from CSV**: Import grades from a CSV file.
11. **Generate Report Card**: Generate a detailed report card in PDF format.

## How to Use

1. **Clone the Repository**: Clone the repository to your local machine using `git clone <repository-url>`.
2. **Navigate to the Project Directory**: Open a terminal and navigate to the project directory.
3. **Compile the Application**: Compile the Java application using `javac Main.java`.
4. **Run the Application**: Run the application using `java Main`.
5. **Follow the On-Screen Instructions**: Follow the on-screen instructions to add, update, remove, display, and save grades.

## Sample Output

```
Enter student name: John Doe

Student Grade Tracker Menu:
1. Add/Update Grade
2. Add Multiple Grades
3. Remove Grade
4. Display Grades
5. Display Student Summary
6. Save and Exit
7. Calculate Highest/Lowest Grade
8. Sort Grades
9. Export to CSV
10. Import from CSV
11. Generate Report Card
Choose an option: 1
Enter subject name: Math
Enter grade (0-100): 95
Grade added/updated for subject: Math

Student Grade Tracker Menu:
1. Add/Update Grade
2. Add Multiple Grades
3. Remove Grade
4. Display Grades
5. Display Student Summary
6. Save and Exit
7. Calculate Highest/Lowest Grade
8. Sort Grades
9. Export to CSV
10. Import from CSV
11. Generate Report Card
Choose an option: 5

--- Student Academic Summary ---
Student Name: John Doe
Average Grade: 95.00
GPA: 4.00
Overall Letter Grade: A
--------------------------------
```

## Additional Information

- **Dependencies**: Ensure you have Java installed on your machine.
- **File Storage**: Grades are saved to a file named `grades.txt` in the project directory.
- **CSV Export**: The CSV file is named `grades_summary.csv` and is saved in the project directory.
- **CSV Import**: The CSV file should be named `grades_import.csv` and placed in the project directory.
- **PDF Report Card**: The PDF report card is named `report_card.pdf` and is saved in the project directory.
- **Error Handling**: The application includes basic error handling for invalid inputs.
- **Logging**: The application logs important events and errors to a file named `app.log` in the project directory.
- **Configuration**: Configuration settings can be adjusted in the `config.properties` file.

## Contributing

If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
