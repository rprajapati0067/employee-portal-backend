package com.societe.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.societe.general.domain.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
