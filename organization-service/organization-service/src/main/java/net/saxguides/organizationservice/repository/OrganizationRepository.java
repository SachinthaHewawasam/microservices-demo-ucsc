package net.saxguides.organizationservice.repository;

import net.saxguides.organizationservice.enity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository  extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String code);
}
