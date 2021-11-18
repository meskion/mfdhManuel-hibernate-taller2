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

		return session.createQuery("FROM " + Contract.class.getName() + " WHERE Client=" + client.getId()).list();

//		//inicializacion de consulta y tablas llamadas con criteria
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Contract> cquery = cb.createQuery(Contract.class);
//		Root<Contract> root = cquery.from(Contract.class);
//		Join<Contract, Client> join = root.join("client"); 
//		
//		//where
//		Predicate pred =cb.equal(join, client.getId());
//		
//		//consulta
//		cquery.select(root).where(pred);
//		
//		// resultado de la consulta
//		return session.createQuery(cquery).getResultList();

	}

}
