package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Implementacion de ClienteDaoI
 * 
 * @author Manu FHD
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	// Atributos

	/**
	 * Sesion de hibernate con la que trabaja el DAO
	 */
	private Session session;

	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		beginTransaction();

		final List<Client> clientList = session.createQuery("FROM " + Client.class.getName() + " WHERE name=" + name)
				.list();

		return clientList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFullName(final String name, final String surname1, final String surname2) {

		beginTransaction();

		String query = "from " + Client.class.getName() + " " + "where name = '" + name + "'" + "and firstSurname = '"
				+ surname1 + "'" + "and secondSurname = '" + surname2 + "'";

		final List<Client> clientList = session.createQuery(query).list();

		return clientList;
	}

	/**
	 * Verificación de sesión abierta.
	 */
	

}
