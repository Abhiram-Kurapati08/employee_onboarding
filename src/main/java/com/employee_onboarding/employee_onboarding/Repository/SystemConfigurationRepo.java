package com.employee_onboarding.employee_onboarding.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_onboarding.employee_onboarding.model.SystemConfiguration;

import java.util.Optional;
import java.util.List;

@Repository
public interface SystemConfigurationRepo extends JpaRepository<SystemConfiguration, Long> {

    Optional<SystemConfiguration> findByConfigKey(String configKey);

    List<SystemConfiguration> findByIsActiveTrue();
    List<SystemConfiguration> findByDataType(String dataType);

    boolean existsByConfigKey(String configKey);
}

