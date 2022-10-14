package com.d4i.bootcamp.tvshows.controllers;

import com.d4i.bootcamp.tvshows.json.CategoryRest;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.responses.D4iBootcampResponse;
import java.util.List;

public interface CategoryController {

	D4iBootcampResponse<List<CategoryRest>> getCategories() throws D4iBootcampException;

	D4iBootcampResponse<CategoryRest> createCategory(CategoryRest categoryRest)
			throws D4iBootcampException;
}
