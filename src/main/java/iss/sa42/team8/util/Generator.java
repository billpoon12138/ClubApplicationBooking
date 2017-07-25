package iss.sa42.team8.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.sa42.team8.model.Booking;
import iss.sa42.team8.model.Facility;
import iss.sa42.team8.model.Member;
import iss.sa42.team8.service.BookingService;
import iss.sa42.team8.service.FacilityService;
import iss.sa42.team8.service.MemberService;

@Service
public class Generator {
	
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private FacilityService facilityService;
	
	
	
	public String generateBookingID(){
		return Booking.BOOKINGID_PREFIX + (Integer.parseInt(bookingService.getLastBookingID()
					.substring(bookingService.getLastBookingID().indexOf(Booking.BOOKINGID_PREFIX) + 1, 
							bookingService.getLastBookingID().length()))+ 1);
	}

	public String generateFacilityID() {
		return Facility.FACILITY_PREFIX + (Integer.parseInt(facilityService.getLastFacilityID()
				.substring(facilityService.getLastFacilityID().indexOf(Facility.FACILITY_PREFIX) + 1, 
						facilityService.getLastFacilityID().length()))+ 1);
	}
	
	public String generateMemberID(){
		return Member.MEMBER_PREFIX + (Integer.parseInt(memberService.getLastMemberID()
				.substring(memberService.getLastMemberID().indexOf(Member.MEMBER_PREFIX) + 1, 
						memberService.getLastMemberID().length()))+ 1);
	}
	
	public String generateMemberShipNumber(){
		String lastMemberShipNumber = memberService.findById(memberService.getLastMemberID()).getMembershipNo();
		return Member.MEMBER_SHIPNUMBER + (Integer.parseInt(lastMemberShipNumber
				.substring(lastMemberShipNumber.indexOf(Member.MEMBER_SHIPNUMBER) + Member.MEMBER_SHIPNUMBER.length(), 
						lastMemberShipNumber.length()))+ 1);
	}

}
