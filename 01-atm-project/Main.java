import java.util.*;

public class Main {

    public static boolean question() {
        Scanner a = new Scanner(System.in);
        System.out.printf("%nDo you want to proceed with any transaction? %nYes (PROCEED) %nNo (EXIT) %n: ");
        String answer = a.next();

        if (answer.equalsIgnoreCase("Yes")) {
            return true;
        }
        else if (answer.equals("No") || answer.equals("no") || answer.equals("NO")) {
            return false;
        }
        else {
            return question();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int balance=0, amount, choice;
        boolean isRunning = true;
        String options = "%n1 - Check balance %n2 - Deposit %n3 - Withdraw %n4 - Exit %n: ";

        System.out.println("WELCOME TO THE ATM!");

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
                    balance -= amount;
                    System.out.printf("Your transaction process has been completed! %n");

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
}
