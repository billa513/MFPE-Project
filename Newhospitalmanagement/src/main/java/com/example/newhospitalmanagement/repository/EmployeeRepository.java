package com.example.newhospitalmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.newhospitalmanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{

	Optional<Employee> findById(String employeeId);
	  @Query("from Employee where Role=:role")
		List<Employee> slectRecordByRole(@Param("role") String name);

}
