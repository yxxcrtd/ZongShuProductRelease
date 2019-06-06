package cn.digitalpublishing.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.digitalpublishing.dao.BaseDao;
import cn.digitalpublishing.util.Pager;

/**
 * BaseDAO Implement
 */
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	
	/** 日志 */
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	/**
	 * JdbcTemplate
	 */
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/** SQL Insert Flag */
	private static final String SQL_FLAG_INSERT = "insert";
	
	/** SQL Update Flag */
	private static final String SQL_FLAG_UPDATE = "update";
	
	/** SQL Delete Flag */
	private static final String SQL_FLAG_DELETE = "delete";
	
	/** Generic Class */
	private Class<T> clazz = null;
	
	/** Generic Object Name */
	private String tableName = "";
	
	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
		tableName = clazz.getSimpleName();
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#findById(java.io.Serializable)
	 */
	@Override
	public T findById(PK id) {
		try {
			String sql = new StringBuffer("SELECT * FROM T_").append(tableName).append(" WHERE ").append(tableName).append("Id = ?").toString();
			LOGGER.info(sql);
			RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(clazz);
			return jdbcTemplate.query(sql, rowMapper, id).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#findAllCount(java.lang.Object)
	 */
	@Override
	public int findAllCount(T t) {
		String sql = new StringBuffer("SELECT * FROM T_").append(tableName).toString();
		return jdbcTemplate.queryForList(sql).size();
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#findByPager(cn.digitalpublishing.util.Pager)
	 */
	@Override
	public List<T> findByPager(Pager pager) {
		String sql = new StringBuffer("SELECT * FROM T_").append(tableName).append(" ORDER BY ").append(tableName).append("CreateTime DESC LIMIT " + pager.getPageSize() + " OFFSET " + pager.getOffset()).toString();
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(clazz));
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#findAllList()
	 */
	@Override
	public List<T> findAllList() {
		String sql = new StringBuffer("SELECT * FROM T_").append(tableName).toString();
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(clazz));
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		String sql = this.makeSql(SQL_FLAG_INSERT);
		Object[] args = this.setArgs(t, SQL_FLAG_INSERT);
		int[] argTypes = this.setArgTypes(t, SQL_FLAG_INSERT);
		jdbcTemplate.update(sql, args, argTypes);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		String sql = this.makeSql(SQL_FLAG_UPDATE);
		Object[] args = this.setArgs(t, SQL_FLAG_UPDATE);
		int[] argTypes = this.setArgTypes(t, SQL_FLAG_UPDATE);
		jdbcTemplate.update(sql, args, argTypes);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(PK id) {
		String sql = new StringBuffer("DELETE FROM T_").append(tableName).append(" WHERE ").append(tableName).append("Id = ?").toString();
		jdbcTemplate.update(sql, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.digitalpublishing.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T t) {
		String sql = this.makeSql(SQL_FLAG_DELETE);
		Object[] args = this.setArgs(t, SQL_FLAG_DELETE);
		int[] argTypes = this.setArgTypes(t, SQL_FLAG_DELETE);
		jdbcTemplate.update(sql, args, argTypes);
	}
	
	/**
	 * Make SQL
	 */
	private String makeSql(String flag) {
		StringBuffer sql = new StringBuffer();
		Field[] fields = clazz.getDeclaredFields();
		switch (flag) {
		case SQL_FLAG_INSERT:
			sql.append("INSERT INTO T_" + tableName + " (");
			for (int i = 0; null != fields && i < fields.length; i++) {
				fields[i].setAccessible(true);
				String column = fields[i].getName();
				column = column.substring(0, 1).toUpperCase() + column.substring(1);
				if (!column.equals(tableName + "Id")) {
					sql.append(column).append(",");
				}
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") VALUES (");
			for (int i = 1; null != fields && i < fields.length; i++) {
				sql.append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
			break;
		case SQL_FLAG_UPDATE:
			sql.append("UPDATE T_" + tableName + " SET ");
			for (int i = 0; null != fields && i < fields.length; i++) {
				fields[i].setAccessible(true);
				String column = fields[i].getName();
				column = column.substring(0, 1).toUpperCase() + column.substring(1);
				if (!column.equals(tableName + "Id")) {
					sql.append(column).append(" = ?,");
				}
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE ").append(tableName).append("Id = ?");
			break;
		case SQL_FLAG_DELETE:
			sql.append("DELETE FROM T_").append(tableName).append(" WHERE ").append(tableName).append("Id = ?");
			break;
		default:
			break;
		}
		return sql.toString();
	}
	
	/**
	 * Set Object Args
	 * 
	 * @param t
	 * @param flag
	 * @return
	 */
	private Object[] setArgs(T t, String flag) {
		Field[] fields = clazz.getDeclaredFields();
		Object[] args = null;
		switch (flag) {
		case SQL_FLAG_INSERT:
			args = new Object[fields.length - 1];
			try {
				for (int i = 1; null != fields && i < fields.length; i++) {
					fields[i].setAccessible(true);
					args[i - 1] = fields[i].get(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case SQL_FLAG_UPDATE:
			args = new Object[fields.length];
			Object[] tempArr = new Object[fields.length];
			try {
				for (int i = 0; null != fields && i < fields.length; i++) {
					fields[i].setAccessible(true);
					tempArr[i] = fields[i].get(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1);
			args[args.length - 1] = tempArr[0];
			break;
		case SQL_FLAG_DELETE:
			args = new Object[1];
			try {
				fields[0].setAccessible(true);
				args[0] = fields[0].get(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return args;
	}
	
	/**
	 * Set Object Args Array
	 * 
	 * @param t
	 * @param flag
	 * @return
	 */
	private int[] setArgTypes(T t, String flag) {
		Field[] fields = clazz.getDeclaredFields();
		int[] argTypes = null;
		switch (flag) {
		case SQL_FLAG_INSERT:
			argTypes = new int[fields.length - 1];
			try {
				for (int i = 1; null != fields && i < fields.length; i++) {
					fields[i].setAccessible(true);
					if (fields[i].get(t).getClass().getName().equals("java.lang.String")) {
						argTypes[i - 1] = Types.VARCHAR;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Integer")) {
						argTypes[i - 1] = Types.INTEGER;
					} else if (fields[i].get(t).getClass().getName().equals("java.util.Date")) {
						argTypes[i - 1] = Types.TIMESTAMP;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Boolean")) {
						argTypes[i - 1] = Types.BOOLEAN;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Double")) {
						argTypes[i - 1] = Types.DOUBLE;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case SQL_FLAG_UPDATE:
			argTypes = new int[fields.length];
			int[] tempArgTypes = new int[fields.length];
			try {
				for (int i = 0; i < tempArgTypes.length; i++) {
					fields[i].setAccessible(true);
					if (fields[i].get(t).getClass().getName().equals("java.lang.String")) {
						tempArgTypes[i] = Types.VARCHAR;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Integer")) {
						tempArgTypes[i] = Types.INTEGER;
					} else if (fields[i].get(t).getClass().getName().equals("java.util.Date")) {
						tempArgTypes[i] = Types.TIMESTAMP;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Boolean")) {
						tempArgTypes[i] = Types.BOOLEAN;
					} else if (fields[i].get(t).getClass().getName().equals("java.lang.Double")) {
						tempArgTypes[i] = Types.DOUBLE;
					}
				}
				System.arraycopy(tempArgTypes, 1, argTypes, 0, tempArgTypes.length - 1);
				argTypes[argTypes.length - 1] = tempArgTypes[0];
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case SQL_FLAG_DELETE:
			argTypes = new int[1];
			try {
				fields[0].setAccessible(true);
				if (fields[0].get(t).getClass().getName().equals("java.lang.String")) {
					argTypes[0] = Types.VARCHAR;
				} else if (fields[0].get(t).getClass().getName().equals("java.lang.Integer")) {
					argTypes[0] = Types.INTEGER;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return argTypes;
	}
	
}
