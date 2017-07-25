package iss.sa42.team8.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.exception.FacilityNotFoundException;
import iss.sa42.team8.model.Facility;
import iss.sa42.team8.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	private FacilityRepository facilityRepository;
	
	@Override
	@Transactional
	public Facility create(Facility facility) {
		Facility createFacility = facility;
		return facilityRepository.save(createFacility);
	}

	@Override
	@Transactional(rollbackFor=FacilityNotFoundException.class)
	public Facility delete(String id) throws FacilityNotFoundException {
		Facility deleteFacility = facilityRepository.findOne(id);
		if(deleteFacility == null){
			throw new FacilityNotFoundException();
		}
		facilityRepository.delete(deleteFacility);
		return deleteFacility;
	}

	@Override
	@Transactional
	public List<Facility> findAll() {
		return facilityRepository.findAll();
	}

	@Override
	@Transactional
	public Facility update(Facility facility) throws FacilityNotFoundException {
		Facility updateFacility = facilityRepository.findOne(facility.getFacilityID());
		if(updateFacility == null){
			throw new FacilityNotFoundException();
		}
		
		updateFacility.setFacilityID(facility.getFacilityID());
		updateFacility.setCategoryID(facility.getCategoryID());
		updateFacility.setFacilityName(facility.getFacilityName());
		updateFacility.setStatus(facility.getStatus());
		updateFacility.setRemarks(facility.getRemarks());
		
		facilityRepository.flush();
		return updateFacility;
	}

	@Override
	@Transactional
	public Facility findById(String id) {
		return facilityRepository.findOne(id);
	}

	@Override
	@Transactional
	public String getLastFacilityID() {
		if(facilityRepository.findLastFacilityID().isEmpty()){
			return Facility.FACILITY_PREFIX + 10000;
		}
		else{
			return facilityRepository.findLastFacilityID().get(0);
		}
		
	}
	
	//----------------------------------------------------------------------------------
		@Override
		@Transactional
		public List<Facility> findByCategory(String categoryID) {
			return facilityRepository.findByCategoryID(categoryID);
		}

		@Override
		@Transactional(rollbackFor = FacilityNotFoundException.class)
		public List<Facility> findByBoth(String categoryID, String facilityName)throws FacilityNotFoundException{
			return facilityRepository.findByCategoryAndFacilityName(categoryID, facilityName);			
		}
		//----------------------------------------------------------------------------------

}
