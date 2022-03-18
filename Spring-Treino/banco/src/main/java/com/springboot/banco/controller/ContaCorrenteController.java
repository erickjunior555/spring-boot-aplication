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

import com.springboot.banco.entidades.ContaCorrente;
import com.springboot.banco.service.ContaCorrenteService;

@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaCorrente salvar(@RequestBody ContaCorrente conta){
        return contaCorrenteService.salvar(conta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContaCorrente> listaContaCorrente(){
        return contaCorrenteService.listaContas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaCorrente buscarContaCorrentePorId(@PathVariable("id") Long id){
        return contaCorrenteService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Está conta corrente não foi encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long id){
    	contaCorrenteService.buscarPorId(id)
                .map(conta -> {
                    contaCorrenteService.removerPorId(conta.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Está conta corrente não foi encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarContaCorrente(@PathVariable("id") Long id, @RequestBody ContaCorrente conta){
    	contaCorrenteService.buscarPorId(id)
                .map(contaBase -> {
                    modelMapper.map(conta, contaBase);
                    contaCorrenteService.salvar(contaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Está conta corrente não foi encontrada."));
    }


}
