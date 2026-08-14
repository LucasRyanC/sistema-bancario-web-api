package com.lucasryan.sistemabancarioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucasryan.sistemabancarioweb.model.Conta;
import com.lucasryan.sistemabancarioweb.repository.ContaRepository;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    public Conta criarConta(Conta novConta) {
        return repository.save(novConta);
    }

    public List<Conta> listarTodas() {
        return repository.findAll();
    }

    public Conta depositar(Long id, double valor) {
        
        if (valor <= 0) {
            throw new IllegalArgumentException("Erro: O valor do depósito deve ser maior que zero.");
        } 

        Conta conta = repository.findById(id).orElseThrow();
        conta.setSaldo(conta.getSaldo() + valor);
        return repository.save(conta);
    }

    public Conta sacar(Long id, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Erro: O valor do saque deve ser maior que zero.");
        }

        Conta conta = repository.findById(id).orElseThrow();

        if (conta.getSaldo() < valor) {
            throw new IllegalArgumentException("Erro: Saldo insuficiente para este saque.");
        }

        conta.setSaldo(conta.getSaldo() - valor);
        return repository.save(conta);
    }
    
    public void deletarConta(Long id) {
        repository.deleteById(id);
    }
}
