package iss.sa42.team8.service;

import java.util.List;

import iss.sa42.team8.model.Category;


public interface CategoryService {
	
	public List<Category> findAll();
	
	public List<String> getAllCategoryName();
	
	public String getCategoryIDByName(String categoryName);
	
	public String getCategoryNameByID(String categoryID);

}
