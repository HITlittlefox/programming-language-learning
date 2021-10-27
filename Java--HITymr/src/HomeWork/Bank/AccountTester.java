package HomeWork.Bank;

public class AccountTester {
    public static void main(String[] args) {
        BankAccount anAccount;
        anAccount = new BankAccount("ZhangLi", 100023, 0);//走的有参构造函数
        System.out.println("=======================");
        System.out.println("角色1更改前");
        System.out.println("Here is the account: " + anAccount);
        System.out.println("Account name: " +
                anAccount.getOwnerName());
        System.out.println("Account number: " +
                anAccount.getAccountNumber());
        System.out.println("Balance: $" + anAccount.getBalance());


        anAccount.setBalance(anAccount.getBalance() + 100);
        System.out.println("=======================");
        System.out.println("角色1更改后");
        System.out.println("Here is the account: " + anAccount);
        System.out.println("Account name: " +
                anAccount.getOwnerName());
        System.out.println("Account number: " +
                anAccount.getAccountNumber());
        System.out.println("Balance: $" + anAccount.getBalance());

        System.out.println("=======================");
        System.out.println("添加角色2并进行存款和取款");
        anAccount = new BankAccount("WangFang", 100024, 0);
        System.out.println(anAccount);
        anAccount.deposit(225.67f);
        anAccount.deposit(300.00f);
        System.out.println(anAccount);
        anAccount.withdraw(400.17f);
        System.out.println(anAccount);

        BankAccount eg1 = BankAccount.example1();
        BankAccount eg2 = BankAccount.example2();
        BankAccount eg3 = BankAccount.emptyAccountExample();

    }

}
