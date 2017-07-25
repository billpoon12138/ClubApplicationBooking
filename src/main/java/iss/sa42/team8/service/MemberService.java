package iss.sa42.team8.service;

import java.util.List;

import iss.sa42.team8.exception.MemberNotFoundException;
import iss.sa42.team8.model.Member;

public interface MemberService {

	public Member create(Member member);

	public Member delete(String id) throws MemberNotFoundException;

	public List<Member> findAll();

	public Member update(Member member) throws MemberNotFoundException;

	public Member findById(String id);

	public Member authenticate(String uid, String pwd);
	
	public String getLastMemberID();
	
	public String getMemberIDByMemberName(String memberName) ;
	
	public Member getMemberByEmail(String email);
}
