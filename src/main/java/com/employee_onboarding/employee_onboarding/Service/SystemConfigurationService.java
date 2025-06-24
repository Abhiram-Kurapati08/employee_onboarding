package com.employee_onboarding.employee_onboarding.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Exception.RecordNotFoundException;
import com.employee_onboarding.employee_onboarding.Repository.SystemConfigurationRepo;
import com.employee_onboarding.employee_onboarding.model.SystemConfiguration;

import java.util.*;

@Service
public class SystemConfigurationService{
	@Autowired
	
    private SystemConfigurationRepo repository;
	
	 public List<SystemConfiguration> getAllConfigurations() {
	        List<SystemConfiguration> list = repository.findAll(Sort.by("configKey"));
	        return list.isEmpty() ? new ArrayList<>() : list;
	    }

	 public Page<SystemConfiguration> getConfigurationsByPage(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by("configKey"));
	        return repository.findAll(pageable);
	    }
	 
	 public SystemConfiguration getConfigById(Long id) throws RecordNotFoundException {
	        Optional<SystemConfiguration> config = repository.findById(id);
	        return config.orElseThrow(() -> new RecordNotFoundException("No configuration found for id: " + id));
	    }
	 public SystemConfiguration createOrUpdateConfig(SystemConfiguration config) {
		    return repository.save(config); // handles both create and update
		}
	 public void deleteConfigById(Long id) throws RecordNotFoundException {
		    if (!repository.existsById(id)) {
		        throw new RecordNotFoundException("No configuration found to delete with id: " + id);
		    }
		    repository.deleteById(id);
		}



}
