package cn.digitalpublishing.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.digitalpublishing.domain.Category;
import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.util.Pager;

/**
 * Resource
 */
@Controller
@RequestMapping("manage/resource")
public class ResourceController extends BaseController {
	
	/**
	 * List
	 * 
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false, defaultValue = "1") int p) {	
		ModelAndView mav = new ModelAndView();
		Pager pager = new Pager();
		pager.setPageNo(p);
		pager.setTotalCount(resourceService.findAllCount(resource));
		mav.addObject("resourceList", resourceService.findList(pager));
		mav.addObject("pager", pager);
		mav.setViewName("resource/ResourceList");
		return mav;
	}
	
	/**
	 * Add
	 * 
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		Map<String, String> categoryMap = new LinkedHashMap<String, String>();
		for (Category c : categoryService.findAllList()) {
			categoryMap.put(String.valueOf(c.getCategoryId()), c.getCategoryName());
		}
		mav.addObject("categoryMap", categoryMap);
		mav.addObject("resource", new Resource());
		mav.setViewName("resource/ResourceEdit");
		return mav;
	}
	
	/**
	 * Edit
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id:[\\d]+}")
	public ModelAndView edit(@PathVariable(value = "id") int id) {
		resource = resourceService.findById(id);
		
		if (null == resource) {
			resource = new Resource();
			LOGGER.error("Resource：" + id + " 不存在！");
		}
		
		ModelAndView mav = new ModelAndView();
		Map<String, String> categoryMap = new LinkedHashMap<String, String>();
		for (Category c : categoryService.findAllList()) {
			categoryMap.put(String.valueOf(c.getCategoryId()), c.getCategoryName());
		}
		mav.addObject("categoryMap", categoryMap);
		mav.addObject("resource", resource);
		mav.setViewName("resource/ResourceEdit");
		return mav;
	}
	
	/**
	 * Save
	 * 
	 * @param resource
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Resource resource, final RedirectAttributes redirectAttributes) {
		resource.setCategoryId(resource.getCategory().getCategoryId());
		if (0 == resource.getResourceId()) {
			resource.setResourceCreateTime(new Date());
			resourceService.save(resource);
			redirectAttributes.addFlashAttribute("tips", "保存成功！");
		} else {
			resourceService.update(resource);
			redirectAttributes.addFlashAttribute("tips", "修改成功！");
		}
		return "redirect:/manage/resource";
	}
	
	/**
	 * Delete
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("del/{id:[\\d]+}")
	public String delete(@PathVariable(value = "id") int id, final RedirectAttributes redirectAttributes) {
		resourceService.delete(id);
		redirectAttributes.addFlashAttribute("tips", "删除成功！");
		return "redirect:/manage/resource";
	}

}
