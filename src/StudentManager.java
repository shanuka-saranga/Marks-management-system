import java.io.*;
import java.util.Scanner;

public class StudentManager {

    static String STUDENT_FILE = "StudentData.txt";
    static String DELETED_FILE = "DeletedStudentData.txt";

    public static void addStudent(Scanner sc) {
        try {
            System.out.print("Enter RegNo: ");
            String regNo = sc.nextLine();

            if (isExists(regNo, STUDENT_FILE) || isExists(regNo, DELETED_FILE)) {
                System.out.println("Registration number already exists. Cannot reuse.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter DOB: ");
            String dob = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Contact: ");
            String contact = sc.nextLine();

            FileWriter fw = new FileWriter(STUDENT_FILE, true);
            fw.write(regNo + "," + name + "," + dob + "," + email + "," + contact + "\n");
            fw.close();

            System.out.println("Student added successfully.");

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static boolean isExists(String regNo, String fileName) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                return false;
            }

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(regNo)) {
                    fileScanner.close();
                    return true;
                }
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("File reading error");
        }

        return false;
    }

    public static void viewStudent(Scanner sc) {

        System.out.print("Enter RegNo: ");
        String regNo = sc.nextLine();

        try {
            File file = new File("StudentData.txt");

            if (!file.exists()) {
                System.out.println("No student data found.");
                return;
            }

            Scanner fileReader = new Scanner(file);
            boolean found = false;

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(regNo)) {
                    System.out.println("\n--- Student Details ---");
                    System.out.println("RegNo: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("DOB: " + data[2]);
                    System.out.println("Email: " + data[3]);
                    System.out.println("Contact: " + data[4]);
                    found = true;
                    break;
                }
            }

            fileReader.close();

            if (!found) {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    public static void updateStudent(Scanner sc) {
        System.out.print("Enter RegNo to update: ");
        String regNo = sc.nextLine();

        File inputFile = new File(STUDENT_FILE);
        File tempFile = new File("TempStudentData.txt");

        try {
            if (!inputFile.exists()) {
                System.out.println("Student data file not found.");
                return;
            }

            Scanner fileReader = new Scanner(inputFile);
            FileWriter fw = new FileWriter(tempFile);

            boolean found = false;

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(regNo)) {
                    found = true;

                    System.out.println("\n--- Student Update ---");
                    System.out.println("1. Update Name");
                    System.out.println("2. Update DoB");
                    System.out.println("3. Update Contact No");
                    System.out.print("Enter your choice: ");
                    int choice = Integer.parseInt(sc.nextLine());

                    if (choice == 1) {
                        System.out.print("Enter new Name: ");
                        data[1] = sc.nextLine();
                    } else if (choice == 2) {
                        System.out.print("Enter new DoB: ");
                        data[2] = sc.nextLine();
                    } else if (choice == 3) {
                        System.out.print("Enter new Contact No: ");
                        data[4] = sc.nextLine();
                    } else {
                        System.out.println("Invalid choice.");
                    }

                    line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4];
                }

                fw.write(line + "\n");
            }

            fileReader.close();
            fw.close();

            if (found) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("Student updated successfully.");
            } else {
                tempFile.delete();
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating student.");
        }
    }



    public static void deleteStudent(Scanner sc) {
        System.out.print("Enter RegNo to delete: ");
        String regNo = sc.nextLine();

        File studentFile = new File(STUDENT_FILE);
        File tempStudentFile = new File("TempStudentData.txt");
        File deletedStudentFile = new File("DeletedStudentData.txt");

        try {
            if (!studentFile.exists()) {
                System.out.println("Student data file not found.");
                return;
            }

            Scanner fileReader = new Scanner(studentFile);
            FileWriter tempWriter = new FileWriter(tempStudentFile, true);
            FileWriter deletedWriter = new FileWriter(deletedStudentFile, true);

            boolean found = false;

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(regNo)) {
                    deletedWriter.write(line + "\n");
                    found = true;
                } else {
                    tempWriter.write(line + "\n");
                }
            }

            fileReader.close();
            tempWriter.close();
            deletedWriter.close();

            if (found) {
                studentFile.delete();
                tempStudentFile.renameTo(studentFile);

                deleteStudentMarks(regNo);

                System.out.println("Student deleted successfully.");
            } else {
                tempStudentFile.delete();
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting student.");
        }


    }

    public static void deleteStudentMarks(String regNo) {
        File marksFile = new File("MarksData.txt");
        File tempMarksFile = new File("TempMarksData.txt");
        File deletedMarksFile = new File("DeletedMarksData.txt");

        try {
            if (!marksFile.exists()) {
                return;
            }

            Scanner fileReader = new Scanner(marksFile);
            FileWriter tempWriter = new FileWriter(tempMarksFile);
            FileWriter deletedWriter = new FileWriter(deletedMarksFile, true);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(regNo)) {
                    deletedWriter.write(line + "\n");
                } else {
                    tempWriter.write(line + "\n");
                }
            }

            fileReader.close();
            tempWriter.close();
            deletedWriter.close();

            marksFile.delete();
            tempMarksFile.renameTo(marksFile);

        } catch (Exception e) {
            System.out.println("Error deleting marks.");
        }
    }



}