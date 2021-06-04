package com.example.newhospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.newhospitalmanagement.model.Login;


public interface LoginRepository extends JpaRepository<Login,String> {
  
 Login findByUserNameAndPassword(String userName,String password);


 Login findByUserNameAndPasswordAndRole(String userName,String password,String role);
}
