package iss.sa42.team8.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.model.Category;
import iss.sa42.team8.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<String> getAllCategoryName() {
		List<String> categoryNames = new ArrayList<String>();
		for(Category category : categoryRepository.findAll()){
			categoryNames.add(category.getCategoryName());
		}
		return categoryNames;
	}

	@Override
	public String getCategoryIDByName(String categoryName) {
		return categoryRepository.findCategoryIDByName(categoryName);
	}

	@Override
	public String getCategoryNameByID(String categoryID) {
		return categoryRepository.findCategoryNameByID(categoryID);
	}

}
