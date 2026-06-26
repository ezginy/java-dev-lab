import java.util.Scanner;

public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentNum, studentId, midtermGrade, finalGrade;

        System.out.println("Welcome to the Grade Analyzer! \n");
        System.out.print("How many students' data will you enter? \n: ");
        studentNum = scan.nextInt();

        int[][] studentGrades = new int[studentNum][3];

        for (int i = 0; i < studentNum; i++) {
            System.out.println("\n--- Entering data for Student " + (i + 1) + " ---");

            System.out.print("\nStudent ID: ");
            studentGrades[i][0] = scan.nextInt();

            System.out.print("\nMidterm Grade: ");
            studentGrades[i][1] = scan.nextInt();

            System.out.print("\nFinal Grade: ");
            studentGrades[i][2] = scan.nextInt();
        }

        double[][] studentAverages = new double[studentNum][2];

        for (int i = 0; i < studentNum; i++) {
            double midtermG = studentGrades[i][1];
            double finalG = studentGrades[i][2];

            studentAverages[i][0] = studentGrades[i][0];
            studentAverages[i][1] = (midtermG * 0.4) + (finalG * 0.6);

            double average = studentAverages[i][1];
            String letter = letterGrade(average);

            System.out.println("Student ID: " + studentAverages[i][0] +
                    " | Grade: " + average +
                    " | Letter: " + letter);
        }
    }

    public static String letterGrade(double avg) {
        if (avg >= 90 && avg <= 100) return "AA";
        else if (avg >= 85) return "BA";
        else if (avg >= 80) return "BB";
        else if (avg >= 75) return "CB";
        else if (avg >= 70) return "CC";
        else if (avg >= 65) return "DC";
        else if (avg >= 60) return "DD";
        else if (avg >= 50) return "FD";
        else return "FF";
    }
}
