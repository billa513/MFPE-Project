package com.example.newhospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.newhospitalmanagement.model.Login;
import com.example.newhospitalmanagement.repository.PatientRepository;
import com.example.newhospitalmanagement.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService service;

	@Autowired
 private PatientRepository repo;
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public Login loginUser1(@RequestBody Login login1) throws Exception {
		//System.out.println("patientdata:"+repo.selectbyEmployeId("EMP100"));
		 Login userObj=null;
		String tempUser=login1.getUserName();
		String tempPass=login1.getPassword();
		String tempRole=login1.getRole();
		if(tempUser!= null && tempPass!=null && tempRole!=null) {
		 userObj=service.fectByUsernameAndpass(tempUser,tempPass,tempRole);
		}
		if(userObj==null) {
			//throw new Exception("Bad credentials");
			return null;
		}
		return userObj;
				
	}

}
