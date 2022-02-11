package com.redis.application.RedisAppl.service;

import com.redis.application.RedisAppl.domain.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class EmployeeService {

    private final String hashReference= "Employee";

    @Resource(name = "redisTemplate")
    HashOperations<String, Integer, Employee> redisOperations;

    public Employee saveEmployee(Employee emp) {
        redisOperations.putIfAbsent(hashReference, emp.getId(), emp);
        return  getOneEmployee(emp.getId());
    }

    public void saveAllEmployees(Map<Integer, Employee> map) {
        redisOperations.putAll(hashReference, map);
    }

    public Employee getOneEmployee(Integer id) {
        return redisOperations.get(hashReference, id);
    }

    public Map<Integer, Employee> getAllEmployees() {
        return redisOperations.entries(hashReference);
    }

    public Employee updateEmployee(Employee emp) {
        redisOperations.put(hashReference, emp.getId(), emp);
        return getOneEmployee(emp.getId());
    }

    public void deleteEmployee(Integer id) {
        redisOperations.delete(hashReference, id);
    }

}
