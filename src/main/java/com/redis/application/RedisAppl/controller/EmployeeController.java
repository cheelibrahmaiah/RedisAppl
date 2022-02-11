package com.redis.application.RedisAppl.controller;

import com.redis.application.RedisAppl.domain.Employee;
import com.redis.application.RedisAppl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("redis/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return  employeeService.saveEmployee(employee);
    }

    @GetMapping("")
    public Map<Integer, Employee> getEmployees() {
        return  employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return  employeeService.getOneEmployee(id);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return  employeeService.updateEmployee(employee);
    }

    @DeleteMapping("")
    public String deleteEmployee(@RequestParam("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted!";
    }
}
