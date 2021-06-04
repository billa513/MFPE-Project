package com.example.newhospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.newhospitalmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{
	
	@Query("from Patient where employe=:id")
	Patient selectbyEmployeId(@Param("id") String id);

}
