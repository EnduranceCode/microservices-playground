package com.d4i.bootcamp.tvshows.services.impl;

import com.d4i.bootcamp.tvshows.exceptions.D4iBootcampException;
import com.d4i.bootcamp.tvshows.exceptions.InternalServerErrorException;
import com.d4i.bootcamp.tvshows.json.CategoryRest;
import com.d4i.bootcamp.tvshows.repositories.CategoryRepository;
import com.d4i.bootcamp.tvshows.entities.Category;
import com.d4i.bootcamp.tvshows.services.CategoryService;
import com.d4i.bootcamp.tvshows.utils.constants.ExceptionConstants;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryRest> getCategories() throws D4iBootcampException {

		return categoryRepository.findAll().stream()
								 .map(category -> modelMapper.map(category, CategoryRest.class))
								 .collect(Collectors.toList());

	}

	public CategoryRest createCategories(final CategoryRest categoryRest)
			throws D4iBootcampException {
		Category category = new Category();
		category.setName(categoryRest.getName());
		try {
			category = categoryRepository.save(category);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(category, CategoryRest.class);
	}
}
