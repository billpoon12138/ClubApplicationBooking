package iss.sa42.team8.service;

import iss.sa42.team8.model.Administrator;

public interface AdministratorService {

	Administrator authenticate(String UserID, String pwd);
}
