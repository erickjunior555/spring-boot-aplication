package com.springboot.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.banco.entidades.ContaCorrente;
import com.springboot.banco.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	
	public ContaCorrente salvar(ContaCorrente conta) {
		return contaCorrenteRepository.save(conta);
	}
	
	public List<ContaCorrente> listaContas(){	
		return contaCorrenteRepository.findAll();		
	}
	
	public Optional<ContaCorrente> buscarPorId(Long id){
        return contaCorrenteRepository.findById(id);
    }
	
	public void removerPorId(Long id){
       contaCorrenteRepository.deleteById(id);
    }

}
