package cn.digitalpublishing.service;

import java.io.Serializable;
import java.util.List;

import cn.digitalpublishing.util.Pager;

/**
 * Generic Service
 */
public interface BaseService<T, PK extends Serializable> {
	
	T findById(PK id);
	
	int findAllCount(T t);
	
	List<T> findByPager(Pager pager);
	
	List<T> findAllList();
	
	void save(T t);
	
	void update(T t);
	
	void delete(PK id);
	
	void delete(T t);

}
