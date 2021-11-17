package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	private Session session;

	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByClient(final Client client) {

		beginTransaction();
		// Contract.class.getName()
		return session.createQuery("FROM " + Contract.class.getName() + " WHERE Client=" + client.getId()).list();

	}

}
