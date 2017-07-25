package iss.sa42.team8.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

	@Query("SELECT b from Booking b WHERE b.userID = :uid")
	ArrayList<Booking> findBookingsByUID(@Param("uid") String uid);
	
	@Query("SELECT b from Booking b WHERE b.facilityID = :fid")
	ArrayList<Booking> findBookingsByFID(@Param("fid") String fid);
	
	@Query("SELECT b from Booking b WHERE b.bookingStatus = :status")
	ArrayList<Booking> findBookingsByStatus(@Param("status") String status);
	
	//LIMIT 1  
	@Query("SELECT b.bookingID FROM Booking b ORDER BY b.bookingID DESC")
	ArrayList<String> findLastBookingID();
	
	// ---------------------------------------------------------
	@Query("select b from Booking b where b.bookingDate between :startDate and :endDate")
	ArrayList<Booking> findByDRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("select b from Booking b where b.bookingDate between :startDate and :endDate "
			+ "and b.bookingStatus=:bookingStatus")
	ArrayList<Booking> findByDRandStatus(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
			@Param("bookingStatus") String bookingStatus);

	@Query("SELECT b from Booking b WHERE b.userID=:userID and b.bookingStatus = :status")
	ArrayList<Booking> findByUS(@Param("userID") String userID, @Param("status") String status);

	@Query("select b from Booking b where b.bookingDate between :startDate and :endDate "
			+ "and b.bookingStatus=:bookingStatus and b.userID=:userID")
	ArrayList<Booking> findByUDS(@Param("userID") String userID, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("bookingStatus") String bookingStatus);

	@Query("select b from Booking b where b.bookingDate between :startDate and :endDate and b.userID=:userID")
	ArrayList<Booking> findByUD(@Param("userID") String userID, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
}
