package com.example.shopSpring.data.employees.mapper;

import com.example.shopSpring.data.employees.model.Employee;
import com.example.shopSpring.data.employees.model.EmployeeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee source);
    List<EmployeeDto> toDtoList(List<Employee> source);
    Employee fromDto(EmployeeDto destination);
}
