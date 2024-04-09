package org.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SBI implements BankAccount{

    @Value(value = "9876543210")
    private double balance;
    @Override
    public void getBalance() {
        System.out.println("Balance of SBI Bank:"+balance);
    }
}
