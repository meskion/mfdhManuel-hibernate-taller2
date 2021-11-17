package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;

public class ContractManagementServiceImpl implements ContractManagementServiceI {

	private ContractDaoI contractDao;

	public ContractManagementServiceImpl(final Session session) {

		this.contractDao = new ContractDaoImpl(session);
	}

	/** {@inheritDoc} */
	@Override
	public void insertNewContract(Contract newContract) {

		if (newContract != null && newContract.getContractId() == null)
			contractDao.insert(newContract);
	}

	/** {@inheritDoc} */
	@Override
	public void updateContract(Contract updatedPlayer) {
		if (updatedPlayer != null && updatedPlayer.getContractId() != null)
			contractDao.update(updatedPlayer);
	}

	/** {@inheritDoc} */
	@Override
	public void deleteContract(Contract deletedPlayer) {
		if (deletedPlayer != null && deletedPlayer.getContractId() != null)
			contractDao.delete(deletedPlayer);

	}

	/** {@inheritDoc} */
	@Override
	public Contract searchById(Long contractId) {
		Contract contract = null;
		if (contractId != null) {
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	/** {@inheritDoc} */
	@Override
	public List<Contract> searchByClient(Client contractClient) {

		if (contractClient != null && contractClient.getId() != null)
			return contractDao.searchByClient(contractClient);
		return null;
	}

}
