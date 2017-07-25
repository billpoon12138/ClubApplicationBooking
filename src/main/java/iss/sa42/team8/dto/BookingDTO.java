package iss.sa42.team8.dto;

import java.util.Date;

public class BookingDTO {

	private String bookingID;
	private String userID;
	private String memberName;
	private String facilityID;
	private String facilityName;
	private String bookingDate;
	private String checkoutDate;
	private int bookingSession;
	private String bookingStatus;
	private String remarks;
	
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getBookingSession() {
		return bookingSession;
	}

	public void setBookingSession(int bookingSession) {
		this.bookingSession = bookingSession;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

}
