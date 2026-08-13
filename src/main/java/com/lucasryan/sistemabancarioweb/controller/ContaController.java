package com.lucasryan.sistemabancarioweb.controller;

import com.lucasryan.sistemabancarioweb.model.Conta;
import com.lucasryan.sistemabancarioweb.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contas")
    public class ContaController {
        @Autowired
        private ContaService service;
        
        // CREATE
        @PostMapping
        public Conta criarConta(@RequestBody Conta novaConta) {
            return service.criarConta(novaConta);
        }
        //READ
        @GetMapping
        public List<Conta> listarTodas() {
            return service.listarTodas();
        }
        // UPDATE
        @PutMapping("/{id}/deposito/{valor}")
        public Conta depositar(@PathVariable Long id, @PathVariable double valor) {
            return service.depositar(id, valor);
        }
        //DELETE
        @DeleteMapping("/{id}")
        public void deletarConta(@PathVariable Long id) {
            service.deletarConta(id);
        }
    }
    
