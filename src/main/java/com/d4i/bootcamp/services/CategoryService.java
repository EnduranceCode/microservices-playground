package com.d4i.bootcamp.services;

import com.d4i.bootcamp.exceptions.D4iBootcampException;
import com.d4i.bootcamp.json.CategoryRest;
import java.util.List;

public interface CategoryService {

	List<CategoryRest> getCategories() throws D4iBootcampException;

	CategoryRest createCategories(CategoryRest categoryRest) throws D4iBootcampException;
}
