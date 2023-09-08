package com.vukhoa23.crud_employees_manager.rest;

import com.vukhoa23.crud_employees_manager.entity.Employee;
import com.vukhoa23.crud_employees_manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private EmployeeService employeeService;
    @Autowired
    MyRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    List<Employee> findAll(){
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee doesn't exists");
        }
        return employee;
    }

    // add mapping for adding an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // in case the user add id in the json, set the id to zero
        // setting the id to zero force the employee to be added not to be updated
        employee.setId(0);
        Employee saved = employeeService.save(employee);
        // return the saved employee which has a updated ID
        return saved;
    }

    // add mapping for update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updated = employeeService.save(employee);
        // return updated employee
        return updated;
    }

    // add mapping for deleting a employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee toBeRemoved = employeeService.findById(employeeId);

        if(toBeRemoved == null){
            throw new RuntimeException("Employee doesn't exists");
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee with id " + employeeId;
    }
}
