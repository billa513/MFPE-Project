package com.example.newhospitalmanagement.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	private String id;
	
	@Column(name = "first_name")
	@NotBlank(message = "Name is mandatory")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Name is mandatory")
	private String lastName;
	
	@NotBlank
	private String gender;
	
	@Column(name = "date_of_Birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@Column(name = "age")
	@NotNull
	private int age;
	
	@Column(name = "phone_number")
	@NotNull
	private Long phoneNumber;
	
	@Column(name = "email")
	@Email(message = "Enter a valid email address.")
    @NotBlank
	private String emailid;
	
	@Column(name = "Qualification")
	@NotBlank(message = "Educational Qualification is mandatory")
	private String educationalQualification;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "role")
	private String Role;
	
	@Column(name = "address")
	@NotBlank(message = "Address is mandatory")
	private String address;
	
	@Min(111111) @Max(999999) 
	@NotNull
	private int pincode;
	
	@Column(name = "city")
	@NotBlank(message = "city is mandatory")
	private String city;
	
	@Column(name = "state")
	@NotBlank(message = "State is mandatory")
	private String state;
	
	@Column(unique=true)
	@Min(111111111111L) @Max(999999999999L) 
	private long aadharNo;
	
	@Column(unique=true)
	private String panCardNo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employe",fetch=FetchType.EAGER)
	   private List<Patient> patients;
	
	@JsonManagedReference
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Employee() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", phoneNumber=" + phoneNumber + ", emailid="
				+ emailid + ", educationalQualification=" + educationalQualification + ", specialization="
				+ specialization + ", Role=" + Role + ", address=" + address + ", pincode=" + pincode + ", city=" + city
				+ ", state=" + state + ", aadharNo=" + aadharNo + ", panCardNo=" + panCardNo + ", patients=" + patients
				+ "]";
	}

	
	
}
