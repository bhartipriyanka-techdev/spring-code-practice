package org.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ICICI implements BankAccount{
    @Value(value = "9876543210")
    private double balance;
    @Override
    public void getBalance() {
        System.out.println("Balance of ICICI Bank:"+balance);
    }
}
