package iss.sa42.team8.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa42.team8.exception.StudentNotFound;
import iss.sa42.team8.model.Student;
import iss.sa42.team8.service.StudentService;
import iss.sa42.team8.web.validator.StudentValidator;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentValidator studentValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(studentValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		ModelAndView mav = new ModelAndView("student-new", "student",
				new Student());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("student-new");

		ModelAndView mav = new ModelAndView();
		String message = "New student " + student.getName()
				+ " was successfully created.";

		studentService.create(student);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView studentListPage() {
		ModelAndView mav = new ModelAndView("student-list");
		List<Student> studentList = studentService.findAll();
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView studentListPageTest() {
		ModelAndView mav = new ModelAndView("student-test");
		List<Student> studentList = studentService.findAll();
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("student-edit");
		Student student = studentService.findById(id);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student,
			BindingResult result, @PathVariable Long id,
			final RedirectAttributes redirectAttributes) throws StudentNotFound {

		if (result.hasErrors())
			return new ModelAndView("student-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Student was successfully updated.";

		studentService.update(student);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws StudentNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Student student = studentService.delete(id);
		String message = "The student " + student.getName()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
