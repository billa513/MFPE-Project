package com.example.newhospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newhospitalmanagement.model.Login;
import com.example.newhospitalmanagement.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
    private LoginRepository login;
	
	
//	public Login fectByUsernameAndpass(String userName,String password,String role) {
//		   String l1=login.findByRole(role);
//		   if(l1!=null) {
//			return  login.findByUserNameAndPassword(userName, password);
//		   }
//		  return null;
//	}
	
	public Login fectByUsernameAndpass(String userName,String password,String role) {
		  return login.findByUserNameAndPasswordAndRole(userName, password, role);
	}
	
}
