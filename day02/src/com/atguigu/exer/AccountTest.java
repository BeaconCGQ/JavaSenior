package com.atguigu.exer;

/**
  * 银行有一个账户。
  * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
  * 印账户余额。
  * 问题：该程序是否有安全问题，如果有，如何解决？
  *
  * 1.多线程问题：两个储户线程
  * 2.共享数据：账户
  * 3.存在线程安全问题：同步机制：三种方式
  *
  * @author: 86173
  * @date: 2021/4/10 20:28
  */

 class Account {
     private double balance;

     public Account(double balance) {
         this.balance = balance;
     }

    public synchronized void deposit(double amt){

        if (amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
 }

 class Customer extends Thread{

     private Account acct;

     public Customer(Account acct) {
         this.acct = acct;
     }



     @Override
     public void run() {
         for(int i = 0; i < 3; i++){

             acct.deposit(1000);
         }
     }
 }



public class AccountTest {
    public static void main(String[] args) {

        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
