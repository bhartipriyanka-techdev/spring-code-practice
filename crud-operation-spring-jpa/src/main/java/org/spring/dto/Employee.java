package org.spring.dto;

import javax.persistence.*;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false, unique = true)
    private long employeePhone;
    @Column(nullable = false, unique = true)
    private String employeeEmail;
    @Column(nullable = false)
    private String employeeDesg;
    @Column(nullable = false)
    private double employeeSalary;
    @Column(nullable = false)
    private String employeePassword;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhone=" + employeePhone +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeDesg='" + employeeDesg + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeePassword='" + employeePassword + '\'' +
                '}';
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeDesg() {
        return employeeDesg;
    }

    public void setEmployeeDesg(String employeeDesg) {
        this.employeeDesg = employeeDesg;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}
