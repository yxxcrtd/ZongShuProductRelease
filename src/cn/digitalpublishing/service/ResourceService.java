package cn.digitalpublishing.service;

import java.util.List;

import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.util.Pager;

/**
 * Resource Service Interface
 */
public interface ResourceService extends BaseService<Resource, Integer> {
	
	List<Resource> findList(Pager pager);

}
