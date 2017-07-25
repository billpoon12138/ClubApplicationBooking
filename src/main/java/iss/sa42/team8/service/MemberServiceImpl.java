package iss.sa42.team8.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.exception.MemberNotFoundException;
import iss.sa42.team8.model.Member;
import iss.sa42.team8.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberRepository memberRepository;

	@Override
	@Transactional
	public Member create(Member member) {
		Member createMember = member;
		return memberRepository.save(createMember);
	}

	@Override
	@Transactional(rollbackFor=MemberNotFoundException.class)
	public Member delete(String id) throws MemberNotFoundException {
		Member deleteMember = memberRepository.findOne(id);
		if(deleteMember == null){
			throw new MemberNotFoundException();
		}
		memberRepository.delete(deleteMember);
		return deleteMember;
	}

	@Override
	@Transactional
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	@Transactional
	public Member update(Member member) throws MemberNotFoundException {
		Member updateMember = memberRepository.findOne(member.getUserID());
		if(updateMember == null){
			throw new MemberNotFoundException();
		}
		
		updateMember.setUserID(member.getUserID());
		updateMember.setPassword(member.getPassword());
		updateMember.setMembershipNo(member.getMembershipNo());
		updateMember.setMemberName(member.getMemberName());
		updateMember.setNricNo(member.getNricNo());
		updateMember.setGender(member.getGender());
		updateMember.setJoinDate(member.getJoinDate());
		updateMember.setEmail(member.getEmail());
		updateMember.setPhone(member.getPhone());
		updateMember.setRemarks(member.getRemarks());
		updateMember.setRePassword(member.getRePassword());
		
		memberRepository.flush();
		return updateMember;
	}

	@Override
	@Transactional
	public Member findById(String id) {
		return memberRepository.findOne(id);
	}

	@Override
	@Transactional
	public Member authenticate(String uid, String pwd) {
		return memberRepository.findUserByIDPwd(uid, pwd);
		
	}

	@Override
	@Transactional
	public String getLastMemberID() {
		if(memberRepository.findLastMemberID().isEmpty()){
			return Member.MEMBER_PREFIX + 10000;
		}
		return memberRepository.findLastMemberID().get(0);
	}
	
	@Override
	@Transactional
	public String getMemberIDByMemberName(String memberName) {
		return memberRepository.getIDByName(memberName);
		
	}

	@Override
	@Transactional
	public Member getMemberByEmail(String email) {
		return memberRepository.findUserByIDEmail(email);
	}

}
