package org.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Credentials {
    @Value(value = "${dbUser.userName}")
    private String userName;
    @Value(value = "${dbUser.userPassword}")
    private String userPassword;
    public void display(){
        System.out.println("User Name is :"+userName);
        System.out.println("User Password is :"+userPassword);
    }

}
