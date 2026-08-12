package com.lucasryan.sistemabancarioweb.repository;

import com.lucasryan.sistemabancarioweb.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}