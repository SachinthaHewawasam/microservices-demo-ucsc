package net.saxGuides.employeeservice.service;


import net.saxGuides.employeeservice.dto.APIResponseDto;
import net.saxGuides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
