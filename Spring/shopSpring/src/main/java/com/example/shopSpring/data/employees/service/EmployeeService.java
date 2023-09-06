package com.example.shopSpring.data.employees.service;

import com.example.shopSpring.data.employees.model.Employee;
import com.example.shopSpring.data.employees.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDto> getAllEmployees();
    public void addEmployee(EmployeeDto employee);
}
