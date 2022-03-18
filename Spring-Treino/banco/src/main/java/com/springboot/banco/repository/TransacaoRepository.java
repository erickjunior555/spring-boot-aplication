package com.springboot.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.banco.entidades.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	
}
