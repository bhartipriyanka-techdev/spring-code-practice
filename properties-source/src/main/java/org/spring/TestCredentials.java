package org.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCredentials {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Credentials credentials = applicationContext.getBean("credentials", Credentials.class);
        credentials.display();
    }
}
