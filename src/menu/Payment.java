/*
author : Jason
date : 9/4/2021
 */
package menu;

import java.util.*;

public class Payment {
    private double total_payment;
    private double balance;
    private double payment_input;
    private static double total_amount = 0.0;
    
    public Payment() {}
    
    public Payment(double TotalPrice) {
        this.total_payment = TotalPrice;
    }

    public double getTotal_payment() {
        return total_payment;
    }

    public double getBalance() {
        return balance;
    }

    public double getPayment_input() {
        return payment_input;
    }

    public void setPayment_input(double payment_input) {
        this.payment_input = payment_input;
    }

    public static double getTotal_amount() {
        return total_amount;
    }
    
    public void calcBalance() {
        this.balance = this.payment_input - this.total_payment;
        total_amount += this.total_payment;
    }
    
    public String decimalPoint(double price) {
        return String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return " Total payment  : RM" + decimalPoint(total_payment) + "\n Balance        : RM" + decimalPoint(balance);
    }
}

//changed