package com.immune.tienda.service;

import com.immune.tienda.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {	
	@Autowired
	private LoginRepository loginRepository;

	//Devuelve la contraseña de un usuario a partir de su email.
    public String getPassByMail(String mail) {	
		return loginRepository.getPassByMail(mail);
	}
	//Devuelve el RolId de un usuario a partir de su email.
	public Integer getRolByMail(String mail) {	
		return loginRepository.getRolByMail(mail);
	}

}