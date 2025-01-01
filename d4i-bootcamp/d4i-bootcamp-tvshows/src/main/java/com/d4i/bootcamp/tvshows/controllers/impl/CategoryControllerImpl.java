package com.d4i.bootcamp.tvshows.controllers.impl;

import com.d4i.bootcamp.tvshows.json.CategoryRest;
import com.d4i.bootcamp.tvshows.controllers.CategoryController;
import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.responses.D4iBootcampResponse;
import com.d4i.bootcamp.tvshows.services.CategoryService;
import com.d4i.bootcamp.tvshows.utils.constants.CommonConstants;
import com.d4i.bootcamp.tvshows.utils.constants.RestConstants;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY)
public class CategoryControllerImpl implements CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<List<CategoryRest>> getCategories() throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, categoryService.getCategories());
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public D4iBootcampResponse<CategoryRest> createCategory(
			@ApiParam(value = RestConstants.PARAMETER_CATEGORY, required = true) @RequestBody @Valid final CategoryRest categoryRest)
			throws D4iBootcampException {

		return new D4iBootcampResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, categoryService.createCategories(categoryRest));
	}
}
