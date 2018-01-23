package com.coviam.payment_service.repository;

import com.coviam.payment_service.model.BusinessConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessConfigRepository extends JpaRepository<BusinessConfig,Long> {
}
