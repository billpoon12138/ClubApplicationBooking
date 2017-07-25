package iss.sa42.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa42.team8.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, String> {

	@Query("SELECT f.facilityID FROM Facility f ORDER BY f.facilityID DESC")
	ArrayList<String> findLastFacilityID();
	
	@Query("SELECT f FROM Facility f WHERE f.categoryID=:categoryID") 
	 ArrayList<Facility> findByCategoryID(@Param("categoryID") String categoryID); 
	 
	@Query("select f from Facility f where f.categoryID =:categoryID and lower(f.facilityName) like :facilityname") 
	 ArrayList<Facility> findByCategoryAndFacilityName(@Param("categoryID")  String categoryID, 
	                                 		@Param("facilityname") String FacilityName); 
}
