package cn.digitalpublishing.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.digitalpublishing.domain.Category;
import cn.digitalpublishing.domain.Resource;

/**
 * Row Mappers
 */
public class RowMappers {

	/**
	 * 资源和分类的数据包装
	 */
	public static final class ResourceMapper implements RowMapper<Resource> {
		@Override
		public Resource mapRow(ResultSet rs, int rowNum) throws SQLException {
			Resource resource = new Resource();
			resource.setResourceId(rs.getInt("resourceId"));
			resource.setResourceName(rs.getString("resourceName"));
			resource.setResourceISBN(rs.getString("resourceISBN"));
			resource.setResourceAuthor(rs.getString("resourceAuthor"));
			resource.setResourcePrice(rs.getDouble("resourcePrice"));

			Category category = new Category();
			category.setCategoryId(rs.getInt("categoryId"));
			category.setCategoryName(rs.getString("categoryName"));

			resource.setCategory(category);
			return resource;
		}

	}

}
