package com.d4i.bootcamp.tvshows.tvshows.services;

import com.d4i.bootcamp.tvshows.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.tvshows.json.CategoryRest;
import java.util.List;

public interface CategoryService {

	List<CategoryRest> getCategories() throws D4iBootcampException;

	CategoryRest createCategories(CategoryRest categoryRest) throws D4iBootcampException;
}
