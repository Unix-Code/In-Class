public class BankAccount
{

    //fields
    private double balance;
    private String owner;

    //constructors
    /**
     * Default Constructor for objects of class BankAccount
     */
    public BankAccount()
    {
        // initialise instance variables
        balance = 1.0;
        owner = "Tim Barron";
    }

    public BankAccount(String myOwner)
    {
        // initialise instance variables
        balance = 1.0;
        owner = myOwner;
    }

    public BankAccount(String myOwner, double start)
    {
        // initialise instance variables
        balance = start;
        owner = myOwner;
    }

    // methods
    public double getBalance()
    {
        return balance;
    }

    public String getOwner()
    {
        return owner;
    }


    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    public void printSlip()
    {
        System.out.println("This is the balance: $" + balance);
        System.out.println("Account owner: " + owner);
    }

}

