package iss.sa42.team8.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "booking")
public class Booking {

	public static final String BOOKED = "BOOKED";
	public static final String END = "END";
	public static final String CANCEL = "CANCEL";
	public static final String BOOKINGID_PREFIX = "B";

	@Id
	@Column(name = "bookingID")
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private String bookingID;

	@Basic
	@Column(name = "userID")
	private String userID;

	@Column(name = "facilityID")
	private String facilityID;

	@Column(name = "bookingDate")
	private Date bookingDate;

	@Column(name = "checkoutDate")
	private Date checkoutDate;

	@Column(name = "currentDate")
	private Date currentDate;

	@Column(name = "bookingStatus")
	private String bookingStatus;

	@Column(name = "remarks")
	private String remarks;

	public Booking() {
		super();
	}

	public Booking(String bookingID, String userID, String facilityID, Date bookingDate, Date checkoutDate,
			Date currentDate, String bookingStatus) {
		super();
		this.bookingID = bookingID;
		this.userID = userID;
		this.facilityID = facilityID;
		this.bookingDate = bookingDate;
		this.checkoutDate = checkoutDate;
		this.currentDate = currentDate;
		this.bookingStatus = bookingStatus;
	}

	public Booking(String bookingID, String userID, String facilityID, Date bookingDate, Date checkoutDate,
			Date currentDate, String bookingStatus, String remarks) {
		super();
		this.bookingID = bookingID;
		this.userID = userID;
		this.facilityID = facilityID;
		this.bookingDate = bookingDate;
		this.checkoutDate = checkoutDate;
		this.currentDate = currentDate;
		this.bookingStatus = bookingStatus;
		this.remarks = remarks;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
