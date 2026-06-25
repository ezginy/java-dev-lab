import java.util.Scanner;

public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentNum;
        int[][] studentGrades;
        int studentId, midtermGrade, finalGrade;

        System.out.println("Welcome to the Grade Analyzer! \n");

        System.out.print("How many students' data will you enter? \n: ");
        studentNum = scan.nextInt();
        studentGrades = new int[studentNum][3];

        for (int i=0; i<studentNum; i++) {
            System.out.println("\n--- Entering data for Student " + (i + 1) + " ---");

            System.out.print("\nStudent ID: ");
            studentGrades[i][0] = scan.nextInt();

            System.out.print("\nMidterm Grade: ");
            studentGrades[i][1] = scan.nextInt();

            System.out.print("\nFinal Grade: ");
            studentGrades[i][2] = scan.nextInt();
        }
    }
}
