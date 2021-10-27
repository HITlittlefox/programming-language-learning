package HomeWork.Bank;


public class AccountTester2 {
    public static void main(String[] args) {
        BankAccount2 bobsAccount, marysAccount, biffsAccount;
        BankAccount2 b = new BankAccount2();
        bobsAccount = BankAccount2.example1();
        marysAccount = BankAccount2.example1();
        biffsAccount = BankAccount2.example2();
        marysAccount.setOwnerName("Mary");
        marysAccount.deposit(250);
        System.out.println(bobsAccount);
        System.out.println(marysAccount);
        System.out.println(biffsAccount);
    }
}
