package iss.sa42.team8.model;
// Generated 3 Jun, 2016 11:59:38 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Administrator generated by hbm2java
 */

@Entity
@Table(name = "administrator")
public class Administrator {

	public static final String ADMINITRATOR_PREFIX = "A";
	
	@Id
	@Column(name = "userID")
	private String userID;
	
	@Column(name = "adminName")
	private String adminName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "rePassword")
	private String rePassword;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "nricNo")
	private String nricNo;
	
	@Column(name = "joinDate")
	private Date joinDate;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "remarks")
	private String remarks;

	public Administrator() {
	}

	public Administrator(String userID, String adminName, String password, String rePassword, String gender,
			String nricNo, Date joinDate, String phone, String email) {
		super();
		this.userID = userID;
		this.adminName = adminName;
		this.password = password;
		this.rePassword = rePassword;
		this.gender = gender;
		this.nricNo = nricNo;
		this.joinDate = joinDate;
		this.phone = phone;
		this.email = email;
	}

	public Administrator(String userID, String adminName, String password, String rePassword, String gender,
			String nricNo, Date joinDate, String phone, String email, String remarks) {
		super();
		this.userID = userID;
		this.adminName = adminName;
		this.password = password;
		this.rePassword = rePassword;
		this.gender = gender;
		this.nricNo = nricNo;
		this.joinDate = joinDate;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNricNo() {
		return nricNo;
	}

	public void setNricNo(String nricNo) {
		this.nricNo = nricNo;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
