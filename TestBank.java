public class TestBank {
    public static void main(String[] args) {
        BetterBank b1 = new BetterBank();
        BetterBank b2 = new BetterBank(new BankAccount[] {new BankAccount(), new BankAccount()});
        BetterBank b3 = new BetterBank("David Bank");
        b1.getAccounts();
        b2.getAccounts();
        b3.getAccounts();
        b1.printCompanyReport();
        b2.printCompanyReport();
        b3.printCompanyReport();
        b1.addInterest();
        b2.addInterest();
        b3.addInterest();
        b1.calcTotalFunds();
        b2.calcTotalFunds();
        b3.calcTotalFunds();
        b1.chargeFees(5.0);
        b2.chargeFees(10.0);
        b3.chargeFees(20.0);
    }
}