package com.springboot.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.banco.entidades.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{
	
	

}
