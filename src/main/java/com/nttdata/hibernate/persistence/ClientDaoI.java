package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Interfaz del patron DAO para la clase cliente.
 * 
 * @author Usuario
 *
 */
public interface ClientDaoI extends CommonDaoI<Client>{
	

	/**
	 * Busca y devuelve una lista con todos los clientes con el nombre exacto
	 * especificado.
	 * 
	 * @param name
	 * @return matching clients
	 */
	public List<Client> searchByName(final String name);

	/**
	 * Busca y devuelve una lista con todos los clientes con el nombre completo
	 * exacto especificado.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return
	 */
	public List<Client> searchByFullName(String name, String surname1, String surname2);
}
