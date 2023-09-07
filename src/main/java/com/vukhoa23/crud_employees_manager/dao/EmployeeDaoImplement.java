package com.vukhoa23.crud_employees_manager.dao;

import com.vukhoa23.crud_employees_manager.dao.EmployeeDAO;
import com.vukhoa23.crud_employees_manager.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImplement implements EmployeeDAO {
    // define entityManager
    private EntityManager entityManager;
    // set up constructor injection
    @Autowired
    public EmployeeDaoImplement(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        // execute query and get result list
        List<Employee> employees = query.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);
        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save the employee
        // id = 0 means insert/save, else update
        Employee theEmployee = entityManager.merge(employee);
        // theEmployee has the updated id from the database
        return theEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee by id
        Employee toBeRemoved =  entityManager.find(Employee.class, id);
        // remove the employee
        entityManager.remove(toBeRemoved);
    }
}
