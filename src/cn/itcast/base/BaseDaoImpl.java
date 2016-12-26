package cn.itcast.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionfacory;
	protected Class<T> clazz = null;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println("---->clazz = " + clazz);
	}

	protected Session getSession() {
		return sessionfacory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			return;
		}

		Object entity = getById(id);
		if (entity != null) {
			getSession().delete(entity);
		}
	}

	public T getById(Long id) {
		return (T) getSession().get(clazz, id);

	}

	public List<T> getByIds(Long[] ids) {
		return getSession()
				.createQuery(
						"from " + clazz.getSimpleName() + "where id in(:ids)")//
				.setParameterList("ids", ids).list();

	}

	public List<T> findAll() {
		return getSession().createQuery("from" + clazz.getSimpleName()).list();
	}

}
