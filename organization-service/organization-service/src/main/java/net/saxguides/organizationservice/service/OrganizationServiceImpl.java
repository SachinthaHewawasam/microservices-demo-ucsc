package net.saxguides.organizationservice.service;

import lombok.AllArgsConstructor;
import net.saxguides.organizationservice.dto.OrganizationDto;
import net.saxguides.organizationservice.enity.Organization;
import net.saxguides.organizationservice.mapper.OrganizationMapper;
import net.saxguides.organizationservice.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization( OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.maptoOrganizationDto(savedOrganization);
    }
    public OrganizationDto getOrganizationByCode( String code) {

        Organization organization = organizationRepository.findByOrganizationCode(code);
        OrganizationDto organizationDto = OrganizationMapper.maptoOrganizationDto(organization);
        return organizationDto;
    }

}