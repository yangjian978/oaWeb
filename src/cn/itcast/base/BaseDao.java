package cn.itcast.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * ����ʵ��
	 */
	void save(T entity);

	/**
	 * ɾ��ʵ��
	 */
	void delete(Long id);

	/**
	 * ����ʵ��
	 */
	void update(T entity);

	/**
	 * ����id��ѯ
	 */
	T getById(Long id);

	/**
	 * ����id�����ѯ���
	 */
	List<T> getById(Long[] ids);

	/**
	 * ��ѯ����
	 */
	List<T> findAll();
}
