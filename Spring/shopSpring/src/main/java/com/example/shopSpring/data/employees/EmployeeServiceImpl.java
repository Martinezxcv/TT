package com.example.shopSpring.data.employees;

import com.example.shopSpring.data.employees.mapper.EmployeeMapper;
import com.example.shopSpring.data.employees.model.Employee;
import com.example.shopSpring.data.employees.model.EmployeeDto;
import com.example.shopSpring.data.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }
    @Override
    public void addEmployee(EmployeeDto employee) {
        employeeRepository.save(employeeMapper.fromDto(employee));
    }
}
