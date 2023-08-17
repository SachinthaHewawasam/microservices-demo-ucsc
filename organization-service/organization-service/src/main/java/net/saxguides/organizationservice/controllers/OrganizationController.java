package net.saxguides.organizationservice.controllers;

import lombok.AllArgsConstructor;
import net.saxguides.organizationservice.dto.OrganizationDto;
import net.saxguides.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return  new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String code){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
        return  new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

}
