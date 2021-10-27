package com.atguigu.exer4;

public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;

    }

    public double getBalance() {
        return balance;
    }

    //存钱操作
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存钱成功");

        }
    }

    //取钱操作
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("取钱成功");

        } else {
            System.out.println("余额不足，取钱失败");
        }
    }

}