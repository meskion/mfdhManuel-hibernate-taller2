package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.session = session;
	}

	protected void beginTransaction() {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(T paramT) {
		beginTransaction();

		session.save(paramT);
		session.flush();

		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T paramT) {
		beginTransaction();

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T paramT) {
		beginTransaction();

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T searchById(Long id) {
		// Verificación de sesión abierta.
		beginTransaction();

		// Búsqueda por PK.
		T result = session.get(entityClass, id);

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		beginTransaction();

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + entityClass.getName()).list();

		return list;
	}

}
