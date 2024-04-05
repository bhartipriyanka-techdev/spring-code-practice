package org.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycleByApplicationContext {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext.getBean("demo1"));
        System.out.println(applicationContext.getBean("demo1"));
        //System.out.println(applicationContext.getBean("demo"));

        //Closing the ApplicationContext
        ((ClassPathXmlApplicationContext)applicationContext).close();

    }
}
