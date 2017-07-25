package iss.sa42.team8.service;

import java.util.List;

import iss.sa42.team8.exception.FacilityNotFoundException;
import iss.sa42.team8.model.Facility;

public interface FacilityService {

	public Facility create(Facility facility);

	public Facility delete(String id) throws FacilityNotFoundException;

	public List<Facility> findAll();

	public Facility update(Facility facility) throws FacilityNotFoundException;

	public Facility findById(String id);
	
	public String getLastFacilityID();
	
	public List<Facility> findByCategory(String categoryID);
	
	public List<Facility> findByBoth(String categoryID,String facilityName)throws FacilityNotFoundException;
}
