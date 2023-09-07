package com.vukhoa23.crud_employees_manager.rest;

import com.vukhoa23.crud_employees_manager.dao.EmployeeDAO;
import com.vukhoa23.crud_employees_manager.dao.EmployeeDaoImplement;
import com.vukhoa23.crud_employees_manager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private EmployeeDAO dao;
    @Autowired
    MyRestController(EmployeeDAO dao){
        this.dao = dao;
    }

    @GetMapping("/employees")
    List<Employee> findAll(){
        List<Employee> employees = dao.findAll();
        return employees;
    }
}
