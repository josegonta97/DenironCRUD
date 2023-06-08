package com.deniron.DenironCRUD.repository;

import com.deniron.DenironCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //crud methods
}
