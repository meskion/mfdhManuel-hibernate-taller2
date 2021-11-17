package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;

public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedPlayer);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedPlayer);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Obtiene un contrato a traves de su cliente
	 * 
	 * @param contractClient
	 * 
	 */
	public List<Contract> searchByClient(final Client contractClient);

}
