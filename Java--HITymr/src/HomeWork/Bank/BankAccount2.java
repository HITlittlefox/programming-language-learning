package HomeWork.Bank;


/*
修改BankAccount类
增加类变量LAST_ACCOUNT_NUMBER，初始值为0，
当生成一个新的BankAccount对象时，其帐号为LAST_ACCOUNT_NUMBER的值累加1
自动产生对象的accountNumber，且不允许直接修改其值
修改构造方法，取消帐号参数
取消setAccountNumber方法
取消setBalance方法
*/


public class BankAccount2 {
    private static int LAST_ACCOUNT_NUMBER = 0;
    private int accountNumber;
    private String ownerName;
    private float balance;

    //无参构造器
    public BankAccount2() {
        this("", 0);
    }

    //单参构造器
    public BankAccount2(String initName) {
        this(initName, 0);
    }

    //双参构造器，返回类型是他自己，不是类方法（与后面的example1对比）
    public BankAccount2(String initName, float initBal) {
        ownerName = initName;
        accountNumber = ++LAST_ACCOUNT_NUMBER;
        balance = initBal;
    }

    //这是example1方法，是一个类方法，返回类型是BankAccount2类型
    public static BankAccount2 example1() {
        BankAccount2 ba = new BankAccount2();
        ba.setOwnerName("LiHong");
        ba.deposit(1000);
        return ba;
    }

    public static BankAccount2 example2() {
        BankAccount2 ba = new BankAccount2();
        ba.setOwnerName("ZhaoWei");
        ba.deposit(1000);
        ba.deposit(2000);
        return ba;
    }

    public static BankAccount2 emptyAccountExample() {
        BankAccount2 ba = new BankAccount2();
        ba.setOwnerName("HeLi");
        return ba;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public float getBalance() {
        return balance;
    }


    public void setOwnerName(String aName) {
        ownerName = aName;
    }

    //方法重写，返回类型是String，方法名是toString
    @Override
    public String toString() {
        return ("Account #" +
                new java.text.DecimalFormat("000000").format(accountNumber) + " with balance " +
                new java.text.DecimalFormat("$0.00").format(balance));
    }

    public float deposit(float anAmount) {
        balance += anAmount;
        return balance;
    }

    public float withdraw(float anAmount) {
        if (anAmount <= balance)
            balance -= anAmount;
        return anAmount;
    }
}
