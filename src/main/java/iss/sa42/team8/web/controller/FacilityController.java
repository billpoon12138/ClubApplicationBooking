package iss.sa42.team8.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa42.team8.exception.FacilityNotFoundException;
import iss.sa42.team8.model.Category;
import iss.sa42.team8.model.Facility;
import iss.sa42.team8.service.CategoryService;
import iss.sa42.team8.service.FacilityService;
import iss.sa42.team8.util.Convertor;
import iss.sa42.team8.util.Generator;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private Generator generator;

	@Autowired
	private Convertor convertor;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("facility-new", "facility", new Facility());
		mav.addObject("categoryNames", categoryService.getAllCategoryName());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("facility-new");

		facility.setFacilityID(generator.generateFacilityID());

		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityID() + " was successfully created.";

		facility.setStatus(Facility.VACANT);
		facility.setCategoryID(categoryService.getCategoryIDByName(facility.getCategoryID()));

		facilityService.create(facility);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("facility-list");
		List<Facility> facilityList = facilityService.findAll();

		mav.addObject("facilityList", convertor.facilityID2Name(facilityList));

		return mav;
	}

	@RequestMapping(value = "/edit/{facilityID}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String facilityID) {
		ModelAndView mav = new ModelAndView("facility-edit");
		Facility facility = facilityService.findById(facilityID);
		facility.setCategoryID(categoryService.getCategoryNameByID(facility.getCategoryID()));
		mav.addObject("facility", facility);
		mav.addObject("categoryNames", categoryService.getAllCategoryName());
		return mav;
	}

	@RequestMapping(value = "/edit/{facilityID}", method = RequestMethod.POST)
	public ModelAndView editBooking(@ModelAttribute @Valid Facility facility, BindingResult result,
			@PathVariable String facilityID, final RedirectAttributes redirectAttributes)
			throws FacilityNotFoundException {

		if (result.hasErrors())
			return new ModelAndView("facility-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Facility was successfully updated.";

		facilityService.update(facility);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{facilityID}", method = RequestMethod.GET)
	public ModelAndView deleteMember(@PathVariable String facilityID, final RedirectAttributes redirectAttributes)
			throws FacilityNotFoundException {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		Facility facility = facilityService.delete(facilityID);
		String message = "The facility " + facility.getFacilityID() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	// -----------------------------Commonality---------------------------
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView facilitySearchPage() {
		ModelAndView mav = new ModelAndView("facility-search", "facility", new Facility());
		List<Category> cate = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : cate) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);
		List<Facility> facilityList = facilityService.findAll();
		mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView facilitySearchPage(@ModelAttribute @Valid Facility facility, @RequestParam String facName,
			@RequestParam("categoryID") String cate, BindingResult result, final RedirectAttributes redirectAttributes)
			throws FacilityNotFoundException {
		ModelAndView mav = new ModelAndView("facility-search", "facility", new Facility());
		List<Category> category = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : category) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);

		String CategoryID = categoryService.getCategoryIDByName(cate);
		String facilityName = '%' + facName.toLowerCase() + '%';
		if (facilityName == "") {
			List<Facility> facilityList = facilityService.findByCategory(CategoryID);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		} else {
			List<Facility> facilityList = facilityService.findByBoth(CategoryID, facilityName);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		}
	}

	// -------------------------------Member-------------------------------
	@RequestMapping(value = "/searchm", method = RequestMethod.GET)
	public ModelAndView facilitySearchMPage() {
		ModelAndView mav = new ModelAndView("facility-searchmember", "facility", new Facility());
		List<Category> cate = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : cate) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);
		List<Facility> facilityList = facilityService.findAll();
		mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
		return mav;
	}

	@RequestMapping(value = "/searchm", method = RequestMethod.POST)
	public ModelAndView facilitySearchMPage(@ModelAttribute @Valid Facility facility, @RequestParam String facName,
			@RequestParam("categoryID") String cate, BindingResult result, final RedirectAttributes redirectAttributes)
			throws FacilityNotFoundException {
		ModelAndView mav = new ModelAndView("facility-searchmember", "facility", new Facility());
		List<Category> category = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : category) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);

		String CategoryID = categoryService.getCategoryIDByName(cate);
		String facilityName = '%' + facName.toLowerCase() + '%';
		if (facilityName == "") {
			List<Facility> facilityList = facilityService.findByCategory(CategoryID);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		} else {
			List<Facility> facilityList = facilityService.findByBoth(CategoryID, facilityName);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		}
	}

	// -------------------------------Admin-------------------------------
	@RequestMapping(value = "/searcha", method = RequestMethod.GET)
	public ModelAndView facilitySearchAPage() {
		ModelAndView mav = new ModelAndView("facility-searchadmin", "facility", new Facility());
		List<Category> cate = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : cate) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);
		List<Facility> facilityList = facilityService.findAll();
		mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
		return mav;
	}

	@RequestMapping(value = "/searcha", method = RequestMethod.POST)
	public ModelAndView facilitySearchAPage(@ModelAttribute @Valid Facility facility, @RequestParam String facName,
			@RequestParam("categoryID") String cate, BindingResult result, final RedirectAttributes redirectAttributes)
			throws FacilityNotFoundException {
		ModelAndView mav = new ModelAndView("facility-searchadmin", "facility", new Facility());
		List<Category> category = categoryService.findAll();
		List<String> cateName = new ArrayList<String>();
		for (Category c : category) {
			cateName.add(c.getCategoryName());
		}
		mav.addObject("cateName", cateName);

		String CategoryID = categoryService.getCategoryIDByName(cate);
		String facilityName = '%' + facName.toLowerCase() + '%';
		if (facilityName == "") {
			List<Facility> facilityList = facilityService.findByCategory(CategoryID);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		} else {
			List<Facility> facilityList = facilityService.findByBoth(CategoryID, facilityName);
			mav.addObject("facilityList", convertor.facilityID2Name(facilityList));
			return mav;
		}
	}

}
