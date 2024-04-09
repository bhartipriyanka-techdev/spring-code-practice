package org.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBankBalance {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        PhonePay phonePay = applicationContext.getBean("phonePay", PhonePay.class);
        phonePay.getAccount().getBalance();
    }
}
