package HomeWork.Bank;

//声明BackAccount类
public class BankAccount {
    private String ownerName;
    private int accountNumber;
    private double balance;

    public BankAccount() {
        this("", 0, 0);
    }

    public BankAccount(String initName, int initAccNum, double initBal) {
        ownerName = initName;
        accountNumber = initAccNum;
        balance = initBal;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String newName) {
        ownerName = newName;
    }

    public void setAccountNumber(int newNum) {
        accountNumber = newNum;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    //声明toString()方法
    //对toString进行第一次方法重写
//    public String toString() {
//        return ("Account #" + accountNumber + " with balance $" + balance);
//    }
//
    //对toString进行第二次方法重写
    //使用DecimalFormat类
    public String toString() {
        return ("Account #" + accountNumber + " with balance " +
                new java.text.DecimalFormat("$0.00").format(balance));
    }

    //增加存款方法
    public double deposit(double anAmount) {
        balance += anAmount;
        return (balance);
    }

    //增加取款方法
    public double withdraw(double anAmount) {
        balance -= anAmount;
        return (anAmount);
    }

    //声明“类方法”生成特殊的实例
    //自带案例1
    public static BankAccount example1() {
        BankAccount ba = new BankAccount();
        ba.setOwnerName("LiHong");
        System.out.println("LiHong一闪而过");
        ba.setAccountNumber(554000);
        ba.deposit(1000);
        return ba;
    }

    //自带案例2
    public static BankAccount example2() {
        BankAccount ba = new BankAccount();
        ba.setOwnerName("ZhaoWei");
        System.out.println("ZhaoWei一闪而过");
        ba.setAccountNumber(554001);
        ba.deposit(1000);
        ba.deposit(2000);
        return ba;
    }

    //自带空账户
    public static BankAccount emptyAccountExample() {
        BankAccount ba = new BankAccount();
        ba.setOwnerName("HeLi");
        System.out.println("HeLi一闪而过");
        ba.setAccountNumber(554002);
        return ba;
    }

}

