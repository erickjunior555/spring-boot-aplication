package com.springboot.banco.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.banco.entidades.ContaCorrente;
import com.springboot.banco.entidades.Transacao;
import com.springboot.banco.repository.TransacaoRepository;


@Service
public class TransacaoService {
	
	@Autowired
    private TransacaoRepository transacaoRepository;
	
	public Transacao salvar(Transacao transacao){
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listaTransacao(){
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id){
        return transacaoRepository.findById(id);
    }

    public void removerPorId(Long id){
    	transacaoRepository.deleteById(id);
    }

}
