package cn.digitalpublishing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.digitalpublishing.dao.ResourceDao;
import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.service.ResourceService;
import cn.digitalpublishing.util.Pager;

/**
 * Resource Service Implement
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, Integer> implements ResourceService {

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.ResourceService#findList(cn.digitalpublishing.util.Pager)
	 */
	@Override
	public List<Resource> findList(Pager pager) {
		return ((ResourceDao) baseDao).findList(pager);
	}

}
