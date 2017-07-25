package iss.sa42.team8.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa42.team8.exception.BookingNotFoundException;
import iss.sa42.team8.model.Booking;
import iss.sa42.team8.service.BookingService;
import iss.sa42.team8.service.FacilityService;
import iss.sa42.team8.service.MemberService;
import iss.sa42.team8.util.Convertor;
import iss.sa42.team8.util.Generator;
import iss.sa42.team8.web.validator.BookingValidator;

@Controller
@RequestMapping(value = "/booking")
public class Bookingcontroller {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private Generator generator;
	
	@Autowired
	private BookingValidator bookingValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(bookingValidator);
		CustomDateEditor editor = new CustomDateEditor(new
		SimpleDateFormat("MM/dd/yyyy"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	
	@Autowired
	private Convertor convertor;
	
	//@PathVariable String userID, @PathVariable String facilityID
	@RequestMapping(value = "/create/{facilityID}", method = RequestMethod.GET)
	public ModelAndView newBookingPage(@PathVariable String facilityID, HttpSession session) {
		ModelAndView mav = new ModelAndView("booking-new", "booking",
				new Booking());
		

		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		Booking booking = new Booking();

		booking.setFacilityID(facilityID);
//		String uid = "";
		if(ms.getAdministrator() != null){
			booking.setUserID(ms.getAdministrator().getUserID());
		}else{
//			uid = ms.getMember().getUserID();
			booking.setUserID(ms.getMember().getUserID());
		}
		
		mav.addObject("booking", booking);
//		mav.addObject("userName", memberService.findById(uid).getMemberName());
//		mav.addObject("facilityName", facilityService.findById(fid).getFacilityName());
		return mav;
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking,
			BindingResult result, HttpSession session,  final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("booking-new");

		booking.setBookingID(generator.generateBookingID());
		
		ModelAndView mav = new ModelAndView();
		String message = "New booking " + booking.getBookingID()
				+ " was successfully created.";

		booking.setBookingStatus(Booking.BOOKED);
		
		booking.setCurrentDate(new Date());
		
		bookingService.create(booking);
		
		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		if(ms.getAdministrator() != null){
			mav.setViewName("redirect:/admin-index.html");
		}else{
			mav.setViewName("redirect:/member-index.html");
		}

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookingListPage(){
		ModelAndView mav = new ModelAndView("booking-list");
		List<Booking> bookingList = bookingService.findAll();
		
		mav.addObject("bookingDTOList", convertor.BookingList2BookingDTOList(bookingList));
		
		return mav;
	}
	
/*	//@PathVariable String userID
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView bookingSearchPage(){
		ModelAndView mav = new ModelAndView("booking-search");
		List<Booking> bookingList = bookingService.findByUserID("M11234");
		
		mav.addObject("bookingDTOList", convertor.BookingList2BookingDTOList(bookingList));
		
		return mav;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchBooking(@ModelAttribute @Valid Booking booking,
			BindingResult result, @PathVariable String bookingID,
			final RedirectAttributes redirectAttributes) throws BookingNotFoundException {

		if (result.hasErrors())
			return new ModelAndView("booking-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Booking was successfully updated.";

		bookingService.update(booking);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}*/
	
	//convertor.Booking2BookingDTO(
	@RequestMapping(value = "/edit/{bookingID}", method = RequestMethod.GET)
	public ModelAndView editBookingPage(@PathVariable String bookingID) throws ParseException {
		ModelAndView mav = new ModelAndView("booking-edit");
		Booking booking = bookingService.findById(bookingID);
		mav.addObject("booking", booking);
		return mav;
	}
	
	//convertor.Booking2BookingDTO(
	@RequestMapping(value = "/cancel/{bookingID}", method = RequestMethod.GET)
	public ModelAndView cancelBookingPage(@PathVariable String bookingID) throws ParseException, BookingNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:/booking/searchm");
		Booking booking = bookingService.findById(bookingID);
		booking.setBookingStatus(Booking.CANCEL);
		bookingService.update(booking);

		return mav;
	}

	@RequestMapping(value = "/edit/{bookingID}", method = RequestMethod.POST)
	public ModelAndView editBooking(@ModelAttribute @Valid Booking booking,
			BindingResult result, @PathVariable String bookingID,
			final RedirectAttributes redirectAttributes) throws BookingNotFoundException {

		if (result.hasErrors())
			return new ModelAndView("booking-edit");

		ModelAndView mav = new ModelAndView("redirect:/member-index.html");
		String message = "Booking was successfully updated.";
		
		booking.setCurrentDate(bookingService.findById(booking.getBookingID()).getCurrentDate());
		booking.setRemarks(memberService.findById(booking.getBookingID()).getRemarks());

		bookingService.update(booking);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBooking(@PathVariable String id,
			final RedirectAttributes redirectAttributes) throws BookingNotFoundException {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Booking booking = bookingService.delete(id);
		String message = "The booking " + booking.getBookingID()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	// -------------------------------------admin--------------------------------------------
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView bookingHistoryPage() {
		ModelAndView mav = new ModelAndView("booking-history", "booking", new Booking());
		List<String> statusList = new ArrayList<String>();
		statusList.add("Please Select");
		statusList.add("BOOKED");
		statusList.add("CANCEL");
		statusList.add("END");
		mav.addObject("statusList", statusList);
		List<Booking> bookingList = bookingService.findAll();
		mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
		return mav;
	}

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public ModelAndView bookingHistoryPage(@ModelAttribute Booking booking, @RequestParam("userID") String memberName,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam String bookingStatus, BindingResult result, final RedirectAttributes redirectAttributes)
			throws BookingNotFoundException {
		ModelAndView mav = new ModelAndView("booking-history", "booking", new Booking());
		List<String> statusList = new ArrayList<String>();
		statusList.add("Please Select");
		statusList.add("BOOKED");
		statusList.add("CANCEL");
		statusList.add("END");
		mav.addObject("statusList", statusList);

		if (!memberName.isEmpty()) {
			String userID = memberService.getMemberIDByMemberName(memberName.toLowerCase());
			if (startDate != null && endDate != null) {
				if (bookingStatus.equals("Please Select")) {
					List<Booking> bookingList = bookingService.findByUserIDAndDateRange(userID, startDate, endDate);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				} else {
					List<Booking> bookingList = bookingService.findByUserIDAndDateRangeAndStatus(userID, startDate,
							endDate, bookingStatus);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				}
				return mav;
			} else if (startDate == null && endDate == null) {
				if (bookingStatus != "Please Select") {
					List<Booking> bookingList = bookingService.findByUserIDAndStatus(userID, bookingStatus);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				}
				return mav;
			} else {
				List<Booking> bookingList = bookingService.findAll();
				mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				return mav;
			}

		} else {
			if (startDate != null && endDate != null) {
				if (bookingStatus.equals("Please Select")) {
					List<Booking> bookingList = bookingService.findByDateRange(startDate, endDate);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				} else {
					List<Booking> bookingList = bookingService.findByDateRangeAndStatus(startDate, endDate,
							bookingStatus);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				}
				return mav;
			} else if (startDate == null && endDate == null) {
				if (!bookingStatus.equals("Please Select")) {
					List<Booking> bookingList = bookingService.findByStatus(bookingStatus);
					mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				}
				return mav;
			} else {
				List<Booking> bookingList = bookingService.findAll();
				mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
				return mav;
			}
		}
	}

	// ----------------*********************************---------------------------
	@RequestMapping(value = "/searchm", method = RequestMethod.GET)
	public ModelAndView bookingSearchPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("booking-searchm", "booking", new Booking());
//		Member m = new Member();
//		m.setUserID("M13214");

//		mav.addObject("userName", m.getUserID());
		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		Booking booking = new Booking();
		if(ms.getAdministrator() != null){
			booking.setUserID(ms.getAdministrator().getUserID());
		}else{
			booking.setUserID(ms.getMember().getUserID());
		}

		List<Booking> membooking = bookingService.findByUserID(booking.getUserID());
		mav.addObject("bookingList", convertor.BookingList2BookingDTOList(membooking));
		mav.addObject("booking", booking);
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("Please Select");
		statusList.add("BOOKED");
		statusList.add("CANCEL");
		statusList.add("END");
		mav.addObject("statusList", statusList);
		// List<Booking> bookingList = bookingService.findAll();
		// mav.addObject("bookingList",
		// convertor.BookingList2BookingDTOList(bookingList));
		return mav;
	}

	@RequestMapping(value = "/searchm", method = RequestMethod.POST)
	public ModelAndView bookingSearchPage(@ModelAttribute Booking booking, @RequestParam("userID") String userID,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate, HttpSession session,
			@RequestParam String bookingStatus, BindingResult result, final RedirectAttributes redirectAttributes)
			throws BookingNotFoundException {
		ModelAndView mav = new ModelAndView("booking-searchm", "booking", new Booking());
		MemberSession ms = (MemberSession) session.getAttribute("USERSESSION");
		if(ms.getAdministrator() != null){
			booking.setUserID(ms.getAdministrator().getUserID());
		}else{
			booking.setUserID(ms.getMember().getUserID());
		}
		List<Booking> membooking = bookingService.findByUserID(booking.getUserID());
		mav.addObject("bookingList", convertor.BookingList2BookingDTOList(membooking));
		mav.addObject("booking", booking);
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("Please Select");
		statusList.add("BOOKED");
		statusList.add("CANCEL");
		statusList.add("END");
		mav.addObject("statusList", statusList);

		if (startDate != null && endDate != null) {
			if (bookingStatus.equals("Please Select")) {
				List<Booking> bookingList = bookingService.findByUserIDAndDateRange(userID, startDate, endDate);
				mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
			} else {
				List<Booking> bookingList = bookingService.findByUserIDAndDateRangeAndStatus(userID, startDate, endDate,
						bookingStatus);
				mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
			}
			return mav;
		} else if (startDate == null && endDate == null) {
			if (bookingStatus != "Please Select") {
				List<Booking> bookingList = bookingService.findByUserIDAndStatus(userID, bookingStatus);
				mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
			}
			return mav;
		} else {
			List<Booking> bookingList = bookingService.findAll();
			mav.addObject("bookingList", convertor.BookingList2BookingDTOList(bookingList));
			return mav;
		}
	}

}
