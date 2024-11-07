package com.atuluttam.EmployeeCRUD.repository;

import com.atuluttam.EmployeeCRUD.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
