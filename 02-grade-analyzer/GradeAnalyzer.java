import java.util.Scanner;

public class GradeAnalyzer {
    /**
     *
     * GradeAnalyzer takes student midterm/final grades,
     * calculates their weighted average, and converts them into letter grades.
     *
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentNum, midtermGrade, finalGrade;
        String line = "\n--------------------------------------------------\n";

        System.out.println(line + "\n* WELCOME TO THE GRADE ANALYZER! \n");
        studentNum = getValidatedInt(scan, "How many students' data will you enter? \nEntry: ");

        // [Student Index][3] -> [0:ID, 1:Midterm, 2:Final]
        int[][] studentGrades = new int[studentNum][3];

        for (int i = 0; i < studentNum; i++) {
            System.out.println("\n===== Entering data for Student " + (i + 1) + " =====\n");

            studentGrades[i][0] = getValidatedInt(scan, "Student ID: ");
            studentGrades[i][1] = getValidatedInt(scan, "Midterm Grade: ");
            studentGrades[i][2] = getValidatedInt(scan, "Final Grade: ");
        }
        System.out.println("\n=== Grade entry successful! ===\n" + line);

        // Matrix to store processed student data
        double[][] studentAverages = new double[studentNum][2];

        for (int i = 0; i < studentNum; i++) {
            double midtermG = studentGrades[i][1];
            double finalG = studentGrades[i][2];

            // Calculate weighted average
            studentAverages[i][0] = studentGrades[i][0];
            studentAverages[i][1] = (midtermG * 0.4) + (finalG * 0.6);

            double studentId = studentAverages[i][0];  // ID cannot be double
            double average = studentAverages[i][1];
            String letter = getLetterGrade(average);

            // Display results in a formatted table
            System.out.printf("Student ID: %.0f |  Grade: %.2f |  Letter: %s %n",
                    studentId, average, letter);
        }

        System.out.println("\nAnalysis complete.\n" + line);
        scan.close();  // Close the scanner to release resources
    }

    /**
     *
     * Loops until it receives a valid integer input from the user.
     * Catches and clears errors (example, invalid letters) in the input.
     */
    public static int getValidatedInt(Scanner scan, String text){
        while (true) {
            try {
                System.out.print(text);
                return scan.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("*\n * Error! Please enter a valid integer. * * *\n*");
                scan.next();  // Clear the invalid input buffer
            }
        }
    }

    /**
     *
     * Converts numeric average to letter grade.
     * @param avg Student's calculated weighted average
     * @return Letter grade (String)
     */
    public static String getLetterGrade(double avg) {
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
