package iss.sa42.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa42.team8.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, String>{
	
	@Query("SELECT a FROM Administrator a WHERE a.userID=:userID AND a.password=:pwd")
	Administrator findAdminByNamePwd(@Param("userID") String UserID, @Param("pwd") String pwd);
}
