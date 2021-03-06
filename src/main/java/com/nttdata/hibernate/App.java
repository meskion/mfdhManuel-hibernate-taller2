package com.nttdata.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.services.ClientManagementServiceI;
import com.nttdata.hibernate.services.ClientManagementServiceImpl;
import com.nttdata.hibernate.services.ContractManagementServiceI;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);
		//generacion de clientes
		
		final Client tellez = new Client();
		tellez.setDni("111111111");
		tellez.setName("Juan Alejandro");
		tellez.setFirstSurname("Tellez");
		tellez.setSecondSurname("Rubio");
		tellez.setUpdatedUser("Manu");
		tellez.setUpdatedDate(new Date());
		
		//Generacion de contratos
		final  Contract contratoNaturgy = new Contract();
		contratoNaturgy.setClient(tellez);
		contratoNaturgy.setMonthSalary(2000d);
		contratoNaturgy.setExpirationDate(new Date());
		contratoNaturgy.setValidityDate(new Date());
		contratoNaturgy.setUpdatedUser("Manu");
		contratoNaturgy.setUpdatedDate(new Date());
		
		final  Contract contratoDual = new Contract();
		contratoDual.setClient(tellez);
		contratoDual.setMonthSalary(1000d);
		contratoDual.setExpirationDate(new Date());
		contratoDual.setValidityDate(new Date());
		contratoDual.setUpdatedUser("Manu");
		contratoDual.setUpdatedDate(new Date());
		
		contractService.insertNewContract(contratoNaturgy);
		contractService.insertNewContract(contratoDual);
		clientService.insertNewClient(tellez);
		
		clientService.searchByFullName(tellez.getName(), tellez.getFirstSurname(), tellez.getSecondSurname()).forEach(System.out::println);
		System.out.println("---------------");
		contractService.searchByClient(tellez).forEach(System.out::println);;
		session.close();
		
	}
}
