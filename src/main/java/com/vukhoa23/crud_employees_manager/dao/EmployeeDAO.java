package com.vukhoa23.crud_employees_manager.dao;

import com.vukhoa23.crud_employees_manager.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
