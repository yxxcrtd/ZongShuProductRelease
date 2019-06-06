package cn.digitalpublishing.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.digitalpublishing.dao.BaseDao;
import cn.digitalpublishing.service.BaseService;
import cn.digitalpublishing.util.Pager;

/**
 * Base Service Implement
 */
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
	
	/**
	 * Base Dao
	 */
	@Autowired
	protected BaseDao<T, PK> baseDao;

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#findById(java.io.Serializable)
	 */
	@Override
	public T findById(PK id) {
		return (T) baseDao.findById(id);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#findAllCount(java.lang.Object)
	 */
	@Override
	public int findAllCount(T t) {
		return baseDao.findAllCount(t);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#findByPager(cn.digitalpublishing.util.Pager)
	 */
	@Override
	public List<T> findByPager(Pager pager) {
		return baseDao.findByPager(pager);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#findAllList()
	 */
	@Override
	public List<T> findAllList() {
		return baseDao.findAllList();
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(PK id) {
		baseDao.delete(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.service.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

}
