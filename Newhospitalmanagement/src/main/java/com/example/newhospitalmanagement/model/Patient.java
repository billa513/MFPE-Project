package com.example.newhospitalmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient {
	
	@Id
	public String id;
	
	@NotBlank(message = "Name is mandatory")
	private String firstName;
	
	@NotBlank(message = "Name is mandatory")
	private String lastName;
	
	@NotBlank
	private String gender;
	
	@NotBlank(message = "Date of Birth is mandatory")
	private String dateOfBirth;
	
	@NotNull
	private int age;
	
	@NotBlank
	private String problem;
	
	@NotNull
	private long phoneNumber;
	
	@Email(message = "Enter a valid email address.")
    @NotBlank
	private String emailId;
	
	@NotBlank(message = "Address is mandatory")
	private String address;
	
	@NotNull
	@Min(111111) @Max(999999)
	private int pincode;
	
	@NotBlank(message = "city is mandatory")
	private String city;
	
	@NotBlank(message = "State is mandatory")
	private String state;
	
	@Column(unique=true)
	@Size(min = 12, max = 12)
	private long aadharNo;
	
	private String bloodGroup;
	
	Patient() {
		
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", problem=" + problem + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", aadharNo=" + aadharNo + "]";
	}

	
	
	
}
