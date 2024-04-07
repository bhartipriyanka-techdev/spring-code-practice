package org.spring.controller;

import org.spring.EmployeeConfig;
import org.spring.dao.EmployeeDAO;
import org.spring.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        EmployeeDAO employeeDAO = applicationContext.getBean(EmployeeDAO.class);
        System.out.println("Table created Successfully...");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Press 1 For -> Save Employee");
            System.out.println("Press 2 For -> Update Employee");
            System.out.println("Press 3 For -> Find Employee By ID");
            System.out.println("Press 4 For -> Verify Employee By Phone and Password");
            System.out.println("Press 5 For -> Save Employee By Email and Password");
            System.out.println("Press 6 For -> Save Employee By Id and Password");
            System.out.println("Press 7 For -> Find Employee By Salary");
            System.out.println("Press 8 For -> Find Employee By Designation");
            System.out.println("Press 9 For -> Find Employee By Name");
            System.out.println("Press 10 For -> Find Employee By Between Salary range");
            System.out.println("Press 11 For -> exit");

            System.out.print("Enter Your Choice :");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:{
                    Employee employee = new Employee();
                    System.out.print("Enter Employee Name :");
                    employee.setEmployeeName(scanner.next());

                    System.out.print("Enter Employee Email :");
                    employee.setEmployeeEmail(scanner.next());

                    System.out.print("Enter Employee Phone No :");
                    employee.setEmployeePhone(scanner.nextLong());

                    System.out.print("Enter Employee Salary :");
                    employee.setEmployeeSalary(scanner.nextDouble());

                    System.out.print("Enter Employee Designation :");
                    employee.setEmployeeDesg(scanner.next());

                    System.out.print("Enter Employee Password :");
                    employee.setEmployeePassword(scanner.next());

                    employee = employeeDAO.saveEmployee(employee);
                    System.out.println("Employee saved with id :" + employee.getEmployeeID());
                    System.out.println("-------------------------------------------------------");
                    break;
            }
                case 2: {
                    Employee employee = new Employee();
                    System.out.print("Enter Employee Name :");
                    employee.setEmployeeName(scanner.next());

                    System.out.print("Enter Employee Email :");
                    employee.setEmployeeEmail(scanner.next());

                    System.out.print("Enter Employee Phone No :");
                    employee.setEmployeePhone(scanner.nextLong());

                    System.out.print("Enter Employee Salary :");
                    employee.setEmployeeSalary(scanner.nextDouble());

                    System.out.print("Enter Employee Designation :");
                    employee.setEmployeeDesg(scanner.next());

                    System.out.print("Enter Employee Password :");
                    employee.setEmployeePassword(scanner.next());

                    employee = employeeDAO.updateEmployee(employee);
                    if (employee != null)
                        System.out.println("Employee with Id:" + employee.getEmployeeID() + " updated");
                    else
                        System.err.println("Cannot Update Employee as Id is Invalid");

                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 3:{
                    System.out.print("Enter the Employee Id to find Employee");
                    int employeeId = scanner.nextInt();
                    Employee employee = employeeDAO.findEmployeeById(employeeId);
                    if (employee != null) {
                        System.out.println("Employee found");
                        System.out.println("ID\t NAME\tDESIGNATION\t\t PHONE SALARY\t EMAIL");
                        System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeDesg()+"\t"+employee.getEmployeePhone()+"\t"+employee.getEmployeeSalary()+"\t"+employee.getEmployeeEmail());
                    } else {
                        System.err.println("Cannot find Employee as Invalid Employee Id");
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 4:{
                    System.out.print("Enter the Employee Phone :");
                    long phone = scanner.nextLong();
                    System.out.print("Enter the Employee Password:");

                    String password = scanner.next();
                    Employee employee = employeeDAO.verifyEmployeeByPhoneAndPassword(phone, password);
                    if (employee != null) {
                        System.out.println("ID\t NAME\tDESIGNATION\t\t PHONE SALARY\t EMAIL");
                        System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeDesg()+"\t"+employee.getEmployeePhone()+"\t"+employee.getEmployeeSalary()+"\t"+employee.getEmployeeEmail());

                    } else {
                        System.err.println("Invalid Phone Number or Password");
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 5: {
                    System.out.print("Enter the Employee Email :");
                    String email = scanner.next();
                    System.out.print("Enter the Employee Password:");
                    String password = scanner.next();
                    Employee employee = employeeDAO.verifyEmployeeByEmailAndPassword(email, password);
                    if (employee != null) {
                        System.out.println("ID\t NAME\tDESIGNATION\t\t PHONE SALARY\t EMAIL");
                        System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeDesg()+"\t"+employee.getEmployeePhone()+"\t"+employee.getEmployeeSalary()+"\t"+employee.getEmployeeEmail());



                    } else {
                        System.err.println("Invalid Phone Number or Password");
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 6: {
                    System.out.print("Enter the Employee Id :");
                    int id = scanner.nextInt();
                    System.out.print("Enter the Employee Password:");
                    String password = scanner.next();
                    Employee employee = employeeDAO.verifyEmployeeByIdAndPassword(id, password);
                    if (employee != null) {
                        System.out.println("ID\t NAME\tDESIGNATION\t\t PHONE SALARY\t EMAIL");
                        System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmployeeDesg()+"\t"+employee.getEmployeePhone()+"\t"+employee.getEmployeeSalary()+"\t"+employee.getEmployeeEmail());

                    } else {
                        System.err.println("Invalid Employee Id or Password");
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 7: {
                    System.out.print("Enter the salary to find Employees");
                    double salary = scanner.nextDouble();
                    List<Employee> employee = employeeDAO.findBySalary(salary);
                    if (employee.isEmpty()) {
                        System.err.println("No Employee found with entered salary");
                    } else {
                        System.out.println(employee);

                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 8: {
                    System.out.print("Enter the Designation to find Employees");
                    String desg = scanner.next();
                    List<Employee> employees = employeeDAO.findByDesg(desg);
                    if (employees.isEmpty()) {
                        System.err.println("No Employee found with entered designation");
                    } else {
                        System.out.println("List of Employees with entered designation");
                        for (Employee employee : employees)
                            System.out.println(employee);
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 9: {
                    System.out.println("Enter the name to find Employees");
                    String name = scanner.next();
                    List<Employee> employees = employeeDAO.findByName(name);
                    if (employees.isEmpty()) {
                        System.err.println("No Employee found with entered name");
                    } else {
                        System.out.println("List of Employees with entered name");
                        for (Employee employee : employees)
                            System.out.println(employee);
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 10:{
                    System.out.print("Enter the minimum  salary");
                    double minSalary = scanner.nextDouble();
                    System.out.println("Enter the maximum  salary");
                    double maxSalary = scanner.nextDouble();
                    List<Employee> employees = employeeDAO.findBySalaryInRange(minSalary,maxSalary);
                    if (employees.isEmpty()) {
                        System.err.println("No Employee found in entered salary range");
                    } else {
                        System.out.println("List of Employees in entered salary range");
                        for (Employee employee : employees)
                            System.out.println(employee);
                    }
                    System.out.println("-------------------------------------------------------");
                    break;
                }
                case 11: {
                    System.exit(0);

                    break;
                }
            }
        }
    }
}
