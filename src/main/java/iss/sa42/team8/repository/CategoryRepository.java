package iss.sa42.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa42.team8.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	
	@Query("SELECT c.categoryID FROM Category c where categoryName=:cn")
	String findCategoryIDByName(@Param("cn") String cn);
	
	@Query("SELECT c.categoryName FROM Category c where categoryID=:cid")
	String findCategoryNameByID(@Param("cid") String cid);

}
