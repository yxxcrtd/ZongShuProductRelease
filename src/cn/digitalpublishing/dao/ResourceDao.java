package cn.digitalpublishing.dao;

import java.util.List;

import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.util.Pager;

/**
 * Resource DAO
 */
public interface ResourceDao extends BaseDao<Resource, Integer> {

	List<Resource> findList(Pager pager);

}
