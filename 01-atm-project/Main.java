import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int balance=0, amount, choice;
        System.out.println("Welcome to the ATM!");

        while (balance >= 0) {
            System.out.printf("%nEnter the transaction you wish to perform:" +
                    "%n1 - Check balance" +
                    "%n2 - Deposit" +
                    "%n3 - Withdraw" +
                    "%n4 - Exit %n: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: " + balance);
                    break;
                case 2:
                    System.out.print("Enter the amount you wish to deposit: ");
                    amount = scan.nextInt();
                    balance += amount;
                    System.out.println("Your transaction has been completed!");
                    break;
                case 3:
                    System.out.print("Enter the amount you wish to withdraw: ");
                    amount = scan.nextInt();
                    balance -= amount;
                    System.out.println("Your transaction process has been completed!");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    continue;
                default:
                    System.out.println("Please enter a valid transaction number!");
            }
        }

        System.out.print("We look forward to seeing you again!");
    }
}
