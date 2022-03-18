package com.springboot.banco.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Transacao")
@SequenceGenerator(name = "sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Transacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sequence")
	private Long id;
	
	@Column(name="data_transacao", nullable=false)
	private Date data;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contaOrigem", nullable=false)
	private ContaCorrente contaOrigem;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contaDestino", nullable=false)
	private ContaCorrente contaDestino;
	
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ContaCorrente getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(ContaCorrente contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public ContaCorrente getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaCorrente contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
	public Transacao() {
		super();
	}
	

}
