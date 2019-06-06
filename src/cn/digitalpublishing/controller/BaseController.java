package cn.digitalpublishing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.digitalpublishing.domain.Category;
import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.service.CategoryService;
import cn.digitalpublishing.service.ResourceService;

/**
 * Base Controller
 */
public class BaseController {
	
	/**
	 * Log
	 */
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	/**
	 * Category Object
	 */
	protected Category category;

	/**
	 * Resource Object
	 */
	protected Resource resource;
	
	/**
	 * Category Service
	 */
	@Autowired
	protected CategoryService categoryService;
	
	/**
	 * Resource Service
	 */
	@Autowired
	protected ResourceService resourceService;
 	
}
