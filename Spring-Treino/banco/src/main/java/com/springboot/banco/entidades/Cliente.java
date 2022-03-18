package com.springboot.banco.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Cliente", uniqueConstraints={@UniqueConstraint(columnNames={"codigo"})})
@SequenceGenerator(name = "sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
	}

	public String getNi() {
		return ni;
	}

	public void setNi(String ni) {
		this.ni = ni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDataUsuario() {
		return dataUsuario;
	}

	public void setDataUsuario(String dataUsuario) {
		this.dataUsuario = dataUsuario;
	}

	public static int getTiCpf() {
		return TI_CPF;
	}

	public static int getTiCnpj() {
		return TI_CNPJ;
	}

	public static final int TI_CPF = 0;
	public static final int TI_CNPJ = 1;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long id;
	
	@Column(name="codigo")
	private String codigo;
	 
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Column(name="ti", nullable=false)
	private int ti;
	
	@Column(name="ni", nullable=false)
	private String ni;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="telefone", nullable=false)
	private String telefone;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conta", nullable=false)
	private ContaCorrente conta;
	
	@Column(name="endereco", nullable=false)
	private String endereco;
	
	@Column(name="numero", nullable=false)
	private Integer numero;
	
	@Column(name="complemento", nullable=false)
	private String complemento;
	
	@Column(name="bairro", nullable=false)
	private String bairro;
	
	@Column(name="municipio", nullable=false)
	private String municipio;
	
	@Column(name="uf", nullable=false)
	private String uf;
	
	@Column(name="dataUsuario", nullable=false)
	private String dataUsuario;
	

}
