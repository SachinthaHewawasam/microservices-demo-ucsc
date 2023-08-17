package net.saxGuides.employeeservice.controller;

import net.saxGuides.employeeservice.dto.APIResponseDto;
import net.saxGuides.employeeservice.dto.EmployeeDto;
import net.saxGuides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{empId}")
    public ResponseEntity<APIResponseDto> getDepartment(@PathVariable("empId") Long empId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
