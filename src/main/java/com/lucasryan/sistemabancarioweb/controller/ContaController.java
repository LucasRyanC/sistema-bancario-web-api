package com.lucasryan.sistemabancarioweb.controller;

import com.lucasryan.sistemabancarioweb.model.Conta;
import com.lucasryan.sistemabancarioweb.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/contas")
    public class ContaController {
        @Autowired
        private ContaRepository repository;
        
        // CEATE
        @PostMapping
        public Conta criarConta(@RequestBody Conta novaConta) {
            return repository.save(novaConta);
        }
        //READ
        @GetMapping
        public List<Conta> listarTodas() {
            return repository.findAll();
        }
        // UPDATE
        @PutMapping("/{id}/deposito/{valor}")
        public Conta depositar(@PathVariable Long id, @PathVariable double valor) {
            Conta conta = repository.findById(id).orElseThrow();
            conta.setSaldo(conta.getSaldo() + valor);
            return repository.save(conta);
        }
        //DELETE
        @DeleteMapping("/{id}")
        public void deletarConta(@PathVariable Long id) {
            repository.deleteById(id);
        }
    }
    
