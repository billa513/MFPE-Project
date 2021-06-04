package com.example.newhospitalmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newhospitalmanagement.exception.ResourseNotFoundException;
import com.example.newhospitalmanagement.model.Patient;
import com.example.newhospitalmanagement.repository.EmployeeRepository;
import com.example.newhospitalmanagement.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/patients")
	@CrossOrigin(origins="http://localhost:4200/")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	@PostMapping("/patients")
	@CrossOrigin(origins="http://localhost:4200/")
	public Patient createPatient(@Valid @RequestBody Patient patient) {
		System.out.println(patient);
		return patientRepository.save(patient);
	}
	
	@PostMapping("/patients/doctorId/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	public Patient createPatient1(@PathVariable String id,@Valid @RequestBody Patient patient) {
		patient.setEmploye(repo.getById(id));
		return patientRepository.save(patient);
	}
	@GetMapping("/patients/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") String patientId) throws ResourseNotFoundException {
		Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourseNotFoundException("Patient Not Found for this id:" + patientId));
		return ResponseEntity.ok().body(patient);
	}
	
	@PutMapping("/patients/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") String patientId, @RequestBody Patient patientDetails) throws ResourseNotFoundException {
		Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourseNotFoundException("Patient Not Found for this id:" + patientId));
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		//employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		patient.setAge(patientDetails.getAge());
		patient.setPhoneNumber(patientDetails.getPhoneNumber());
		patient.setEmailId(patientDetails.getEmailId());
//		patient.setEducationalQualification(employeeDetails.getEducationalQualification());
//		patient.setSpecialization(employeeDetails.getSpecialization());
		//patient.setRole(patientDetails.getRole());
		patient.setAddress(patientDetails.getAddress());
		patient.setCity(patientDetails.getCity());
		patient.setState(patientDetails.getState());
		//patient.setUserName(patientDetails.getUserName());
		//patient.setPassword(patientDetails.getPassword());
		patient.setAadharNo(patientDetails.getAadharNo());
		//patient.setPanCardNo(employeeDetails.getPanCardNo());
		patientRepository.save(patient);
		return ResponseEntity.ok().body(patient);
	}
	
	@DeleteMapping("/patients/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	public ResponseEntity<?> deletePatient(@PathVariable(value = "id") String patientId) throws ResourseNotFoundException {
		Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourseNotFoundException("Patient Not Found for this id:" + patientId));
		
		patientRepository.deleteById(patientId);
		return ResponseEntity.ok().build();
	}
	
	

}
