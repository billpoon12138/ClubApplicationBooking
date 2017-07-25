package iss.sa42.team8.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa42.team8.model.Administrator;
import iss.sa42.team8.model.Member;
import iss.sa42.team8.service.AdministratorService;
import iss.sa42.team8.service.MemberService;
import iss.sa42.team8.util.EmailTools;

@Controller
@RequestMapping(value = "/index")
public class LoginController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private EmailTools emailTools;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView memberListPagetest() {
		ModelAndView mav = new ModelAndView("login", "member", new Member());
		List<Member> memberList = memberService.findAll();
		// mav.addObject("memberList", memberList);
		for (Member member : memberList) {
			System.out.println(member.getMemberName());
		}

		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView memberLogout(HttpSession session) {
		
		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		ms.setMember(null);
		ms.setAdministrator(null);
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Member member, HttpSession session, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;

		String message = "";
		String welMessage = "";

		MemberSession ms = new MemberSession();
		String s = member.getUserID().substring(0, 1);
		if (s.equals(Administrator.ADMINITRATOR_PREFIX)) {
			Administrator a = administratorService.authenticate(member.getUserID(), member.getPassword());

			if (a != null) {
				ms.setAdministrator(a);

				welMessage = "Welcome" + " " + a.getAdminName();
				// PUT CODE FOR SETTING SESSION ID
				ms.setSessionId(session.getId());
				// // us.setMessage(welMessage);
				session.setAttribute("USERSESSION", ms);
				mav = new ModelAndView("redirect:/admin-index");
				return mav;
			} else {
				mav = new ModelAndView("redirect:/index/login");
				message = "Wrong email and password";
				redirectAttributes.addFlashAttribute("message", message);
				mav.addObject("WrongMessage", message);
			}
		} else {
			Member m = memberService.authenticate(member.getUserID(), member.getPassword());
			if (m != null) {
				ms.setMember(m);
				// PUT CODE FOR SETTING SESSION ID
				welMessage = "Welcome" + " " + m.getMemberName();
				ms.setSessionId(session.getId());
				session.setAttribute("USERSESSION", ms);
				mav = new ModelAndView("redirect:/member-index");
			}else{
				mav = new ModelAndView("redirect:/index/login");
				message = "Wrong email and password";
				redirectAttributes.addFlashAttribute("message", message);
				mav.addObject("WrongMessage", message);
			}
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView forgotPasswordCheck(){
		ModelAndView mav = new ModelAndView("forget");
		return mav;
	}
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView forgotPasswordSendEmail(@PathVariable String email){
//		emailTools.sendEmail(email, "code");
		ModelAndView mav = new ModelAndView("index");		
		return mav;
	}
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView SendEmail(@RequestParam("email")String email){
		Member member = memberService.getMemberByEmail(email);
		if(member != null){
			String code = "UserId : " + member.getUserID() + " , " + "password : " + member.getPassword();
			emailTools.sendEmail(member.getMemberName(), email, code);
		}
		ModelAndView mav = new ModelAndView("redirect:/index/login");		
		return mav;
	}

}
