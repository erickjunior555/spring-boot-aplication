package com.springboot.banco.controller;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.banco.entidades.Transacao;
import com.springboot.banco.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao salvar(@RequestBody Transacao transacao){
        return transacaoService.salvar(transacao);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transacao> listaTransacao(){
        return transacaoService.listaTransacao();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transacao buscarTransacaoPorId(@PathVariable("id") Long id){
        return transacaoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transação não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTransacao(@PathVariable("id") Long id){
    	transacaoService.buscarPorId(id)
                .map(transacao -> {
                	transacaoService.removerPorId(transacao.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transação não encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarTransacao(@PathVariable("id") Long id, @RequestBody Transacao transacao){
    	transacaoService.buscarPorId(id)
                .map(transacaoBase -> {
                    modelMapper.map(transacao, transacaoBase);
                    transacaoService.salvar(transacaoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transação nao encontrado."));
    }


}
