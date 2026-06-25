import java.util.*;

public class Main {

    /**
     * Prompts the user to continue or exit the application.
     * Uses recursion to handle invalid inputs gracefully.
     *
     * @return true if the user wants to proceed, false if they wish to exit.
     */
    public static boolean question() {
        Scanner a = new Scanner(System.in);
        System.out.printf("%nDo you want to proceed with any transaction? %nYes (PROCEED) %nNo (EXIT) %n: ");
        String answer = a.next();

        if (answer.equalsIgnoreCase("Yes")) {
            return true;
        }
        else if (answer.equalsIgnoreCase("No")) {
            return false;
        }
        else {
            System.out.println("Invalid input! Please type Yes or No.");
            return question();  // Recursive call for input validation
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // TODO: Replace hardcoded PIN with a database or secure hash validation in the future
        int correctPin = 1234;
        int enteredPin, attempts = 3;
        boolean isAuthenticated = false;

        // Transaction state variables
        int balance = 0, amount, choice;
        boolean isRunning = false;
        String options = "%n1 - Check balance %n2 - Deposit %n3 - Withdraw %n4 - Exit %n: ";

        System.out.println("WELCOME TO THE ATM!");

        // --- Authentication Block ---
        // Security logic: Prevent infinite brute-force attacks by limiting attempts
        while (attempts > 0) {
            System.out.print("Please enter your PIN: ");
            enteredPin = scan.nextInt();

            if (enteredPin == correctPin) {
                System.out.println("Login successful!\n");
                isAuthenticated = true;
                isRunning = true;
                break;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Incorrect PIN! You have " + attempts + " attempts left.");
                } else {
                    System.out.println("Your card has been blocked due to too many incorrect attempts. Please contact your bank.");
                }
            }
        }

        // --- Main Application Loop ---
        if (isAuthenticated) {
            System.out.printf("%nEnter the transaction you wish to perform:" + options);
            choice = scan.nextInt();
            System.out.println();

            while (isRunning) {
                switch (choice) {
                    case 1:
                        System.out.printf("Your balance: %d%n", balance);

                        isRunning = question();
                        if (isRunning) {
                            System.out.printf(options);
                            choice = scan.nextInt();
                        }
                        break;
                    case 2:
                        System.out.print("Enter the amount you wish to deposit: ");
                        amount = scan.nextInt();
                        balance += amount;
                        System.out.printf("Your transaction has been completed! %n");

                        isRunning = question();
                        if (isRunning) {
                            System.out.printf(options);
                            choice = scan.nextInt();
                        }
                        break;
                    case 3:
                        System.out.print("Enter the amount you wish to withdraw: ");
                        amount = scan.nextInt();

                        // Business Logic: Prevent overdraft (negative balance)
                        if (amount > balance) {
                            System.out.println("Insufficient balance! You cannot withdraw more than your current balance.");
                        } else {
                            balance -= amount;
                            System.out.printf("Your transaction process has been completed! %n");
                        }

                        isRunning = question();
                        if (isRunning) {
                            System.out.printf(options);
                            choice = scan.nextInt();
                        }
                        break;
                    case 4:
                        System.out.println("Logging out...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Please enter a valid transaction number!");

                        isRunning = question();
                        if (isRunning) {
                            System.out.printf(options);
                            choice = scan.nextInt();
                        }
                }
            }

            System.out.print("We look forward to seeing you again!\n");
        }

        // Note: System.in Scanner is not closed here to prevent conflicts if this was part of a larger system,
        // but typically scan.close() should be considered to prevent memory leaks.
    }
}
