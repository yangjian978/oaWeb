package cn.itcast.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存实体
	 */
	void save(T entity);

	/**
	 * 删除实体
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 */
	void update(T entity);

	/**
	 * 根据id查询
	 */
	T getById(Long id);

	/**
	 * 根据id数组查询多个
	 */
	List<T> getById(Long[] ids);

	/**
	 * 查询所有
	 */
	List<T> findAll();
}
