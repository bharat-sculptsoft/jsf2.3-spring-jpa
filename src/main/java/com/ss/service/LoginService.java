package com.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.model.LoginModel;
import com.ss.repo.LoginRepo;


@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;
	
	
	@Transactional(readOnly = true)
	public List<LoginModel> findAll() {
		return this.loginRepo.findAll();
	}
	
	@Transactional
	public String save(LoginModel lm) {
		List<LoginModel> user = loginRepo.findByEmailAndPassword(lm.getEmail(),lm.getPassword());
		if(user ==null || user.isEmpty()) {
			System.out.println("user not found saving it----"+lm);

			loginRepo.save(lm);
			System.out.println("user save----"+lm);
			//System.out.println("1/0--"+1/0);
			return "";
			}
		System.out.println("user get----"+lm);
		return "dashboard";
		
	}
	

}
