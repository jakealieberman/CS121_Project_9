/* SavingsAccount.java
    represents a savings account that extends CheckingAccount 
    and adds interest calculation
*/

public class SavingsAccount extends CheckingAccount { // extends CheckingAccount
    private double interestRate; 

    public SavingsAccount() { // default constructor
        this(0.0d, 0.0d);
    }

    public SavingsAccount(double balance, double interestRate) { // constructor
        super(balance);
        this.interestRate = interestRate;
    }

    public static void main(String[] args) { // test main
        SavingsAccount s = new SavingsAccount(0.0d, 0.01d);
        s.start();
    }

    public void calcInterest() { // calculate and add interest
        double interest = balance * interestRate;
        balance += interest;
    }

    public void setInterestRate(double rate) { this.interestRate = rate; } // setter

    public double getInterestRate() { return interestRate; } // getter

    public void start() { // override start and add interst option
        System.out.println("Savings Account");
        super.start(); // reuse the same menu/handlers as CheckingAccount
    }
}