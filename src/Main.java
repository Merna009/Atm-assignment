import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in);

    int pin = 1234;
    int enteredPin;
    int attempts = 0;
    int choice;

    double balance = 2500.75;
    double amount;

    int transactions = 0;
    boolean loggedIn = false;


    while (attempts < 3) {

        System.out.print("Enter your PIN: ");
        enteredPin = input.nextInt();

        if (enteredPin == pin) {
            System.out.println("Login successful!");
            loggedIn = true;
            break;
        } else {
            attempts++;
            System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
        }
    }

    if (loggedIn == false) {

        System.out.println("Your account has been locked.");

    } else {


        do {

            System.out.println("\n========= ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("=======================");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = input.nextDouble();

                    if (amount > 0) {

                        balance = balance + amount;
                        transactions++;

                        System.out.println("Deposit successful!");
                        System.out.println("Updated balance: " + balance);

                    } else {

                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = input.nextDouble();

                    if (amount == 0) {

                        System.out.println("Transaction cancelled.");

                    } else if (amount < 0) {

                        System.out.println("Invalid amount.");

                    } else if (amount > balance) {

                        System.out.println("Insufficient balance.");

                    } else {

                        balance = balance - amount;
                        transactions++;

                        System.out.println("Withdrawal successful!");
                        System.out.println("Updated balance: " + balance);

                        if (balance == 0) {
                            System.out.println("Warning: Your account is empty.");
                        }
                    }
                    break;

                case 4:
                    if (balance >= 5000) {

                        System.out.println("VIP Customer");

                    } else if (balance >= 1000) {

                        System.out.println("Regular Customer");

                    } else {

                        System.out.println("Low Balance");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM.");
                    System.out.println("Total successful transactions: " + transactions);
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }


}

