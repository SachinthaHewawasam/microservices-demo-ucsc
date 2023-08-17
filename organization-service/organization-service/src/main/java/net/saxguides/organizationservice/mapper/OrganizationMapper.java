package net.saxguides.organizationservice.mapper;

import net.saxguides.organizationservice.dto.OrganizationDto;
import net.saxguides.organizationservice.enity.Organization;

public class OrganizationMapper {

    public static OrganizationDto maptoOrganizationDto(Organization organization){
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate());
        return organizationDto;
    }
    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization = new Organization(organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate());
        return organization;
    }
}
