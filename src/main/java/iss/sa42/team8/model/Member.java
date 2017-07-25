package iss.sa42.team8.model;
// Generated 3 Jun, 2016 11:59:38 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Member generated by hbm2java
 */

@Entity
public class Member implements java.io.Serializable {

	public static final String MEMBER_PREFIX = "M";
	public static final String MEMBER_SHIPNUMBER = "CAB";
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String userID;
	@Column(name = "membershipNo")
	private String membershipNo;
	@Column(name = "memberName")
	private String memberName;
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

	public Member() {
	}

	public Member(String userId, String membershipNo, String name, String password, String nric, Date joinDate,
			String phone, String email) {
		this.userID = userId;
		this.membershipNo = membershipNo;
		this.memberName = name;
		this.password = password;
		this.nricNo = nric;
		this.joinDate = joinDate;
		this.phone = phone;
		this.email = email;
	}

	public Member(String userId, String membershipNo, String name, String password, String nric, Date joinDate,
			String phone, String email, String remarks) {
		this.userID = userId;
		this.membershipNo = membershipNo;
		this.memberName = name;
		this.password = password;
		this.nricNo = nric;
		this.joinDate = joinDate;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getNricNo() {
		return nricNo;
	}

	public void setNricNo(String nricNo) {
		this.nricNo = nricNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMembershipNo() {
		return this.membershipNo;
	}

	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}