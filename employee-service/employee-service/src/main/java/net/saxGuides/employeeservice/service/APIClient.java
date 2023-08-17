package net.saxGuides.employeeservice.service;

import net.saxGuides.employeeservice.dto.DepartmenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmenDto getDepartment(@PathVariable("department-code") String departmentCode);
}
