package cn.digitalpublishing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index
 */
@Controller
@RequestMapping("manage/index")
public class IndexController extends BaseController {
	
	/**
	 * Index
	 * 
	 * @return
	 */
	public String index() {
		return "Index";
	}

}
