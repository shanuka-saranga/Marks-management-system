import java.util.Scanner;
import java.io.*;

public class MarksManager {
    public static void addMarks(Scanner sc) {

        System.out.print("Enter RegNo: ");
        String regNo = sc.nextLine();

        // check student exists
        if (!StudentManager.isExists(regNo, "StudentData.txt")) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Quiz1: ");
        int q1 = sc.nextInt();

        System.out.print("Quiz2: ");
        int q2 = sc.nextInt();

        System.out.print("Quiz3: ");
        int q3 = sc.nextInt();

        System.out.print("Mid: ");
        int mid = sc.nextInt();

        System.out.print("End: ");
        int end = sc.nextInt();

        try {
            FileWriter fw = new FileWriter("MarksData.txt", true);
            fw.write(regNo + " " + q1 + " " + q2 + " " + q3 + " " + mid + " " + end + "\n");
            fw.close();

            System.out.println("Marks added successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    public static void displayAllMarks() {
        try {
            BufferedReader marksReader = new BufferedReader(new FileReader("MarksData.txt"));
            String markLine;

            System.out.println("RegNo\tName\tQuiz1\tQuiz2\tQuiz3\tMid\tEnd\tTotal\tGrade");

            while ((markLine = marksReader.readLine()) != null) {
                String[] markData = markLine.split(" ");

                String regNo = markData[0];
                int q1 = Integer.parseInt(markData[1]);
                int q2 = Integer.parseInt(markData[2]);
                int q3 = Integer.parseInt(markData[3]);
                int mid = Integer.parseInt(markData[4]);
                int end = Integer.parseInt(markData[5]);

                String name = getStudentName(regNo);

                double total = calculateTotal(q1, q2, q3, mid, end);
                String grade = calculateGrade(total);

                System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n",
                        regNo, name, q1, q2, q3, mid, end, total, grade);
            }

            marksReader.close();

        } catch (IOException e) {
            System.out.println("Error reading marks file!");
        }
    }

    public static String getStudentName(String regNo) {
        try {
            BufferedReader studentReader = new BufferedReader(new FileReader("StudentData.txt"));
            String line;

            while ((line = studentReader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].equals(regNo)) {
                    studentReader.close();
                    return data[1];
                }
            }

            studentReader.close();
        } catch (IOException e) {
            System.out.println("Error reading student file!");
        }

        return "Unknown";
    }

    public static double calculateTotal(int q1, int q2, int q3, int mid, int end) {
        int lowestQuiz = Math.min(q1, Math.min(q2, q3));
        int bestTwoSum = q1 + q2 + q3 - lowestQuiz;

        double quizPart = (bestTwoSum / 200.0) * 10.0;
        double midPart = (mid / 100.0) * 20.0;
        double endPart = (end / 100.0) * 70.0;

        return quizPart + midPart + endPart;
    }

    public static String calculateGrade(double total) {
        if (total >= 75) {
            return "A";
        } else if (total >= 65) {
            return "B";
        } else if (total >= 55) {
            return "C";
        } else if (total >= 45) {
            return "S";
        } else {
            return "F";
        }
    }



    public static void displayIndividualMarks() {
        BufferedReader marksReader = null;
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter RegNo: ");
            String regNoInput = input.readLine();

            marksReader = new BufferedReader(new FileReader("MarksData.txt"));
            String markLine;
            boolean found = false;

            System.out.println("RegNo\tName\tQuiz1\tQuiz2\tQuiz3\tMid\tEnd\tTotal\tGrade");

            while ((markLine = marksReader.readLine()) != null) {
                String[] markData = markLine.split(" ");

                String regNo = markData[0];

                if (regNo.equals(regNoInput)) {
                    int q1 = Integer.parseInt(markData[1]);
                    int q2 = Integer.parseInt(markData[2]);
                    int q3 = Integer.parseInt(markData[3]);
                    int mid = Integer.parseInt(markData[4]);
                    int end = Integer.parseInt(markData[5]);

                    String name = getStudentName(regNo);
                    double total = calculateTotal(q1, q2, q3, mid, end);
                    String grade = calculateGrade(total);

                    System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n",
                            regNo, name, q1, q2, q3, mid, end, total, grade);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Marks not found for this student!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file!");
        } finally {
            try {
                if (marksReader != null) {
                    marksReader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file!");
            }
        }
    }






}
