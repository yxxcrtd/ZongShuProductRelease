package cn.digitalpublishing.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.digitalpublishing.dao.ResourceDao;
import cn.digitalpublishing.domain.Resource;
import cn.digitalpublishing.util.Pager;

/**
 * Resource Dao Implement
 */
@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource, Integer> implements ResourceDao {
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.ResourceDao#findList(cn.digitalpublishing.util.Pager)
	 */
	@Override
	public List<Resource> findList(Pager pager) {
		String sql = new StringBuffer()
			.append("SELECT r.resourceId, r.resourceName, r.resourceISBN, r.resourceAuthor, r.resourcePrice, c.categoryId, c.categoryName ")
			.append("FROM T_Resource r ")
			.append("LEFT JOIN T_Category c ")
			.append("ON r.CategoryId = c.CategoryId ")
			.append("ORDER BY ResourceCreateTime DESC LIMIT ")
			.append(pager.getPageSize())
			.append(" OFFSET ")
			.append(pager.getOffset()).toString();
		return jdbcTemplate.query(sql, new RowMappers.ResourceMapper());
	}

}
