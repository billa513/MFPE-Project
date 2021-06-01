package com.example.newhospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newhospitalmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{

}
