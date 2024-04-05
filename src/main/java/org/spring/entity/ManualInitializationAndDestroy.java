package org.spring.entity;

public class ManualInitializationAndDestroy {
    static {
        System.out.println("Demo Class has been Created/Loaded Successfully....!");
    }

    ManualInitializationAndDestroy() {
        System.out.println("Demo Object has been Created Successfully.....!");
    }

    public void myInit() {
        System.out.println("Demo Class hs been Initialized Successfully....!");
    }

    public void myDestroy() {
        System.out.println("Demo class has been Destroyed Successfully.......");
    }
}
