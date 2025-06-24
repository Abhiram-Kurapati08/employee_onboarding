package com.employee_onboarding.employee_onboarding.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_onboarding.employee_onboarding.Repository.ProspectiveEmployeeRepository;
import com.employee_onboarding.employee_onboarding.model.ProspectiveEmployee;

import java.util.List;
import java.util.Optional;

@Service
public class ProspectiveEmployeeService {

    @Autowired
    private ProspectiveEmployeeRepository repository;

    public ProspectiveEmployee saveEmployee(ProspectiveEmployee employee) {
        return repository.save(employee);
    }

    public List<ProspectiveEmployee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<ProspectiveEmployee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }

    public boolean emailExists(String email) {
        return repository.existsByEmail(email);
    }
}
