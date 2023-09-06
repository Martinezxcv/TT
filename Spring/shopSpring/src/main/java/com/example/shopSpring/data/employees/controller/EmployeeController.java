package com.example.shopSpring.data.employees.controller;

import com.example.shopSpring.data.employees.model.Employee;
import com.example.shopSpring.data.employees.model.EmployeeDto;
import com.example.shopSpring.data.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public @ResponseBody Iterable<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeDto employee) {
        employeeService.addEmployee(employee);
        return "Added";
    }
}
