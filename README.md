Marks Management System
Project Overview

This project is a console-based Marks Management System developed using Java File Handling concepts.
The system manages student details and student marks using text files without using any database or GUI.
It allows users to perform student operations and marks operations through a menu-driven console application.

The assignment requires using separate files to store student information and marks information, and to calculate totals and grades when displaying marks.

Objectives

The main objectives of this project are:

Manage student records using file handling
Manage student marks using file handling
Practice Java concepts learned from Lesson 01 to Lesson 05
Implement a menu-driven console application
Store deleted student and marks records in separate files instead of removing them permanently
Calculate total marks and grades for each student when displaying marks

These requirements are directly described in the practical sheet.

System Requirements

The system should support the following main functions:

1. Student Operations
Add a Student
View a Student
Update a Student
Delete a Student
Return to Main Menu
Exit
2. Marks Operations
Add Marks
Display All Student Marks
Display Individual Student Marks
Return to Main Menu
Exit

The practical sheet clearly specifies both menus and their options.

Files Used in the System

This project uses the following text files:

1. StudentData.txt

Stores active student details:

Registration Number
Name
Date of Birth
Email
Contact Number
2. MarksData.txt

Stores marks of students:

Registration Number
Quiz 01
Quiz 02
Quiz 03
Mid Semester Exam Marks
End Semester Exam Marks
3. DeletedStudentData.txt

Stores deleted student records instead of removing them permanently.

4. DeletedMarksData.txt

Stores deleted marks records instead of removing them permanently.

These file requirements are given in the assignment document.

Main Menu Structure

When the program starts, the following main menu is displayed:

---Main Menu---
1. Student Operations
2. Marks Operations
0. Exit

The menu should continue displaying until the user enters 0 to exit the program.

Student Operations

When the user selects Student Operations, the following menu is displayed:

---Student Operations---
1. Add a Student
2. View a Student
3. Update a Student
4. Delete a Student
5. Main Menu
0. Exit
Add a Student

The system accepts all student details from the user and saves them into StudentData.txt.

View a Student

The system asks for a registration number and displays all details related to that student.

Update a Student

The system asks for a registration number and allows updating:

Name
Date of Birth
Contact Number

Update submenu:

---Student Update---
1. Update Name
2. Update DoB
3. Update Contact No
4. Student Operations
5. Main Menu
0. Exit
Delete a Student

When deleting a student:

The student record is removed from StudentData.txt
The deleted student record is stored in DeletedStudentData.txt
The related marks are removed from MarksData.txt
The deleted marks are stored in DeletedMarksData.txt

These operations are explicitly listed in the practical sheet.

Marks Operations

When the user selects Marks Operations, the following menu is displayed:

---Marks Operations---
1. Add Marks
2. Display All Student Marks
3. Display Individual Student Marks
4. Main Menu
0. Exit
Add Marks

The user enters:

Registration Number
Quiz 1 marks
Quiz 2 marks
Quiz 3 marks
Mid marks
End marks

Before adding marks, the system checks whether the student exists in StudentData.txt.

Display All Student Marks

The system displays all student marks using the following format:

RegNo Name Quiz1 Quiz2 Quiz3 Mid End Total Grade
Display Individual Student Marks

The system asks for a registration number and displays marks in the same format.

These requirements are mentioned in the assignment instructions.

Total Marks Calculation

The total marks are calculated using the following formula:

Total = 10% from best 02 quizzes + 20% from mid + 70% from end
Explanation
From the three quiz marks, the best two quiz marks are selected
Their contribution is taken as 10%
Mid exam contributes 20%
End exam contributes 70%

This formula is stated in the assignment.

Example

Suppose:

Quiz1 = 10
Quiz2 = 15
Quiz3 = 20
Mid = 60
End = 75

Best two quizzes = 15 + 20 = 35

Then:

Quiz contribution = (35 / 200) * 10
Mid contribution = (60 / 100) * 20
End contribution = (75 / 100) * 70

Final total = sum of above values

Grade Calculation

After calculating the total, the grade is assigned according to the faculty bylaw.
The exact grading boundaries can be implemented in the program according to the marks-to-grade rule decided for the project. The assignment specifies that grades must be calculated according to the faculty bylaw.

Example grading logic used in the system:

A : 75 and above
B : 65 – 74
C : 55 – 64
S : 45 – 54
F : Below 45
Important Constraints

The system must follow these constraints:

No database should be used
No GUI should be used
No hardcoded data should be used
All data must be entered by users and stored in files
Registration numbers cannot be reused
When adding a new student, both StudentData.txt and DeletedStudentData.txt must be checked
If a registration number exists in either file, the system must display:
Registration number already exists. Cannot reuse.
Marks can only be added if the student exists in StudentData.txt
Marks must not be added for deleted students
Basic exceptions must be handled
Concepts from Lesson 01 to Lesson 05 should be used as much as possible

These mandatory constraints are clearly listed in the practical sheet.

Java Concepts Used

This project uses the following Java concepts:

Classes and objects
Methods
Conditional statements
Loops
Arrays / String arrays
File handling
Exception handling
Menu-driven programming
Data searching and updating using files

The assignment also requires using concepts learned from Lesson 01 to Lesson 05.

Program Flow
Display the Main Menu
User selects Student Operations or Marks Operations
Perform the selected task
Return to the appropriate menu
Continue until the user selects Exit
Expected Output Format

For displaying marks, the output should follow this format:

RegNo   Name   Quiz1   Quiz2   Quiz3   Mid   End   Total   Grade

This display format is explicitly required in the assignment.

Error Handling

The system should handle basic errors such as:

File not found
Invalid user input
Registration number not found
Student not found when adding marks
Attempting to reuse an existing registration number

The assignment specifically requires basic exception handling.

Conclusion

This Marks Management System is a simple Java console application developed to manage student details and marks using file handling.
It demonstrates practical usage of Java programming fundamentals such as file handling, exception handling, methods, loops, and menu-based program design.
The system fulfills the assignment requirements by storing active and deleted records separately, validating student existence before adding marks, and calculating total marks and grades during display.

