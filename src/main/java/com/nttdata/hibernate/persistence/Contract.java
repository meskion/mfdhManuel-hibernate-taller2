package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	/**
	 * id
	 */
	private Long contractId;
	/**
	 * fechas del contrato
	 */
	private Date validityDate, expirationDate;
	/**
	 * Salario mensual
	 */
	private Double monthSalary;
	/**
	 * cliente
	 */
	private Client client;

	/**
	 * 
	 * @return ID del contrato
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * 
	 * @return fecha de vigencia
	 */
	@Column(name = "VALIDITY", nullable = false)
	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	/**
	 * 
	 * @return fecha de caducidad
	 */
	@Column(name = "EXPIRATION", nullable = false)
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * 
	 * @return Salario mensual
	 */
	@Column(name = "SALARY", nullable = false)
	public Double getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(Double monthSalary) {
		this.monthSalary = monthSalary;
	}

	/**
	 * Devuelve el cliente asociado. Anotado con JPA
	 * 
	 * @return cliente
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
