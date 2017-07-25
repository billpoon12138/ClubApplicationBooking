package iss.sa42.team8.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa42.team8.model.Booking;

@Component
public class BookingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Booking booking = (Booking) target;
		
//		ValidationUtils.rejectIfEmpty(errors, "userID", "booking.userID.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookingDate", "From Date is required.");
	}

}
