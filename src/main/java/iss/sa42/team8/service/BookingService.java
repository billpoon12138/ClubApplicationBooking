package iss.sa42.team8.service;

import java.util.Date;
import java.util.List;

import iss.sa42.team8.exception.BookingNotFoundException;
import iss.sa42.team8.model.Booking;

public interface BookingService {

	public Booking create(Booking booking);

	public Booking delete(String id) throws BookingNotFoundException;

	public List<Booking> findAll();

	public Booking update(Booking booking) throws BookingNotFoundException;

	public Booking findById(String id);

	public List<Booking> findByUserID(String userID);
	
	public List<Booking> findByFacilityID(String facilityID);
	
	public List<Booking> findByStatus(String status);
	
	public String getLastBookingID();
	
	public List<Booking>findByDateRange(Date startDate,Date endDate)throws BookingNotFoundException;
	
	public List<Booking>findByDateRangeAndStatus(Date startDate,Date endDate,String bookingStatus)throws BookingNotFoundException;

	public List<Booking>findByUserIDAndDateRange(String userID,Date startDate,Date endDate)throws BookingNotFoundException;
	
	public List<Booking>findByUserIDAndDateRangeAndStatus(String userID,Date startDate,Date endDate,String bookingStatus)throws BookingNotFoundException;
	
	public List<Booking>findByUserIDAndStatus(String bookingStatus,String userID)throws BookingNotFoundException;

}
