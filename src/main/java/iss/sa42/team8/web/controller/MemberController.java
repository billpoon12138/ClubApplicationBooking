package iss.sa42.team8.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa42.team8.exception.MemberNotFoundException;
import iss.sa42.team8.model.Administrator;
import iss.sa42.team8.model.Member;
import iss.sa42.team8.service.AdministratorService;
import iss.sa42.team8.service.MemberService;
import iss.sa42.team8.util.Generator;
import iss.sa42.team8.web.validator.MemberValidator;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private Generator generator;
	
/*	@Autowired
	private MemberValidator memberValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(memberValidator);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");   
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);  
        binder.registerCustomEditor(Date.class, dateEditor); 
	}*/
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView memberListPage(){
		ModelAndView mav = new ModelAndView("member-list");
		List<Member> memberList = memberService.findAll();
		mav.addObject("memberList", memberList);
		for(Member member : memberList){
			System.out.println(member.getMemberName());
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView memberListPagetest(){
		ModelAndView mav = new ModelAndView("login", "member", new Member());
		List<Member> memberList = memberService.findAll();
//		mav.addObject("memberList", memberList);
		for(Member member : memberList){
			System.out.println(member.getMemberName());
		}
		
		return mav;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView logic() {
//		ModelAndView mav = new ModelAndView("login1");
//		return mav;
//	}
	
/*	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Member member, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		
		String message = "";
		String welMessage = "";
		MemberSession ms = new MemberSession();
		
		String s = member.getUserID().substring(0, 1);
		
		if(s.equals(Administrator.ADMINITRATOR_PREFIX)){
			Administrator a = administratorService.authenticate(member.getUserID(), member.getPassword());

			if (a != null) {
				ms.setAdministrator(a);
				mav = new ModelAndView("Admin");
				welMessage = "Welcome" + " "+a.getAdminName();
				// PUT CODE FOR SETTING SESSION ID
				ms.setSessionId(session.getId());
//	//			us.setMessage(welMessage);
				session.setAttribute("USERSESSION", ms);				
				mav = new ModelAndView("redirect:/admin/");
				return mav;

			}else{
				mav = new ModelAndView("redirect:/home/login");
				message = "Wrong email and password";
				redirectAttributes.addFlashAttribute("message", message);
			}
			
			else {
				//if(admin.getLoginId()==null && admin.getPassword()==null)
				mav = new ModelAndView("redirect:/home/login");
				message = "Wrong email and password";
				redirectAttributes.addFlashAttribute("message", message);
			}
		}
		
		if (member.getUserID()!= null && member.getPassword() != null) {
			Member m = memberService.authenticate(member.getUserID(), member.getPassword());
			ms.setMember(m);
			// PUT CODE FOR SETTING SESSION ID
			ms.setSessionId(session.getId());
//			us.setEmployee(eService.findEmployeeById(us.getMember().getEmployeeId()));
//			ArrayList<Employee> subordinates = eService.findSubordinates(us.getMember().getEmployeeId());
//			if (subordinates != null) {
//				us.setSubordinates(subordinates);
//
//			}
			mav = new ModelAndView("redirect:/member-index");
		} else {
			return mav;
		}
		session.setAttribute("MEMBERSESSION", ms);
		return mav;
	}*/
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newMemberPage() {
		ModelAndView mav = new ModelAndView("member-new", "member",
				new Member());
		
//		Member member = new Member();
//
//		mav.addObject("member", member);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewMember(@ModelAttribute @Valid Member member, HttpSession session,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("member-new");

		member.setUserID(generator.generateMemberID());
		
		ModelAndView mav = new ModelAndView();
		String message = "New booking " + member.getUserID()
				+ " was successfully created.";
		
		member.setMembershipNo(generator.generateMemberShipNumber());
		
		
		
		memberService.create(member);
		
		MemberSession ms = new MemberSession();
		ms.setMember(member);
		String welMessage = "Welcome" + " " + member.getMemberName();
		ms.setSessionId(session.getId());
		session.setAttribute("USERSESSION", ms);
		mav.addObject("welMessage", welMessage);
		mav.setViewName("redirect:/member-index");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.GET)
	public ModelAndView editMemberPage(@PathVariable String userID) {
		ModelAndView mav = new ModelAndView("member-edit");
		Member member = memberService.findById(userID);
		mav.addObject("member", member);
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editMemberInfomation(HttpSession session) {
		ModelAndView mav = new ModelAndView("member-edit");
		
		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		
		Member member = memberService.findById(ms.getMember().getUserID());
		mav.addObject("member", member);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.POST)
	public ModelAndView editMember(@ModelAttribute @Valid Member member,
			BindingResult result, @PathVariable String userID,
			final RedirectAttributes redirectAttributes) throws MemberNotFoundException {

		if (result.hasErrors())
			return new ModelAndView("member-edit");

		ModelAndView mav = new ModelAndView("redirect:/member-index");
		String message = "Member was successfully updated.";
		
		member.setMembershipNo(memberService.findById(member.getUserID()).getMembershipNo());

		memberService.update(member);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{userID}", method = RequestMethod.GET)
	public ModelAndView deleteMember(@PathVariable String userID,
			final RedirectAttributes redirectAttributes) throws MemberNotFoundException {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Member member = memberService.delete(userID);
		String message = "The member " + member.getUserID()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}



}
