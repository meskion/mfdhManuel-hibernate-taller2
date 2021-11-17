package com.nttdata.hibernate.persistence;

import java.util.List;

public interface ContractDaoI extends CommonDaoI<Contract>{

	public List<Contract> searchByClient(Client client); 
}
