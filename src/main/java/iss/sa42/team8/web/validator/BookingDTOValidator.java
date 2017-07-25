package iss.sa42.team8.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa42.team8.dto.BookingDTO;

@Component
public class BookingDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookingDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookingDTO bookingDTO = (BookingDTO) target;
		
//		ValidationUtils.rejectIfEmpty(errors, "userID", "bookingDTO.userID.empty");
	}

}
