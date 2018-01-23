package com.coviam.payment_service.repository;

import com.coviam.payment_service.model.ProviderConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends JpaRepository<ProviderConfig,Long> {

}