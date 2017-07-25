package iss.sa42.team8.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {


	@RequestMapping(value = "/about",  method = RequestMethod.GET)
    public String displayAbout(Model model) {
		return "about";
	}
	@RequestMapping(value = "/contact",  method = RequestMethod.GET)
    public String displayContact(Model model) {
		return "contact";
	}
	@RequestMapping(value = {"/", "/index","/member-index","/admin-index"},  method = RequestMethod.GET)
    public String displayIndex(Model model) {
		return "index";
	}
	@RequestMapping(value = {"/forget-password"},  method = RequestMethod.GET)
    public String displayForgetPassword(Model model) {
		return "forget-password";
	}
}
