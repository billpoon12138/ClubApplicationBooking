package iss.sa42.team8.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.exception.BookingNotFoundException;
import iss.sa42.team8.model.Booking;
import iss.sa42.team8.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Resource
	private BookingRepository bookingRepsitory;
	
	@Override
	@Transactional
	public Booking create(Booking booking) {
		Booking createBooking = booking;
		return bookingRepsitory.save(createBooking);
	}

	@Override
	@Transactional(rollbackFor=BookingNotFoundException.class)
	public Booking delete(String id) throws BookingNotFoundException {
		Booking deleteBooking = bookingRepsitory.findOne(id);
		if(deleteBooking == null){
			throw new BookingNotFoundException();
		}
		bookingRepsitory.delete(deleteBooking);
		return deleteBooking;
	}

	@Override
	@Transactional
	public List<Booking> findAll() {
		return bookingRepsitory.findAll();
	}

	@Override
	@Transactional(rollbackFor=BookingNotFoundException.class)
	public Booking update(Booking booking) throws BookingNotFoundException {
		Booking updateBooking = bookingRepsitory.findOne(booking.getBookingID());
		if(updateBooking == null){
			throw new BookingNotFoundException();
		}
		
		updateBooking.setBookingID(booking.getBookingID());
		updateBooking.setUserID(booking.getUserID());
		updateBooking.setFacilityID(booking.getFacilityID());
		updateBooking.setBookingStatus(booking.getBookingStatus());
		updateBooking.setBookingDate(booking.getBookingDate());
		updateBooking.setBookingDate(booking.getCheckoutDate());
		updateBooking.setBookingDate(booking.getCurrentDate());
		updateBooking.setRemarks(booking.getRemarks());
		bookingRepsitory.flush();
		return updateBooking;
	}

	@Override
	@Transactional
	public Booking findById(String id) {
		return bookingRepsitory.findOne(id);
	}

	@Override
	@Transactional
	public List<Booking> findByUserID(String userID) {
		return bookingRepsitory.findBookingsByUID(userID);
	}

	@Override
	@Transactional
	public List<Booking> findByFacilityID(String facilityID) {
		return bookingRepsitory.findBookingsByFID(facilityID);
	}

	@Override
	@Transactional
	public List<Booking> findByStatus(String status) {
		return bookingRepsitory.findBookingsByStatus(status);
	}

	@Override
	@Transactional
	public String getLastBookingID() {
		if(bookingRepsitory.findLastBookingID().isEmpty()){
			return Booking.BOOKINGID_PREFIX + 10000;
		}else{
			return bookingRepsitory.findLastBookingID().get(0);
		}
	}
	
	@Override
	@Transactional(rollbackFor = BookingNotFoundException.class)
	public List<Booking>findByDateRange(Date startDate,Date endDate)throws BookingNotFoundException{
		List<Booking>result=bookingRepsitory.findByDRange(startDate, endDate);
		if(result==null)
			throw new BookingNotFoundException();
		return result;
	}
	@Override
	@Transactional(rollbackFor = BookingNotFoundException.class)
	public List<Booking>findByDateRangeAndStatus(Date startDate,Date endDate,String bookingStatus)throws BookingNotFoundException{
		List<Booking>result=bookingRepsitory.findByDRandStatus(startDate, endDate,bookingStatus);
		if(result==null)
			throw new BookingNotFoundException();
		return result;
	}
	@Override
	@Transactional(rollbackFor = BookingNotFoundException.class)
	public List<Booking>findByUserIDAndDateRange(String userID,Date startDate,Date endDate)throws BookingNotFoundException{
		List<Booking>result=bookingRepsitory.findByUD(userID,startDate, endDate);
		if(result==null)
			throw new BookingNotFoundException();
		return result;
	}
	@Override
	@Transactional(rollbackFor = BookingNotFoundException.class)
	public List<Booking>findByUserIDAndDateRangeAndStatus(String userID,Date startDate,Date endDate,String bookingStatus)throws BookingNotFoundException{
		List<Booking>result=bookingRepsitory.findByUDS(userID,startDate, endDate, bookingStatus);
		if(result==null)
			throw new BookingNotFoundException();
		return result;
	}
	@Override
	@Transactional(rollbackFor = BookingNotFoundException.class)
	public List<Booking>findByUserIDAndStatus(String userID,String bookingStatus)throws BookingNotFoundException{
		List<Booking>result=bookingRepsitory.findByUS(userID,bookingStatus);
		if(result==null)
			throw new BookingNotFoundException();
		return result;
	}
}
