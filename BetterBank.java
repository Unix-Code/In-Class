public class BetterBank{
    private BankAccount[] accounts;
    private Employee president;
    private Employee vicepresident;
    private Employee[] tellers;
    private Customer bob;

    public BetterBank() {
        accounts = new BankAccount[10];
        for (int i = 0; i < 10; i++)
        {
            accounts[i] = new BankAccount();
        }
        president = new Employee("Bob", "Wilson", "00-000-0001", 21, "President", 90000);
        vicepresident = new Employee("Bill", "Wilson", "00-000-0002", 21, "Vice President", 90000);
        tellers = new Employee[]{new Employee("Joe", "Wilson", "00-000-0001", 21, "Teller", 9000)};
    }

    public BetterBank(BankAccount[] accounts) {
        this.accounts = accounts;
        president = new Employee("Bob", "Wilson", "00-000-0001", 21, "President", 90000);
        vicepresident = new Employee("Bill", "Wilson", "00-000-0002", 21, "Vice President", 90000);
        tellers = new Employee[]{new Employee("Joe", "Wilson", "00-000-0001", 21, "Teller", 9000)};
    }

    public BetterBank(String newOwner) {
        accounts = new BankAccount[100];
        for (int i = 0; i < 100; i++)
        {
            accounts[i] = new BankAccount(newOwner, Math.random() * 100000 +1);
        }
        president = new Employee("Bob", "Wilson", "00-000-0001", 21, "President", 90000);
        vicepresident = new Employee("Bill", "Wilson", "00-000-0002", 21, "Vice President", 90000);
        tellers = new Employee[]{new Employee("Joe", "Wilson", "00-000-0001", 21, "Teller", 9000)};
    }

    public BankAccount[] getAccounts()
    {
        return accounts;
    }

    public void calcTotalFunds()
    {
        int count = 1;
        for(BankAccount account : accounts)
        {            
            System.out.println("Account " + count + " Balance: " + account.getBalance());
            count++;
        }
    }

    public void chargeFees(double fee)
    {
        for(int i = 0; i < accounts.length; i++)
        {
            accounts[i].withdraw(fee);
        }
    }

    public void addInterest()
    {   
        for(BankAccount account : accounts)
        {
            account.deposit(account.getBalance() * 0.05);
        }
    }

    public void printAllReports()
    {
        for(int i = 0; i < accounts.length; i++)
        {
            accounts[i].printSlip();
        }
    }

    public void fireBigShots()
    {
        president.fire();
        vicepresident.fire();
    }

    public void replaceBigShots(Employee newPresident, Employee newVice)
    {
        president = newPresident;
        vicepresident = newVice;
    }

    public void giveTellersRaiser(double Raise)
    {
        for(int i = 0; i < tellers.length; i++)
        {
            tellers[i].giveRaise(Raise);
        }
    }

    public void printCompanyReport()
    {
        president.printPersonnelReport();
        vicepresident.printPersonnelReport();
        for(Employee teller : tellers)
        {
            teller.printPersonnelReport();
        }
    }

    public boolean checkEqual(double d1, double d2)
    {
        return (d1 == d2);
    }
}