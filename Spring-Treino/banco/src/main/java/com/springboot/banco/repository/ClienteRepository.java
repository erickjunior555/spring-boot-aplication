package com.springboot.banco.repository;
import com.springboot.banco.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNome(String nome);
	
}
