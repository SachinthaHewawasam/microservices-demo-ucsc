package net.saxGuides.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmenDto departmenDto;
    private OrganizationDto organizationDto;
}
