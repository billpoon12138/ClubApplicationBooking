package iss.sa42.team8.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import iss.sa42.team8.model.Administrator;
import iss.sa42.team8.repository.AdministratorRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Resource
	private AdministratorRepository administratorRepository;
	
	@Override
	public Administrator authenticate(String UserID, String pwd) {
		return administratorRepository.findAdminByNamePwd(UserID, pwd);
	}

}
