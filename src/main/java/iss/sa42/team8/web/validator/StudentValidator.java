package iss.sa42.team8.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa42.team8.model.Student;

@Component
public class StudentValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		if (student.getFee()>300) {
			//Adde
		}
		ValidationUtils.rejectIfEmpty(errors, "name", "student.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "nick", "student.nick.empty");
		
	
		
	}

}
