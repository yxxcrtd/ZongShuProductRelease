package cn.digitalpublishing.dao;

import java.io.Serializable;
import java.util.List;

import cn.digitalpublishing.util.Pager;

/**
 * Generic DAO
 */
public interface BaseDao<T, PK extends Serializable> {
	
	T findById(PK id);
	
	int findAllCount(T t);
	
	List<T> findByPager(Pager pager);
	
	List<T> findAllList();

	void save(T t);
	
	void update(T t);
	
	void delete(PK id);
	
	void delete(T t);
	
}
