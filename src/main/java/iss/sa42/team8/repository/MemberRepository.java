package iss.sa42.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa42.team8.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query("SELECT m FROM Member m WHERE m.userID=:uid AND m.password=:pwd")
	Member findUserByIDPwd(@Param("uid") String uname, @Param("pwd") String pwd);
	
	@Query("SELECT m.userID FROM Member m ORDER BY m.userID DESC")
	ArrayList<String> findLastMemberID();
	
	@Query("select m.userID from Member m where lower(m.memberName)= :memberName")
	String getIDByName(@Param("memberName") String memberName);
	
	@Query("SELECT m FROM Member m WHERE m.email=:uemail")
	Member findUserByIDEmail(@Param("uemail") String uemail);
	
}
