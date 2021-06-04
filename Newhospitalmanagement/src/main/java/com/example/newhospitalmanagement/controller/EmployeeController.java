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
import com.example.newhospitalmanagement.model.Employee;
import com.example.newhospitalmanagement.model.Login;
import com.example.newhospitalmanagement.repository.EmployeeRepository;
import com.example.newhospitalmanagement.repository.LoginRepository;

@RestController
@RequestMapping("/api/v1")

public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoginRepository login;
	
	@GetMapping("/employees")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employess/doctor")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Employee> getAllByRole(){
		return employeeRepository.slectRecordByRole("Doctor");
	}
	
	@PostMapping("/employees")
	@CrossOrigin(origins="http://localhost:4200")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		Employee emp=employeeRepository.save(employee);
		String id=emp.getId();
		String username=emp.getId();
		String password = String.valueOf(emp.getAadharNo());
		String role=emp.getRole();
		Login l=new Login(id,role,username,password);
		login.save(l);
		System.out.println(l);
		return  emp;
	}
	
	@GetMapping("/employees/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId) throws ResourseNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourseNotFoundException("Employee Not Found for this id:" + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping("/employees/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String employeeId, @RequestBody Employee employeeDetails) throws ResourseNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourseNotFoundException("Employee Not Found for this id:" + employeeId));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setAge(employeeDetails.getAge());
		employee.setGender(employeeDetails.getGender());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		employee.setEmailid(employeeDetails.getEmailid());
		employee.setEducationalQualification(employeeDetails.getEducationalQualification());
		employee.setSpecialization(employeeDetails.getSpecialization());
		employee.setRole(employeeDetails.getRole());
		employee.setAddress(employeeDetails.getAddress());
		employee.setPincode(employeeDetails.getPincode());
		employee.setCity(employeeDetails.getCity());
		employee.setState(employeeDetails.getState());
		employee.setAadharNo(employeeDetails.getAadharNo());
		employee.setPanCardNo(employeeDetails.getPanCardNo());
		employeeRepository.save(employee);
		return ResponseEntity.ok().body(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String employeeId) throws ResourseNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourseNotFoundException("Employee Not Found for this id:" + employeeId));
		
		employeeRepository.deleteById(employeeId);
		return ResponseEntity.ok().build();
	}
	
	

}
