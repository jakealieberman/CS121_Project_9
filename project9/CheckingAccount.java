import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    protected double balance;

    public CheckingAccount() {
        this(0.0d);
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        CheckingAccount acct = new CheckingAccount();
        acct.start();
    }

    public String menu() {
        System.out.println("\nAccount menu\n");
        System.out.println("0) quit");
        System.out.println("1) check balance");
        System.out.println("2) make a deposit");
        System.out.println("3) make a withdrawal");
        System.out.print("\nPlease enter 0-3: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public void start() {
        System.out.println("Checking Account");
        while (true) {
            String choice = menu();
            switch (choice) {
                case "0": return;
                case "1": checkBalance(); break;
                case "2": makeDeposit(); break;
                case "3": makeWithdrawal(); break;
                default:  System.out.println("Invalid choice.");
            }
        }
    }

    public double getBalance() { return balance; }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) { this.balance = balance; }

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    private double getDouble(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, using 0.");
            return 0.0d;
        }
    }

    public void makeDeposit() {
        System.out.println("Making a deposit...");
        double amt = getDouble("How much to deposit? ");
        if (amt < 0) {
            System.out.println("Cannot deposit negative amounts.");
            return;
        }
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        double amt = getDouble("How much to withdraw? ");
        if (amt < 0) {
            System.out.println("Cannot withdraw negative amounts.");
            return;
        }
        balance -= amt; // overdraft handling can come later
        System.out.println("New balance: " + getBalanceString());
    }
}