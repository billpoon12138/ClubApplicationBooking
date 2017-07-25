package iss.sa42.team8.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.sa42.team8.dto.BookingDTO;
import iss.sa42.team8.model.Booking;
import iss.sa42.team8.model.Facility;
import iss.sa42.team8.service.BookingService;
import iss.sa42.team8.service.CategoryService;
import iss.sa42.team8.service.FacilityService;
import iss.sa42.team8.service.MemberService;

@Service
public class Convertor {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private CategoryService categoryService;
	
	public BookingDTO Booking2BookingDTO(Booking booking){
		BookingDTO bookingDTO = new BookingDTO();
		System.out.println(booking.getBookingID());
		System.out.println(booking.getUserID());
		System.out.println(memberService.findById(booking.getUserID()));
		bookingDTO.setBookingID(booking.getBookingID());
		bookingDTO.setMemberName(memberService.findById(booking.getUserID()).getMemberName());
		bookingDTO.setFacilityName(facilityService.findById(booking.getFacilityID()).getFacilityName());
		bookingDTO.setBookingDate(new SimpleDateFormat("dd/MM/yyyy").format(booking.getBookingDate()));
		bookingDTO.setCheckoutDate(new SimpleDateFormat("dd/MM/yyyy").format(booking.getCheckoutDate()));
		bookingDTO.setBookingStatus(booking.getBookingStatus());
		bookingDTO.setRemarks(booking.getRemarks());
		
		return bookingDTO;
	}
	
	public List<BookingDTO> BookingList2BookingDTOList(List<Booking> bookingList){
		List<BookingDTO> bookingDTOList = new ArrayList<BookingDTO>();
		
		for(Booking booking : bookingList){
			bookingDTOList.add(Booking2BookingDTO(booking));
		}
		
		return bookingDTOList;
	}
	
	public List<Facility> facilityID2Name(List<Facility> facilities){
		List<Facility> facilityList = new ArrayList<Facility>();
		for(Facility facility : facilities){
			facility.setCategoryID(categoryService.getCategoryNameByID(facility.getCategoryID()));
			facilityList.add(facility);
		}
		return facilityList;
	}

}
