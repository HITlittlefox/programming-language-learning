package com.atguigu.exer3;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("您的余额：" + balance + ";" + "您想取出的金钱:" + amount + ";" + "余额不足，取款失败");
            return;
        }
        System.out.println("您的余额：" + balance + ";" + "您想取出的金钱:" + amount + ";" + "成功取出：" + amount);
        balance = balance - amount;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            System.out.println("您的余额：" + balance + ";" + "您想存入的金钱:" + amount + ";" + "成功存入：" + amount);
            balance += amount;
        }


    }
}
