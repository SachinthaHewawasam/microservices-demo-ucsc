package net.saxguides.organizationservice.service;

import net.saxguides.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String code);
}
