package com.springboot.banco.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="ContaCorrente", uniqueConstraints={@UniqueConstraint(columnNames={"conta"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class ContaCorrente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sequence")
	private Long id;
	
	@Column(name="agencia")
	private String agencia;
	
	@Column(name="conta")
	private String conta;
	
	@Column(name="num_banco")
	private Integer numBanco;
	
	@Column(name="nome_banco")
	private String nomeBanco;
	
	@Column(name="saldo")
	private BigDecimal saldo;
	
	@Column(name="data_usuario")
	private String dataUsuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transacao", nullable=false)
	private Transacao transacao;
	
	
	public ContaCorrente() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Integer getNumBanco() {
		return numBanco;
	}

	public void setNumBanco(Integer numBanco) {
		this.numBanco = numBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getDataUsuario() {
		return dataUsuario;
	}

	public void setDataUsuario(String dataUsuario) {
		this.dataUsuario = dataUsuario;
	}
	

}
