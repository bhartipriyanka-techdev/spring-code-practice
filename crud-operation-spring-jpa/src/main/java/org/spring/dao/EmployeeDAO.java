package org.spring.dao;

import org.spring.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAO {
    @Autowired
    private EntityManager entityManager ;

//------------------------Save The Employee-----------------------
    public Employee saveEmployee(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityManager.persist(employee);
        entityTransaction.begin();
        entityTransaction.commit();
        return employee;
    }

    //--------Update Merchant Method---------------------
    public Employee updateEmployee(Employee employee){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Employee dbEmployee = entityManager.find(Employee.class, employee.getEmployeeID() );
        if(dbEmployee != null){
            dbEmployee .setEmployeeName(employee.getEmployeeName());
            dbEmployee .setEmployeeEmail(employee.getEmployeeEmail());
            dbEmployee .setEmployeeDesg(employee.getEmployeeDesg());
            dbEmployee .setEmployeePhone(employee.getEmployeePhone());
            dbEmployee .setEmployeePassword(employee.getEmployeePassword());
            entityTransaction.begin();
            entityTransaction.commit();
            return  dbEmployee ;
        }
        return null;

    }

    //-------------Find Merchant By ID--------------
    public Employee findEmployeeById(int id){
        return  entityManager.find(Employee.class,id);
    }

    //------Verify Merchant By Phone And Password----------
    public  Employee verifyEmployeeByPhoneAndPassword(long phoneNo, String password){
        Query query = entityManager.createQuery("select e from Employee e where e.employeePhone  = ?1 and e.employeePassword = ?2");
        query.setParameter(1,phoneNo);
        query.setParameter(2,password);
        try{
            return (Employee) query.getSingleResult();

        }
        catch (NoResultException exp){
            return  null;
        }
    }

    //------Verify Merchant By Email And Password----------
    public  Employee verifyEmployeeByEmailAndPassword(String email, String password){
        Query query = entityManager.createQuery("select e from Employee e where e.employeeEmail = ?1 and e.employeePassword = ?2");
        query.setParameter(1,email);
        query.setParameter(2,password);
        try{
            return (Employee) query.getSingleResult();

        }
        catch (NoResultException exp){
            return  null;
        }
    }

    public Employee verifyEmployeeByIdAndPassword(int id, String password) {
        Query query = entityManager.createQuery("select e from Employee e where e.employeeID=?1 and e.employeePassword=?2");
        query.setParameter(1, id);
        query.setParameter(2, password);
        try {
            return (Employee) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Employee> findBySalary(double salary) {
        Query query = entityManager.createQuery("select e from Employee e where e.employeeSalary=?1");
        query.setParameter(1, salary);
        return query.getResultList();
    }

    public List<Employee> findByDesg(String desg) {
        Query query = entityManager.createQuery("select e from Employee e where e.employeeDesg=?1");
        query.setParameter(1, desg);
        return query.getResultList();
    }

    public List<Employee> findByName(String name) {
        Query query = entityManager.createQuery("select e from Employee e where e.employeeName=?1");
        query.setParameter(1, name);
        return query.getResultList();
    }

    public List<Employee> findBySalaryInRange(double minSalary, double maxSalary) {
        Query query = entityManager.createQuery("select e from Employee e where e.employeeSalary between ?1 and ?2");
        query.setParameter(1, minSalary);
        query.setParameter(2, maxSalary);
        return query.getResultList();

    }
}
